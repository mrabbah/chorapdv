//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.panels;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author adrianromero
 */
public class EnumerationIter implements Enumeration {
    
    private Iterator i;

    public EnumerationIter(Iterator i) {
        this.i = i;
    }
    public boolean hasMoreElements() {
        return i.hasNext();
    }
    public Object nextElement() {
        return i.next();
    } 
}
