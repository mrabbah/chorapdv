//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

import com.choranet.pos.customers.CustomerInfoExt;
import java.awt.Component;
import com.choranet.pos.forms.AppLocal;

public class JPaymentFree extends javax.swing.JPanel implements JPaymentInterface {
    
    private double m_dTotal;
    private JPaymentNotifier m_notifier;
    
    /** Creates new form JPaymentFree */
    public JPaymentFree(JPaymentNotifier notifier) {
        m_notifier = notifier;
        initComponents();
    }
    public void activate(CustomerInfoExt customerext, double dTotal) {
        
        m_dTotal = dTotal;
        
        // m_jTotal.setText(Formats.CURRENCY.formatValue(new Double(m_dTotal)));
        
        m_notifier.setStatus(true, true);
    }
    
    public PaymentInfo executePayment() {
        return new PaymentInfoFree(m_dTotal);
    }
    public Component getComponent() {
        return this;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText(AppLocal.getIntString("message.paymentfree"));
        add(jLabel1);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
