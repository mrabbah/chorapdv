//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

/**
 *
 * @author adrianromero
 */
public class SerializerWriteParams  implements SerializerWrite<DataParams>{
    
    public static final SerializerWrite INSTANCE = new SerializerWriteParams();
    
    public void writeValues(DataWrite dp, DataParams obj) throws BasicException {
        obj.setDataWrite(dp);
        obj.writeValues();
        obj.setDataWrite(null);
    }     
}
