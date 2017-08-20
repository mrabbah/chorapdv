//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

import com.choranet.pos.customers.CustomerInfoExt;
import java.awt.Component;

/**
 *
 * @author Adrian
 */
public interface JPaymentInterface {
    
    public void activate(CustomerInfoExt customerext, double dTotal);    
    public PaymentInfo executePayment();
    public Component getComponent();
}
