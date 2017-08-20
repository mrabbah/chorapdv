//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.ticket;

import javax.swing.*;
import java.awt.*;

import com.choranet.pos.util.ThumbNailBuilder;
import com.choranet.format.Formats;

public class ProductRenderer extends DefaultListCellRenderer {
                
    ThumbNailBuilder tnbprod;

    /** Creates a new instance of ProductRenderer */
    public ProductRenderer() {   
        tnbprod = new ThumbNailBuilder(64, 32, "com/choranet/images/package.png");
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
        
        ProductInfoExt prod = (ProductInfoExt) value;
        if (prod != null) {
            setText("<html>" + prod.getReference() + " - " + prod.getName() + "<br>&nbsp;&nbsp;&nbsp;&nbsp;" + prod.getTaxCategoryName() + " " + Formats.CURRENCY.formatValue(new Double(prod.getPriceSell())));
            Image img = tnbprod.getThumbNail(prod.getImage());
            setIcon(img == null ? null :new ImageIcon(img));
        }
        return this;
    }      
}
