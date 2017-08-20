//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.ticket;

import java.io.*;
import java.awt.image.BufferedImage;
import com.choranet.data.loader.DataRead;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.ImageUtils;
import com.choranet.pos.inventory.TaxCategoryInfo;
import java.util.Properties;

public class ProductInfoExt extends ProductInfo {
    
    protected BufferedImage m_Image;
    protected Properties attributes;
    
    /** Creates new ProductInfo */
    public ProductInfoExt() {
        super();
        m_Image = null;
        attributes = new Properties();
    }
    
    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_ID = dr.getString(1);
        m_sRef = dr.getString(2);
        m_sCode = dr.getString(3);
        m_sName = dr.getString(4);
        m_bCom = dr.getBoolean(5).booleanValue();
        m_bScale = dr.getBoolean(6).booleanValue();
        m_dPriceBuy = dr.getDouble(7).doubleValue();
        m_dPriceSell = dr.getDouble(8).doubleValue() * 1.2;
        taxcategory = new TaxCategoryInfo(dr.getString(9), dr.getString(10));      
        m_sCategoryID = dr.getString(11);
        m_Image = ImageUtils.readImage(dr.getBytes(12));
        attributes = new Properties();
        try {
            byte[] img = dr.getBytes(13);
            if (img != null) {
                attributes.loadFromXML(new ByteArrayInputStream(img));
            }
        } catch (IOException e) {
        }
        //m_sCodeType = dr.getString(14);
    }
    
    public BufferedImage getImage() {
        return m_Image;
    }
    public void setImage(BufferedImage img) {
        m_Image = img;
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
}
