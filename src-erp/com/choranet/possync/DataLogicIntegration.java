//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.possync;

import java.util.List;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataParams;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.ImageUtils;
import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.SerializerRead;
import com.choranet.data.loader.SerializerReadClass;
import com.choranet.data.loader.SerializerWriteParams;
import com.choranet.data.loader.SerializerWriteString;
import com.choranet.data.loader.Session;
import com.choranet.data.loader.StaticSentence;
import com.choranet.data.loader.Transaction;
import com.choranet.pos.customers.CustomerInfoExt;
import com.choranet.pos.forms.BeanFactoryDataSingle;
import com.choranet.pos.inventory.TaxCategoryInfo;
import com.choranet.pos.payment.PaymentInfoTicket;
import com.choranet.pos.ticket.CategoryInfo;
import com.choranet.pos.ticket.ProductInfoExt;
import com.choranet.pos.ticket.TaxInfo;
import com.choranet.pos.ticket.TicketInfo;
import com.choranet.pos.ticket.TicketLineInfo;

/**
 *
 * @author adrianromero
 * Created on 5 de marzo de 2007, 19:56
 *
 */
public abstract class DataLogicIntegration extends BeanFactoryDataSingle {
    
    protected Session s;

    /** Creates a new instance of DataLogicIntegration */
    public DataLogicIntegration() {
    }
    
    public void init(Session s) {
        this.s = s;
    }
     
    public abstract void syncCustomersBefore() throws BasicException;
    
    public abstract void syncCustomer(final CustomerInfoExt customer) throws BasicException;
        
    
    public void syncProductsBefore() throws BasicException {
        new StaticSentence(s, "DELETE FROM PRODUCTS_CAT").exec();
    }   
    
