//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.catalog;

import java.awt.Component;
import java.awt.event.ActionListener;
import com.choranet.basic.BasicException;

/**
 *
 * @author adrianromero
 */
public interface CatalogSelector {
    
    public void loadCatalog() throws BasicException;
    public void showCatalogPanel(String id);
    public void setComponentEnabled(boolean value);
    public Component getComponent();
    
    public void addActionListener(ActionListener l);  
    public void removeActionListener(ActionListener l);    
}
