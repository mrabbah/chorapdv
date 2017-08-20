//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.admin;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.IKeyed;
import com.choranet.data.loader.SerializableRead;

/**
 *
 * @author adrianromero
 * Created on 27 de febrero de 2007, 23:27
 *
 */
public class RoleInfo implements SerializableRead, IKeyed {
    
    private String m_sID;
    protected String m_sName;
    
    /** Creates a new instance of RoleInfo */
    public RoleInfo() {
        m_sID = null;
        m_sName = null;
    }
   
    public Object getKey() {
        return m_sID;
    }
    
    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
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
    
    public void setName(String sValue) {
        m_sName = sValue;
    }    
    
    public String toString() {
        return m_sName;
    }
}
