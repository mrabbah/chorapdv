//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import javax.swing.JComponent;
import com.choranet.basic.BasicException;

/**
 *
 * @author adrianromero
 */
public interface JPanelView {
       
    public abstract String getTitle();
    public abstract void activate() throws BasicException;
    public abstract boolean deactivate();
    public abstract JComponent getComponent();
}
