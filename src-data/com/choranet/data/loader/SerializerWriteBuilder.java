//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerWriteBuilder implements SerializerWrite<SerializableWrite> {
    
    public static final SerializerWrite INSTANCE = new SerializerWriteBuilder();
    
    /** Creates a new instance of SerializerWriteBuilder */
    private SerializerWriteBuilder() {
    }
    
    public void writeValues(DataWrite dp, SerializableWrite obj) throws BasicException {
        obj.writeValues(dp);
    }
}
