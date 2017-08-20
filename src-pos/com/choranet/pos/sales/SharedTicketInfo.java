//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.DataWrite;
import com.choranet.data.loader.SerializableRead;
import com.choranet.data.loader.SerializableWrite;

/**
 *
 * @author adrianromero
 */
public class SharedTicketInfo implements SerializableRead, SerializableWrite {
    
    private String id;
    private String name;
    
    /** Creates a new instance of SharedTicketInfo */
    public SharedTicketInfo() {
    }
    
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
    }   
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, id);
        dp.setString(2, name);
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }  
}
