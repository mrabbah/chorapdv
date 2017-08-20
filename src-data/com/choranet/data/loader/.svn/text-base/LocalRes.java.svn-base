//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import java.util.MissingResourceException;
import com.choranet.beans.LocaleResources;

public class LocalRes {
    
    // private static ResourceBundle m_Intl;
    private static LocaleResources m_resources;
    
    static {
        m_resources = new LocaleResources();
        m_resources.addBundleName("data_messages");
    }
    
    /** Creates a new instance of LocalRes */
    private LocalRes() {
    }
       
    public static String getIntString(String sKey) {      
        return m_resources.getString(sKey);
    }         
}
