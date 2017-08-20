//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

public class PaymentInfoFree extends PaymentInfo {
    
    private double m_dTotal;
   
    /** Creates a new instance of PaymentInfoFree */
    public PaymentInfoFree(double dTotal) {
        m_dTotal = dTotal;
    }
    
    public PaymentInfo copyPayment(){
        return new PaymentInfoFree(m_dTotal);
    }    
    public String getName() {
        return "free";
    }   
    public double getTotal() {
        return m_dTotal;
    }       
}
