//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

import com.choranet.format.Formats;

public abstract class PaymentInfo {
    
    public abstract String getName();
    public abstract double getTotal();
    public abstract PaymentInfo copyPayment();
    
    public String printTotal() {
        return Formats.CURRENCY.formatValue(new Double(getTotal()));
    }
}
