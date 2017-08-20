//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public class SerializerReadClass implements SerializerRead {

    private Class m_clazz;
    
    /** Creates a new instance of DefaultSerializerRead */
    public SerializerReadClass(Class clazz) {
        m_clazz = clazz;
    }
    
    public Object readValues(DataRead dr) throws BasicException {
        try {
            SerializableRead sr = (SerializableRead) m_clazz.newInstance();
            sr.readValues(dr);
            return sr;
        } catch (java.lang.InstantiationException eIns) {
            return null;
        } catch (IllegalAccessException eIA) {
            return null;
        } catch (ClassCastException eCC) {
            return null;
        }
    }
}
