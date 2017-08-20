//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.customers;

import javax.swing.*;
import java.awt.*;

public class CustomerRenderer extends DefaultListCellRenderer {
                
    private Icon icocustomer;

    /** Creates a new instance of ProductRenderer */
    public CustomerRenderer() {

        icocustomer = new ImageIcon(getClass().getClassLoader().getResource("com/choranet/images/kdmconfig.png"));
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
        setText(value.toString());
        setIcon(icocustomer);
        return this;
    }      
}
