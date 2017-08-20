//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

/**
 *
 * @author adrianromero
 */
public class PaymentPanelFac {
    
    /** Creates a new instance of PaymentPanelFac */
    private PaymentPanelFac() {
    }
    
    public static PaymentPanel getPaymentPanel(String sReader, JPaymentNotifier notifier) {
        
        if ("Intelligent".equals(sReader)) {
            return new PaymentPanelMagCard(new MagCardReaderIntelligent(), notifier);
        } else if ("Generic".equals(sReader)) {
            return new PaymentPanelMagCard(new MagCardReaderGeneric(), notifier);
        } else if ("Keyboard".equals(sReader)) {
            return new PaymentPanelType(notifier);
        } else { // "Not defined
            return new PaymentPanelBasic(notifier);
        }
    }      
}
