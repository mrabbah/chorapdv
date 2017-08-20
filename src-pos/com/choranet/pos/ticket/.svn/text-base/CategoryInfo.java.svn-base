//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.ticket;

import java.awt.image.*;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.SerializableRead;
import com.choranet.data.loader.DataWrite;
import com.choranet.data.loader.SerializableWrite;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.IKeyed;
import com.choranet.data.loader.ImageUtils;

/**
 *
 * @author  Adrian
 * @version 
 */
public class CategoryInfo implements SerializableRead, SerializableWrite, IKeyed {

    private String m_sID;
    private String m_sName;
    private BufferedImage m_Image;
    
    /** Creates new CategoryInfo */
    public CategoryInfo() {
        m_sID = null;
        m_sName = null;
        m_Image = null;
    }
    
    public Object getKey() {
        return m_sID;
    }
    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
        m_Image = ImageUtils.readImage(dr.getBytes(3));
    }
    
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, m_sID);
        dp.setString(2, m_sName);
        dp.setBytes(3, ImageUtils.writeImage(m_Image));        
    }
    
    public void setID(String sID) {
        m_sID = sID;
    }
    
    public String getID() {
        return m_sID;
    }

    public String getName() {
        return m_sName;
    }
    
    public void setName(String sName) {
        m_sName = sName;
    }
    
    public BufferedImage getImage() {
        return m_Image;
    }
    
    public void setImage(BufferedImage img) {
        m_Image = img;
    }    
    public String toString(){
        return m_sName;
    }
}
