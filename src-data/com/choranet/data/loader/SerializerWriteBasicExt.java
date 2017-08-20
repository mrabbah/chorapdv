//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerWriteBasicExt implements SerializerWrite<Object[]> {
    
    private Datas[] m_classes;
    private int[] m_index;
    
    /** Creates a new instance of SerializerWriteBasic */
    public SerializerWriteBasicExt(Datas[] classes, int[] index) {
        m_classes = classes;
        m_index = index;
    }
    
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        for (int i = 0; i < m_index.length; i++) {
            m_classes[m_index[i]].setValue(dp, i + 1, obj[m_index[i]]);
        }
    }
    
}