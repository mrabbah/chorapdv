//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.config;

import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author adrianromero
 */
public class LocaleComparator implements Comparator<Locale> {
    
    /** Creates a new instance of LocaleComparator */
    public LocaleComparator() {
    }
    
    public int compare(Locale o1, Locale o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