    public void syncTaxCategory(final TaxCategoryInfo taxcat) throws BasicException {
        
        Transaction t = new Transaction(s) {
            public Object transact() throws BasicException {
                // Sync the Tax in a transaction
                
                // Try to update                
                if (new PreparedSentence(s, 
                            "UPDATE TAXCATEGORIES SET NAME = ?  WHERE ID = ?",
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, taxcat.getName());
                                setString(2, taxcat.getID());                                    
                            }}) == 0) {
                       
                    // If not updated, try to insert
                    new PreparedSentence(s, 
                            "INSERT INTO TAXCATEGORIES(ID, NAME) VALUES (?, ?)", 
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, taxcat.getID());
                                setString(2, taxcat.getName());
                            }});
                }
                
                return null;
            }
        };
        t.execute();                   
    }
    
    public void syncTax(final TaxInfo tax) throws BasicException {
        
        Transaction t = new Transaction(s) {
            public Object transact() throws BasicException {
                // Sync the Tax in a transaction
                
                // Try to update                
                if (new PreparedSentence(s, 
                            "UPDATE TAXES SET NAME = ?, CATEGORY = ?, CUSTCATEGORY = ?, PARENTID = ?, RATE = ?, RATECASCADE = ? WHERE ID = ?",
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, tax.getName());
                                setString(2, tax.getTaxCategoryID());
                                setString(3, tax.getTaxCustCategoryID());
                                setString(4, tax.getParentID());
                                setDouble(5, tax.getRate());
                                setBoolean(6, tax.isCascade());
                                setString(7, tax.getId());       
                            }}) == 0) {
                       
                    // If not updated, try to insert
                    new PreparedSentence(s, 
                            "INSERT INTO TAXES(ID, NAME, CATEGORY, CUSTCATEGORY, PARENTID, RATE, RATECASCADE) VALUES (?, ?, ?, ?, ?, ?, ?)", 
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, tax.getId());
                                setString(2, tax.getName());
                                setString(3, tax.getTaxCategoryID());
                                setString(4, tax.getTaxCustCategoryID());
                                setString(5, tax.getParentID());                                
                                setDouble(6, tax.getRate());
                                setBoolean(7, tax.isCascade());
                            }});
                }
                
                return null;
            }
        };
        t.execute();                   
    }
    
    public void syncCategory(final CategoryInfo cat) throws BasicException {
        
        Transaction t = new Transaction(s) {
            public Object transact() throws BasicException {
                // Sync the Category in a transaction
                
                // Try to update
                if (new PreparedSentence(s, 
                            "UPDATE CATEGORIES SET NAME = ?, IMAGE = ? WHERE ID = ?", 
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                 setString(1, cat.getName());
                                 setBytes(2, ImageUtils.writeImage(cat.getImage()));
                                 setString(3, cat.getID());                                   
                            }}) == 0) {
                       
                    // If not updated, try to insert
                    new PreparedSentence(s, 
                        "INSERT INTO CATEGORIES(ID, NAME, IMAGE) VALUES (?, ?, ?)",
                        SerializerWriteParams.INSTANCE
                        ).exec(new DataParams() { public void writeValues() throws BasicException {
                            setString(1, cat.getID());
                            setString(2, cat.getName());
                            setBytes(3, ImageUtils.writeImage(cat.getImage()));
                        }});
                }
                return null;        
            }
        };
        t.execute();        
    }    
    
    public void syncProduct(final ProductInfoExt prod) throws BasicException {
        
        Transaction t = new Transaction(s) {
            public Object transact() throws BasicException {
                // Sync the Product in a transaction
                
                // Try to update
                if (new PreparedSentence(s, 
                            "UPDATE PRODUCTS SET REFERENCE = ?, CODE = ?, NAME = ?, PRICEBUY = ?, PRICESELL = ?, CATEGORY = ?, TAXCAT = ?, IMAGE = ? WHERE ID = ?", 
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, prod.getReference());
                                setString(2, prod.getCode());
                                setString(3, prod.getName());
                                // setBoolean(x, p.isCom());
                                // setBoolean(x, p.isScale());
                                setDouble(4, prod.getPriceBuy());
                                setDouble(5, prod.getPriceSell());
                                setString(6, prod.getCategoryID());
                                setString(7, prod.getTaxCategoryID());
                                setBytes(8, ImageUtils.writeImage(prod.getImage()));
                                // setDouble(x, 0.0);
                                // setDouble(x, 0.0);
                                setString(9, prod.getID());  
                            }}) == 0) {
                            
                    // If not updated, try to insert
                    new PreparedSentence(s, 
                            "INSERT INTO PRODUCTS (ID, REFERENCE, CODE, NAME, ISCOM, ISSCALE, PRICEBUY, PRICESELL, CATEGORY, TAXCAT, IMAGE, STOCKCOST, STOCKVOLUME) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, prod.getID());
                                setString(2, prod.getReference());
                                setString(3, prod.getCode());
                                setString(4, prod.getName());
                                setBoolean(5, prod.isCom());
                                setBoolean(6, prod.isScale());
                                setDouble(7, prod.getPriceBuy());
                                setDouble(8, prod.getPriceSell());
                                setString(9, prod.getCategoryID());
                                setString(10, prod.getTaxCategoryID());
                                setBytes(11, ImageUtils.writeImage(prod.getImage()));
                                setDouble(12, 0.0);
                                setDouble(13, 0.0);                               
                            }});
                }
                        
                // Insert in catalog
                new StaticSentence(s, 
                        "INSERT INTO PRODUCTS_CAT(PRODUCT, CATORDER) VALUES (?, NULL)",
                        SerializerWriteString.INSTANCE
                        ).exec(prod.getID());   
                
                return null;        
            }
        };
        t.execute();     
    }
    
    public List getTickets() throws BasicException {
        return new PreparedSentence(s
                , "SELECT T.ID, T.TICKETID, R.DATENEW, R.MONEY, P.ID, P.NAME, C.ID, C.TAXID, C.SEARCHKEY, C.NAME FROM RECEIPTS R JOIN TICKETS T ON R.ID = T.ID LEFT OUTER JOIN PEOPLE P ON T.PERSON = P.ID LEFT OUTER JOIN CUSTOMERS C ON T.CUSTOMER = C.ID WHERE T.STATUS = 0"
                , null
                , new SerializerReadClass(TicketInfo.class)).list();
    }
    public List getTicketLines(final String ticket) throws BasicException {
        return new PreparedSentence(s
                , "SELECT L.TICKET, L.LINE, L.PRODUCT, L.UNITS, L.PRICE, T.ID, T.NAME, T.CATEGORY, T.CUSTCATEGORY, T.PARENTID, T.RATE, T.RATECASCADE, T.RATEORDER, L.ATTRIBUTES " +
                  "FROM TICKETLINES L, TAXES T WHERE L.TAXID = T.ID AND L.TICKET = ?"
                , SerializerWriteString.INSTANCE
                , new SerializerReadClass(TicketLineInfo.class)).list(ticket);
    }
    public List getTicketPayments(final String ticket) throws BasicException {
        return new PreparedSentence(s
                , "SELECT TOTAL, PAYMENT FROM PAYMENTS WHERE RECEIPT = ?"
                , SerializerWriteString.INSTANCE
                , new SerializerRead() {
                    public Object readValues(DataRead dr) throws BasicException {
                        return new PaymentInfoTicket(
                                dr.getDouble(1),
                                dr.getString(2));
                    }                
                }).list(ticket);
    }    

    public void execTicketUpdate() throws BasicException {
        new StaticSentence(s, "UPDATE TICKETS SET STATUS = 1 WHERE STATUS = 0").exec();
    }
}
