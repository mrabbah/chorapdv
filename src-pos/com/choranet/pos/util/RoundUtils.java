//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.util;

import com.choranet.format.Formats;

public class RoundUtils {
    
    /** Creates a new instance of DoubleUtils */
    private RoundUtils() {
    }
    
    public static double round(double dValue) {
        double fractionMultiplier = Math.pow(10.0, Formats.getCurrencyDecimals());
        return Math.rint(dValue * fractionMultiplier) / fractionMultiplier;
    }
    
    public static int compare(double d1, double d2) {
        
        return Double.compare(round(d1), round(d2));
    }   
    
    public static double getValue(Double value) {
        return value == null ? 0.0 : value.doubleValue();
    }
}
