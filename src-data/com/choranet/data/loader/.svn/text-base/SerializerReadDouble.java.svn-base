//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerReadDouble implements SerializerRead {
    
    public static final SerializerRead INSTANCE = new SerializerReadDouble();
    
    /** Creates a new instance of SerializerReadInteger */
    public SerializerReadDouble() {
    }
    
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.DOUBLE.getValue(dr,1);
    }    
}
