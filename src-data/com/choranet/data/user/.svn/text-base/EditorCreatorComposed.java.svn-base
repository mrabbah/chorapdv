//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.user;

import com.choranet.basic.BasicException;

public class EditorCreatorComposed implements EditorCreator{
    
    private EditorCreator[] m_editors;
    
    /** Creates a new instance of EditorCreatorComposed */
    public EditorCreatorComposed(EditorCreator... editors) {
        m_editors = editors;
    }

    public Object createValue() throws BasicException {
        
        Object[] value = new Object[m_editors.length];
        for (int i = 0; i < m_editors.length; i++) {
            value[i] = m_editors[i].createValue();
        }
        
        return value;
    } 
}
