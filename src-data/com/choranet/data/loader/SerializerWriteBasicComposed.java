//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerWriteBasicComposed implements SerializerWrite<Object[]> {
    
    private Datas[][] m_classes;    
    
    /** Creates a new instance of SerializerWriteComposed */
    public SerializerWriteBasicComposed(Datas[]... classes) {
         m_classes = classes;
    }
    
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        int index = 0;
        for (int i = 0; i < m_classes.length; i++) {
            Object[] val = (Object[]) obj[i];
            for (int j = 0; j < m_classes[i].length; j++) {
                index++;
                m_classes[i][j].setValue(dp, index, val[j]);
            }
        }
    }  
}
