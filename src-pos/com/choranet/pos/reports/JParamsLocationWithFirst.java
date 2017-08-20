//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.reports;

import java.util.List;

/**
 *
 * @author adrian
 */
public class JParamsLocationWithFirst extends JParamsLocation {
    
    /** Creates a new instance of JParamsLocationWithFirst */
    public JParamsLocationWithFirst() {
        super();
    }
    
    protected void addFirst(List a) {
        a.add(0, null);
    }    
}
