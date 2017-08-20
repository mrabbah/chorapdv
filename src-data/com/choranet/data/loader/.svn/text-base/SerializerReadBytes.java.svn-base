//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

/**
 *
 * @author Adrian
 */
public class SerializerReadBytes implements SerializerRead {
    
    public static final SerializerRead INSTANCE = new SerializerReadBytes();
    
    /** Creates a new instance of SerializerReadBytes */
    private SerializerReadBytes() {
    }
    
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.BYTES.getValue(dr,1);
    }       
}
