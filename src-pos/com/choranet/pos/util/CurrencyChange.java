//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.util;

import java.text.*;

public final class CurrencyChange {

    public final static double EUROS_CHANGE = 166.386;

    private CurrencyChange() {
    }
  
    public static double changeEurosToPts(double dEuros) {        
        return Math.rint(dEuros * EUROS_CHANGE);
    }
    public static double changePtsToEuros(double dPts) {        
        return Math.rint(100.0 * dPts / EUROS_CHANGE) / 100.0;
    }   
}
