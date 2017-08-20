//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.QBFBuilder;
import com.choranet.data.loader.SentenceList;
import com.choranet.data.loader.SerializerReadBasic;
import com.choranet.data.loader.SerializerReadInteger;
import com.choranet.data.loader.SerializerWriteBasic;
import com.choranet.data.loader.SerializerWriteString;
import com.choranet.data.loader.StaticSentence;
import com.choranet.pos.customers.CustomerInfoExt;

/**
 *
 * @author adrianromero
 */
public class DataLogicSalesOracle extends DataLogicSales {
    
    /** Creates a new instance of SentenceContainerOracle */
    public DataLogicSalesOracle() {
    }
    
    public final SentenceList getProductCatQBF() {
        return new StaticSentence(s
            , new QBFBuilder(
                "SELECT P.ID, P.REFERENCE, P.CODE, P.NAME, P.ISCOM, P.ISSCALE, P.PRICEBUY, P.PRICESELL, P.CATEGORY, P.TAXCAT, P.IMAGE, P.STOCKCOST, P.STOCKVOLUME, CASE WHEN C.PRODUCT IS NULL THEN 0 ELSE 1 END, C.CATORDER, P.ATTRIBUTES " +
                "FROM PRODUCTS P LEFT OUTER JOIN PRODUCTS_CAT C ON P.ID = C.PRODUCT " +
                "WHERE ?(QBF_FILTER) " +
                "ORDER BY P.REFERENCE", new String[] {"P.NAME", "P.PRICEBUY", "P.PRICESELL", "P.CATEGORY", "P.CODE"})
            , new SerializerWriteBasic(new Datas[] {Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.DOUBLE, Datas.OBJECT, Datas.DOUBLE, Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING})
            , new SerializerReadBasic(productcatDatas));
    }        
  
    public final Integer getNextTicketIndex() throws BasicException {
        return (Integer) new StaticSentence(s, "SELECT TICKETSNUM.NEXTVAL FROM DUAL", null, SerializerReadInteger.INSTANCE).find();
    }   
    
    @Override
    public CustomerInfoExt findCustomerExt(String card) throws BasicException {
        return (CustomerInfoExt) new PreparedSentence(s
                , "SELECT ID, TAXID, SEARCHKEY, NAME, TAXCATEGORY, CARD, NOTES, MAXDEBT, VISIBLE, CURDATE, CURDEBT" +
                  ", FIRSTNAME, LASTNAME, EMAIL, PHONE, PHONE2, FAX" +
                  ", ADDRESS, ADDRESS2, POSTAL, CITY, REGION, COUNTRY" +
                  " FROM CUSTOMERS WHERE CARD = ? AND VISIBLE = 1"
                , SerializerWriteString.INSTANCE
                , new CustomerExtRead()).find(card);        
    }    
}