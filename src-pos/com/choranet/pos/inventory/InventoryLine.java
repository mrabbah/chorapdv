//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import com.choranet.format.Formats;
import com.choranet.pos.ticket.ProductInfoExt;

/**
 *
 * @author adrianromero
 */
public class InventoryLine {
    
    private double m_dMultiply;    
    private double m_dPrice;
    
    private String m_sProdID;
    private String m_sProdName;
 
    /** Creates a new instance of InventoryLine */
    public InventoryLine(ProductInfoExt oProduct) {
        m_sProdID = oProduct.getID();
        m_sProdName = oProduct.getName();
        m_dMultiply = 1.0;
        m_dPrice = oProduct.getPriceBuy();
    }
    
    public InventoryLine(ProductInfoExt oProduct, double dpor, double dprice) {
        m_sProdID = oProduct.getID();
        m_sProdName = oProduct.getName();
        m_dMultiply = dpor;
        m_dPrice = dprice;
    }
    
    public String getProductID() {
        return m_sProdID;
    }    
    
    public String getProductName() {
        return m_sProdName;
    } 
    public void setProductName(String sValue) {
        if (m_sProdID == null) {
            m_sProdName = sValue;
        }
    }
    public double getMultiply() {
        return m_dMultiply;
    }
    
    public void setMultiply(double dValue) {
        m_dMultiply = dValue;
    }
    
    public double getPrice() {
        return m_dPrice;
    }
    
    public void setPrice(double dValue) {
        m_dPrice = dValue;
    }    
    
    public double getSubValue() {
        return m_dMultiply * m_dPrice;
    }
    
    public String printName() {
        return m_sProdName;
    }
    
    public String printPrice() {
        if (m_dMultiply == 1.0) {
            return "";
        } else {
            return Formats.CURRENCY.formatValue(new Double(getPrice()));
        }
    }
    
    public String printMultiply() {
        return Formats.DOUBLE.formatValue(new Double(m_dMultiply));
    }
    
    public String printSubValue() {
        return Formats.CURRENCY.formatValue(new Double(getSubValue()));
    }
    
}
