//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerWriteBasic implements SerializerWrite<Object[]> {
    
    private Datas[] m_classes;
    
    /** Creates a new instance of SerializerWriteBasic */
    public SerializerWriteBasic(Datas[] classes) {
        m_classes = classes;
    }
    
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        for (int i = 0; i < m_classes.length; i++) {
            m_classes[i].setValue(dp, i + 1, obj[i]);
        }
    }
    
}
