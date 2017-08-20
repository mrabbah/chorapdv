//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com


package com.choranet.data.loader;

/**
 *
 * @author  adrian
 */
public class KeyGetterBasic implements IKeyGetter {
    
    private int [] m_aElems;
    
    /** Creates a new instance of KeyGetterBasic */
    public KeyGetterBasic(int[] aElems) {
        m_aElems = aElems;
    }
    
    public Object getKey(Object value) {
        if (value == null) {
            return null;
        } else {
            Object[] avalue = (Object []) value;
            Object[] akey = new Object[m_aElems.length];
            for (int i = 0; i < m_aElems.length; i++) {
                akey[i] = avalue[m_aElems[i]];
            }
            return akey;
        }
    }   
}
