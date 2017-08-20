//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.SerializableRead;
import com.choranet.data.loader.DataWrite;
import com.choranet.data.loader.SerializableWrite;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.IKeyed;
import java.io.Serializable;

/**
 *
 * @author  adrianromero
 * @version 
 */
public class TaxCategoryInfo implements SerializableRead, SerializableWrite, Serializable, IKeyed {

    private String m_sID;
    private String m_sName;
    
    /** Creates new CategoryInfo */
    public TaxCategoryInfo() {
        m_sID = null;
        m_sName = null;
    }
    
    public TaxCategoryInfo(String sID, String sName) {
        m_sID = sID;
        m_sName = sName;      
    }
    
    public Object getKey() {
        return m_sID;
    }
    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
    }
    
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, m_sID);
        dp.setString(2, m_sName);     
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
   
    @Override
    public String toString(){
        return m_sName;
    }
}