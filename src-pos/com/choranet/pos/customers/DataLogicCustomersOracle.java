//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.customers;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.QBFBuilder;
import com.choranet.data.loader.SentenceList;
import com.choranet.data.loader.SerializerRead;
import com.choranet.data.loader.SerializerWriteBasic;
import com.choranet.data.loader.StaticSentence;

/**
 *
 * @author adrianromero
 */
public class DataLogicCustomersOracle extends DataLogicCustomers {
    
    // CustomerList list
    @Override
    public SentenceList getCustomerList() {
        return new StaticSentence(s
            , new QBFBuilder("SELECT ID, TAXID, SEARCHKEY, NAME FROM CUSTOMERS WHERE VISIBLE = 1 AND ?(QBF_FILTER) ORDER BY NAME", new String[] {"TAXID", "SEARCHKEY", "NAME"})
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
}
