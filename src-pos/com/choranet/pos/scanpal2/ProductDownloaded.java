//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scanpal2;

public class ProductDownloaded {
    
    private String m_sCode;
    private double m_dQuantity;
    
    public ProductDownloaded() {
    }
    
    public void setCode(String value) {
        m_sCode = value;
    }
    public String getCode() {
        return m_sCode;
    }
    public void setQuantity(double value) {
        m_dQuantity = value;
    }
    public double getQuantity() {
        return m_dQuantity;
    }
}