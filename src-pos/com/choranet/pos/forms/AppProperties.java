//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import java.io.File;

/**
 *
 * @author adrianromero
 */
public interface AppProperties {

    public File getConfigFile(); 
    public String getHost();    
    public String getProperty(String sKey); // Config property.
}
