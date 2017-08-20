//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerReadImage implements SerializerRead {
    
    public static final SerializerRead INSTANCE = new SerializerReadImage();
    
    /** Creates a new instance of SerializerReadImage */
    private SerializerReadImage() {
    }
    
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.IMAGE.getValue(dr,1);
    }    
    
}
