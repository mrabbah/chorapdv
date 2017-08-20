//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.ticket;

import java.io.Serializable;

/**
 *
 * @author adrianromero
 */
public class UserInfo implements Serializable {
    
    private String m_sId;
    private String m_sName;
    
    /** Creates a new instance of UserInfoBasic */
    public UserInfo(String id, String name) {
        m_sId = id;
        m_sName = name;    
    }
    
    public String getId() {
        return m_sId;
    }    
    
    public String getName() {
        return m_sName;
    }        
}
