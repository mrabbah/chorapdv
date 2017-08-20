//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales.restaurant;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.choranet.data.gui.NullIcon;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.SerializableRead;
import com.choranet.basic.BasicException;

public class Place implements SerializableRead, java.io.Serializable {
    
    private static final Icon ICO_OCU = new ImageIcon(Place.class.getResource("/com/choranet/images/edit_group.png"));
    private static final Icon ICO_FRE = new NullIcon(22, 22);
    
    private String m_sId;
    private String m_sName;
    private int m_ix;
    private int m_iy;
    private String m_sfloor;
    
    private boolean m_bPeople;
    private JButton m_btn;
        
    /** Creates a new instance of TablePlace */
    public Place() {
    }        
    
    public void readValues(DataRead dr) throws BasicException {
        m_sId = dr.getString(1);
        m_sName = dr.getString(2);
        m_ix = dr.getInt(3).intValue();
        m_iy = dr.getInt(4).intValue();
        m_sfloor = dr.getString(5);
        
        m_bPeople = false;
        m_btn = new JButton();

        m_btn.setFocusPainted(false);
        m_btn.setFocusable(false);
        m_btn.setRequestFocusEnabled(false);
        m_btn.setHorizontalTextPosition(SwingConstants.CENTER);
        m_btn.setVerticalTextPosition(SwingConstants.BOTTOM);            
        m_btn.setIcon(ICO_FRE);
        m_btn.setText(m_sName);
    }

    public String getId() { return m_sId; }
    
    public String getName() { return m_sName; }

    public int getX() { return m_ix; }

    public int getY() { return m_iy; }

    public String getFloor() { return m_sfloor; }
   
    public JButton getButton() { return m_btn; }

    public boolean hasPeople() {
        return m_bPeople;
    }   
    public void setPeople(boolean bValue) {
        m_bPeople = bValue;
        m_btn.setIcon(bValue ? ICO_OCU : ICO_FRE); 
    }     
    public void setButtonBounds() {
        Dimension d = m_btn.getPreferredSize();
        m_btn.setBounds(m_ix - d.width / 2, m_iy - d.height / 2, d.width, d.height); 
    }
}    

    
