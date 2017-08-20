//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerWriteInteger implements SerializerWrite<Integer> {
    
    public static final SerializerWrite INSTANCE = new SerializerWriteInteger();
    
    /** Creates a new instance of SerializerWriteInteger */
    private SerializerWriteInteger() {
    }
    
    public void writeValues(DataWrite dp, Integer obj) throws BasicException {
        Datas.INT.setValue(dp, 1, obj);
    }  
}