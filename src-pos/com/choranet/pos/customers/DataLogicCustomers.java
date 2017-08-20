//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.customers;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataParams;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.QBFBuilder;
import com.choranet.data.loader.SentenceExec;
import com.choranet.data.loader.SentenceExecTransaction;
import com.choranet.data.loader.SentenceList;
import com.choranet.data.loader.SerializerRead;
import com.choranet.data.loader.SerializerReadBasic;
import com.choranet.data.loader.SerializerWriteBasic;
import com.choranet.data.loader.SerializerWriteBasicExt;
import com.choranet.data.loader.SerializerWriteParams;
import com.choranet.data.loader.Session;
import com.choranet.data.loader.StaticSentence;
import com.choranet.data.loader.TableDefinition;
import com.choranet.format.Formats;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.BeanFactoryDataSingle;

/**
 *
 * @author adrianromero
 */
public class DataLogicCustomers extends BeanFactoryDataSingle {
    
    protected Session s;
    private TableDefinition tcustomers;
    private static Datas[] customerdatas = new Datas[] {Datas.STRING, Datas.TIMESTAMP, Datas.TIMESTAMP, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.INT, Datas.BOOLEAN, Datas.STRING};
    
    public void init(Session s){
        
        this.s = s;
        tcustomers = new TableDefinition(s
            , "CUSTOMERS"
            , new String[] { "ID", "TAXID", "SEARCHKEY", "NAME", "NOTES", "VISIBLE", "CARD", "MAXDEBT", "CURDATE", "CURDEBT"
                           , "FIRSTNAME", "LASTNAME", "EMAIL", "PHONE", "PHONE2", "FAX"
                           , "ADDRESS", "ADDRESS2", "POSTAL", "CITY", "REGION", "COUNTRY"
                           , "TAXCATEGORY" }
            , new String[] { "ID", AppLocal.getIntString("label.taxid"), AppLocal.getIntString("label.searchkey"), AppLocal.getIntString("label.name"), AppLocal.getIntString("label.notes"), "VISIBLE", "CARD", AppLocal.getIntString("label.maxdebt"), AppLocal.getIntString("label.curdate"), AppLocal.getIntString("label.curdebt")
                           , AppLocal.getIntString("label.firstname"), AppLocal.getIntString("label.lastname"), AppLocal.getIntString("label.email"), AppLocal.getIntString("label.phone"), AppLocal.getIntString("label.phone2"), AppLocal.getIntString("label.fax")
                           , AppLocal.getIntString("label.address"), AppLocal.getIntString("label.address2"), AppLocal.getIntString("label.postal"), AppLocal.getIntString("label.city"), AppLocal.getIntString("label.region"), AppLocal.getIntString("label.country")
                           , "TAXCATEGORY"}
            , new Datas[] { Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.BOOLEAN, Datas.STRING, Datas.DOUBLE, Datas.TIMESTAMP, Datas.DOUBLE
                          , Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING
                          , Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING
                          , Datas.STRING}
            , new Formats[] { Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.BOOLEAN, Formats.STRING, Formats.CURRENCY, Formats.TIMESTAMP, Formats.CURRENCY
                            , Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING
                            , Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING
                            , Formats.STRING}
            , new int[] {0}
        );   
        
    }
    
    // CustomerList list
    public SentenceList getCustomerList() {
        return new StaticSentence(s
            , new QBFBuilder("SELECT ID, TAXID, SEARCHKEY, NAME FROM CUSTOMERS WHERE VISIBLE = TRUE AND ?(QBF_FILTER) ORDER BY NAME", new String[] {"TAXID", "SEARCHKEY", "NAME"})
            , new SerializerWriteBasic(new Datas[] {Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING})
            , new SerializerRead() {
                    public Object readValues(DataRead dr) throws BasicException {
                        CustomerInfo c = new CustomerInfo(dr.getString(1));
                        c.setTaxid(dr.getString(2));
                        c.setSearchkey(dr.getString(3));
                        c.setName(dr.getString(4));
                        return c;
                    }                
                });
    }
       
