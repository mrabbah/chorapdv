//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.SerializableRead;
import com.choranet.format.Formats;

public class PaymentInfoTicket extends PaymentInfo implements SerializableRead  {
    
    private double m_dTicket;
    private String m_sName;
    
    /** Creates a new instance of PaymentInfoCash */
    public PaymentInfoTicket(double dTicket, String sName) {
        m_sName = sName;
        m_dTicket = dTicket;
    }
    
    public PaymentInfoTicket() {
        m_sName = null;
        m_dTicket = 0.0;
     }
    
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_dTicket = dr.getDouble(2).doubleValue();
    }
    
    public PaymentInfo copyPayment(){
        return new PaymentInfoTicket(m_dTicket, m_sName);
    }    
    public String getName() {
        return m_sName;
    }   
    public double getTotal() {
        return m_dTicket;
    }    
    public String printPaid() {
        return Formats.CURRENCY.formatValue(new Double(m_dTicket));
    }       
    
    // Especificas
    public String printPaperTotal() {
        // En una devolucion hay que cambiar el signo al total
        return Formats.CURRENCY.formatValue(new Double(-m_dTicket));
    }          
}
