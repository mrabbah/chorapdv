//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.beans;

import java.util.EventObject;

/**
 *
 * @author adrianromero
 * @version 
 */
public class JNumberEvent extends EventObject {

    private char m_cKey;
    
    public JNumberEvent(Object source, char cKey) {
        super(source);
        m_cKey = cKey;
    }
    
    public char getKey() {
        return m_cKey;
    }

}
