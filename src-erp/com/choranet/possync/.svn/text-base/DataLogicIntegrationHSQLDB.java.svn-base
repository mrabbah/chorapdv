//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.possync;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataParams;
import com.choranet.data.loader.DataWrite;
import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.SerializerWrite;
import com.choranet.data.loader.SerializerWriteParams;
import com.choranet.data.loader.StaticSentence;
import com.choranet.data.loader.Transaction;
import com.choranet.pos.customers.CustomerInfoExt;

/**
 *
 * @author adrianromero
 */
public class DataLogicIntegrationHSQLDB extends DataLogicIntegration {
    
    /** Creates a new instance of DataLogicIntegrationHSQLDB */
    public DataLogicIntegrationHSQLDB() {
    }
    
    @Override
    public void syncCustomersBefore() throws BasicException {
        new StaticSentence(s, "UPDATE CUSTOMERS SET VISIBLE = FALSE").exec();
    }
    
    @Override
    public void syncCustomer(final CustomerInfoExt customer) throws BasicException {
        
        Transaction t = new Transaction(s) {
            public Object transact() throws BasicException {
                // Sync the Customer in a transaction
                
                // Try to update                
                if (new PreparedSentence(s, 
                            "UPDATE CUSTOMERS SET SEARCHKEY = ?, NAME = ?, NOTES = ?, VISIBLE = TRUE WHERE ID = ?",
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, customer.getSearchkey());
                                setString(2, customer.getName());
                                setString(3, customer.getAddress());
                                setString(4, customer.getId());                                   
                            }}) == 0) {
                       
                    // If not updated, try to insert
                    new PreparedSentence(s, 
                            "INSERT INTO CUSTOMERS(ID, SEARCHKEY, NAME, NOTES, VISIBLE) VALUES (?, ?, ?, ?, TRUE)", 
                            SerializerWriteParams.INSTANCE
                            ).exec(new DataParams() { public void writeValues() throws BasicException {
                                setString(1, customer.getId());
                                setString(2, customer.getSearchkey());
                                setString(3, customer.getName());
                                setString(4, customer.getAddress());                                    
                            }});
                }
                
                return null;
            }
        };
        t.execute(); 
    }
}
