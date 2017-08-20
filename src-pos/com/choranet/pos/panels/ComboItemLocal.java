//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.panels;

import com.choranet.data.loader.IKeyed;
import com.choranet.pos.forms.AppLocal;

/**
 *
 * @author adrianromero
 * Created on February 12, 2007, 10:49 PM
 *
 */
public class ComboItemLocal implements IKeyed {

    protected Integer m_iKey;
    protected String m_sKeyValue;

    public ComboItemLocal(Integer iKey, String sKeyValue) {
        m_iKey = iKey;
        m_sKeyValue = sKeyValue;
    }
    public Object getKey() {
        return m_iKey;
    }
    public Object getValue() {
        return m_sKeyValue;
    }
    public String toString() {
        return AppLocal.getIntString(m_sKeyValue);
    }
} 