    public int updateCustomerExt(final CustomerInfoExt customer) throws BasicException {
     
        return new PreparedSentence(s
                , "UPDATE CUSTOMERS SET NOTES = ? WHERE ID = ?"
                , SerializerWriteParams.INSTANCE      
                ).exec(new DataParams() { public void writeValues() throws BasicException {
                        setString(1, customer.getNotes());
                        setString(2, customer.getId());
                }});        
    }
    
    public final SentenceList getReservationsList() {
        return new PreparedSentence(s
            , "SELECT R.ID, R.CREATED, R.DATENEW, C.CUSTOMER, CUSTOMERS.TAXID, CUSTOMERS.SEARCHKEY, COALESCE(CUSTOMERS.NAME, R.TITLE),  R.CHAIRS, R.ISDONE, R.DESCRIPTION " +
              "FROM RESERVATIONS R LEFT OUTER JOIN RESERVATION_CUSTOMERS C ON R.ID = C.ID LEFT OUTER JOIN CUSTOMERS ON C.CUSTOMER = CUSTOMERS.ID " +
              "WHERE R.DATENEW >= ? AND R.DATENEW < ?"
            , new SerializerWriteBasic(new Datas[] {Datas.TIMESTAMP, Datas.TIMESTAMP})
            , new SerializerReadBasic(customerdatas));             
    }
    
    public final SentenceExec getReservationsUpdate() {
        return new SentenceExecTransaction(s) {
            public int execInTransaction(Object params) throws BasicException {  
    
                new PreparedSentence(s
                    , "DELETE FROM RESERVATION_CUSTOMERS WHERE ID = ?"
                    , new SerializerWriteBasicExt(customerdatas, new int[]{0})).exec(params);
                if (((Object[]) params)[3] != null) {
                    new PreparedSentence(s
                        , "INSERT INTO RESERVATION_CUSTOMERS (ID, CUSTOMER) VALUES (?, ?)"
                        , new SerializerWriteBasicExt(customerdatas, new int[]{0, 3})).exec(params);                
                }
                return new PreparedSentence(s
                    , "UPDATE RESERVATIONS SET ID = ?, CREATED = ?, DATENEW = ?, TITLE = ?, CHAIRS = ?, ISDONE = ?, DESCRIPTION = ? WHERE ID = ?"
                    , new SerializerWriteBasicExt(customerdatas, new int[]{0, 1, 2, 6, 7, 8, 9, 0})).exec(params);
            }
        };
    }
    
    public final SentenceExec getReservationsDelete() {
        return new SentenceExecTransaction(s) {
            public int execInTransaction(Object params) throws BasicException {  
    
                new PreparedSentence(s
                    , "DELETE FROM RESERVATION_CUSTOMERS WHERE ID = ?"
                    , new SerializerWriteBasicExt(customerdatas, new int[]{0})).exec(params);
                return new PreparedSentence(s
                    , "DELETE FROM RESERVATIONS WHERE ID = ?"
                    , new SerializerWriteBasicExt(customerdatas, new int[]{0})).exec(params);
            }
        };
    }
    
    public final SentenceExec getReservationsInsert() {
        return new SentenceExecTransaction(s) {
            public int execInTransaction(Object params) throws BasicException {  
    
                int i = new PreparedSentence(s
                    , "INSERT INTO RESERVATIONS (ID, CREATED, DATENEW, TITLE, CHAIRS, ISDONE, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?)"
                    , new SerializerWriteBasicExt(customerdatas, new int[]{0, 1, 2, 6, 7, 8, 9})).exec(params);

                if (((Object[]) params)[3] != null) {
                    new PreparedSentence(s
                        , "INSERT INTO RESERVATION_CUSTOMERS (ID, CUSTOMER) VALUES (?, ?)"
                        , new SerializerWriteBasicExt(customerdatas, new int[]{0, 3})).exec(params);                
                }
                return i;
            }
        };
    }
    
    public final TableDefinition getTableCustomers() {
        return tcustomers;
    }  
}
