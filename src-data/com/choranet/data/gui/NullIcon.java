//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.gui;

import javax.swing.Icon;

/**
 *
 * @author  adrian
 */
public class NullIcon implements Icon {
    
    private int m_iWidth;
    private int m_iHeight;
    
    /** Creates a new instance of NullIcon */
    public NullIcon(int width, int height) {
        m_iWidth = width;
        m_iHeight = height;
    }
    
    public int getIconHeight() {
        return m_iHeight;
    }
    
    public int getIconWidth() {
        return m_iWidth;
    }
    
    public void paintIcon(java.awt.Component c, java.awt.Graphics g, int x, int y) {
    }
    
}
