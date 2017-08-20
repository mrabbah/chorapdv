//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.IKeyed;
import com.choranet.data.loader.SerializableRead;

/**
 *
 * @author adrianromero
 * Created on February 13, 2007, 10:13 AM
 *
 */
public class LocationInfo implements SerializableRead, IKeyed {

    private String m_sID;
    private String m_sName;
    private String m_sAddress;
    
    /** Creates a new instance of LocationInfo */
    public LocationInfo() {
        m_sID = null;
        m_sName = null;
        m_sAddress = null;
    }
    
    public Object getKey() {
        return m_sID;
    }
    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
        m_sAddress = dr.getString(3);
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

    public String getAddress() {
        return m_sAddress;
    }
    
    public void setAddress(String sAddress) {
        m_sAddress = sAddress;
    } 
    
    public String toString(){
        return m_sName;
    }    
}
