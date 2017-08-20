//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import java.sql.SQLException;
import com.choranet.basic.BasicException;

/**
 *
 * @author adrianromero
 * Created on 26 de febrero de 2007, 21:50
 *
 */
public abstract class Transaction<T> {
    
    private Session s;
    
    /** Creates a new instance of Transaction */
    public Transaction(Session s) {
        this.s = s;
    }
    
    public final T execute() throws BasicException {
        
        if (s.isTransaction()) {
            return transact();
        } else {
            try {
                try {    
                    s.begin();
                    T result = transact();
                    s.commit();
                    return result;
                } catch (BasicException e) {
                    s.rollback();
                    throw e;
                }
            } catch (SQLException eSQL) {
                throw new BasicException("Transaction error", eSQL);
            }
        }
    }
    
    protected abstract T transact() throws BasicException;
}
