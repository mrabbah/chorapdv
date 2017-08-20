//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.QBFBuilder;
import com.choranet.data.loader.SentenceList;
import com.choranet.data.loader.SerializerReadBasic;
import com.choranet.data.loader.SerializerReadInteger;
import com.choranet.data.loader.SerializerWriteBasic;
import com.choranet.data.loader.StaticSentence;

/**
 *
 * @author adrianromero
 */
public class DataLogicSalesHSQLDB extends DataLogicSales {
    
    /** Creates a new instance of SentenceContainerHSQLDB */
    public DataLogicSalesHSQLDB() {
    }

    public final SentenceList getProductCatQBF() {
        return new StaticSentence(s
            , new QBFBuilder(
                "SELECT P.ID, P.REFERENCE, P.CODE, P.NAME, P.ISCOM, P.ISSCALE, P.PRICEBUY, P.PRICESELL, P.CATEGORY, P.TAXCAT, P.IMAGE, P.STOCKCOST, P.STOCKVOLUME, NOT (C.PRODUCT IS NULL), C.CATORDER, P.ATTRIBUTES " +
                "FROM PRODUCTS P LEFT OUTER JOIN PRODUCTS_CAT C ON P.ID = C.PRODUCT " +
                "WHERE ?(QBF_FILTER) " +
                "ORDER BY P.REFERENCE", new String[] {"P.NAME", "P.PRICEBUY", "P.PRICESELL", "P.CATEGORY", "P.CODE"})
            , new SerializerWriteBasic(new Datas[] {Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.DOUBLE, Datas.OBJECT, Datas.DOUBLE, Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING})
            , new SerializerReadBasic(productcatDatas));
    }    

    public final Integer getNextTicketIndex() throws BasicException {
        return (Integer) new StaticSentence(s, "CALL NEXT VALUE FOR TICKETSNUM", null, SerializerReadInteger.INSTANCE).find();
    }
}
