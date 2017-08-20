//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.beans.LocaleResources;

/**
 *
 * @author adrianromero
 */
public class AppLocal {
    
    public static final String APP_NAME = "CHORA INFORMATIQUE POS";
    public static final String APP_ID = "chorapos";
    public static final String APP_VERSION = "2.30";
  
    // private static List<ResourceBundle> m_messages;
    private static LocaleResources m_resources;
    
    static {
        m_resources = new LocaleResources();
        m_resources.addBundleName("pos_messages");
        m_resources.addBundleName("erp_messages");
    }
    
    /** Creates a new instance of AppLocal */
    private AppLocal() {
    }
    
    public static String getIntString(String sKey) {
        return m_resources.getString(sKey);
    }
    
    public static String getIntString(String sKey, Object ... sValues) {
        return m_resources.getString(sKey, sValues);
    }
}
