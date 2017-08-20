//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.ticket;

import java.io.*;
import com.choranet.pos.util.StringUtils;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.SerializableRead;
import com.choranet.data.loader.DataWrite;
import com.choranet.format.Formats;
import com.choranet.data.loader.SerializableWrite;
import com.choranet.basic.BasicException;
import com.choranet.pos.forms.AppLocal;
import java.util.Properties;

/**
 *
 * @author adrianromero
 */
public class TicketLineInfo implements SerializableWrite, SerializableRead, Serializable {
    
    private String m_sTicket;
    private int m_iLine;
    
    private double multiply;    
    private double price;
    
    private TaxInfo tax;
    private Properties attributes;
    
    private String productid;

    /** Creates new TicketLineInfo */   
     public TicketLineInfo(String productid, double dMultiply, double dPrice, TaxInfo tax, Properties props) {
        init(productid, dMultiply, dPrice, tax, props);
    }
     
    public TicketLineInfo(String productid, double dMultiply, double dPrice, TaxInfo tax) {
        init(productid, dMultiply, dPrice, tax, new Properties());
    }
    
    public TicketLineInfo(String productname, String producttaxcategory, double dMultiply, double dPrice, TaxInfo tax) {
        
        Properties props = new Properties();
        props.setProperty("product.name", productname);
        props.setProperty("product.taxcategoryid", producttaxcategory);
        init(null, dMultiply, dPrice, tax, props);
    }
     
     public TicketLineInfo() {
        init(null, 0.0, 0.0, null, new Properties());
    }
     
    public TicketLineInfo(ProductInfoExt product, double dMultiply, double dPrice, TaxInfo tax, Properties attributes) {
        
        String pid;
        
        if (product == null) {
            pid = null;
        } else {
            pid = product.getID();
            attributes.setProperty("product.name", product.getName());
            attributes.setProperty("product.com", product.isCom() ? "true" : "false");
            attributes.setProperty("product.taxcategoryid", product.getTaxCategoryID());
            if (product.getCategoryID() != null) {
                attributes.setProperty("product.categoryid", product.getCategoryID());
            }
        }    
        init(pid, dMultiply, dPrice, tax, attributes);
    }    
    public TicketLineInfo(ProductInfoExt oProduct, double dPrice, TaxInfo tax, Properties attributes) {       
        this(oProduct, 1.0, dPrice, tax, attributes);
    }
        
    public TicketLineInfo(TicketLineInfo line) {  
        init(line.productid, line.multiply, line.price, line.tax, (Properties) line.attributes.clone());
    }
    
    private void init(String productid, double dMultiply, double dPrice, TaxInfo tax, Properties attributes) {
        
        this.productid = productid; 
        multiply = dMultiply;
        price = dPrice;
        this.tax = tax;
        this.attributes = attributes;
        
        m_sTicket = null;
        m_iLine = -1;
    }
     
    void setTicket(String ticket, int line) {
        m_sTicket = ticket;
        m_iLine = line;
    }
    
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, m_sTicket);
        dp.setInt(2, new Integer(m_iLine));
        dp.setString(3, productid);
        
        dp.setDouble(4, new Double(multiply));
        dp.setDouble(5, new Double(price));
        
        dp.setString(6, tax.getId());
        try {
            ByteArrayOutputStream o = new ByteArrayOutputStream();
            attributes.storeToXML(o, AppLocal.APP_NAME, "UTF-8");
            dp.setBytes(7, o.toByteArray()); 
        } catch (IOException e) {
            dp.setBytes(7, null);
        } 
    }
    
    public void readValues(DataRead dr) throws BasicException {
        m_sTicket = dr.getString(1);
        m_iLine = dr.getInt(2).intValue();        
        productid = dr.getString(3);
        
        multiply = dr.getDouble(4);       
        price = dr.getDouble(5);
        
        tax = new TaxInfo(dr.getString(6), dr.getString(7), dr.getString(8), dr.getString(9), dr.getString(10), dr.getDouble(11), dr.getBoolean(12), dr.getInt(13));
        attributes = new Properties();
        try {
            byte[] img = dr.getBytes(14);
            if (img != null) {
                attributes.loadFromXML(new ByteArrayInputStream(img));
            }
        } catch (IOException e) {
        }         
    }
    
    public TicketLineInfo copyTicketLine() {
        TicketLineInfo l = new TicketLineInfo();
        // l.m_sTicket = null;
        // l.m_iLine = -1;
        l.productid = productid;
        l.multiply = multiply;    
        l.price = price;
        l.tax = tax;   
        l.attributes = (Properties) attributes.clone();        
        return l;
    }
    
    public int getTicketLine() {
        return m_iLine;
    }
    
    public String getProductID() {
        return productid;
    }
    
    public String getProductName() {
        return attributes.getProperty("product.name");
    }
    
    public boolean isProductCom() {
        return "true".equals(attributes.getProperty("product.com"));
    }
    
    public String getProductTaxCategoryID() {
        return (attributes.getProperty("product.taxcategoryid"));
    }
    
    public String getProductCategoryID() {
        return (attributes.getProperty("product.categoryid"));
    }    
    
    public double getMultiply() {
        return multiply;
    }
    
    public void setMultiply(double dValue) {
        multiply = dValue;  
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double dValue) {
        price = dValue;
    }    
    
    public double getPriceTax() {
        return price * (1.0 + getTaxRate());
    }
    
    public void setPriceTax(double dValue) {
        price = dValue / (1.0 + getTaxRate());
    }
    
    public TaxInfo getTaxInfo() {
        return tax;
    }    
    
    public void setTaxInfo(TaxInfo value) {
        tax = value;
    }
    
    public String getProperty(String key) {
        return attributes.getProperty(key);
    }
    
    public String getProperty(String key, String defaultvalue) {
        return attributes.getProperty(key, defaultvalue);
    }
    
    public void setProperty(String key, String value) {
        attributes.setProperty(key, value);
    }
    
    public Properties getProperties() {
        return attributes;
    }    
    
    public double getTaxRate() {
        return tax == null ? 0.0 : tax.getRate();
    }
    
    public double getSubValue() {
        return price * multiply;
    }
    
    public double getTax() {
        return price * multiply * getTaxRate();
    }
    
    public double getValue() {
        return price * multiply * (1.0 + getTaxRate());
    }
    
    public String printName() {
         return StringUtils.encodeXML(attributes.getProperty("product.name"));
    }
    
    public String printMultiply() {
        return Formats.DOUBLE.formatValue(multiply);
    }
    
    public String printPrice() {
        return Formats.CURRENCY.formatValue(getPrice());
    }  
    
    public String printPriceTax() {
        return Formats.CURRENCY.formatValue(getPriceTax());
    }   
    
    public String printTax() {
        return Formats.CURRENCY.formatValue(getTax());
    }
    
    public String printTaxRate() {
        return Formats.PERCENT.formatValue(getTaxRate());        
    }
    
    public String printSubValue() {
        return Formats.CURRENCY.formatValue(getSubValue());
    }

    public String printSubValueTax() {
        return Formats.CURRENCY.formatValue(getValue());
    }
    
    public String printValue() {
        return Formats.CURRENCY.formatValue(getValue());
    }
}
