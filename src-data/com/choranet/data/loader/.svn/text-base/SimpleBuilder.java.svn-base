//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

/**
 *
 * @author  adrian
 */
public class SimpleBuilder implements ISQLBuilderStatic {
    
    private String m_sSentence;
    
    /** Creates a new instance of SimpleBuilder */
    public SimpleBuilder(String sSentence) {
        m_sSentence = sSentence;
    }
    
    public String getSQL(SerializerWrite sw, Object params) throws BasicException {
        return m_sSentence;
    }
    
}
