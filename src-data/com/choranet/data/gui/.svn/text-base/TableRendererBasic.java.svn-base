//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.gui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import com.choranet.format.Formats;

public class TableRendererBasic extends DefaultTableCellRenderer {
    
    private Formats[] m_aFormats;
    
    /** Creates a new instance of TableRendererBasic */
    public TableRendererBasic(Formats[] aFormats) {
        m_aFormats = aFormats;
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){

        JLabel aux = (JLabel) super.getTableCellRendererComponent(table, null, isSelected, hasFocus, row, column);
        
        aux.setText(m_aFormats[column].formatValue(value));
        aux.setHorizontalAlignment(m_aFormats[column].getAlignment());

        return aux;
    }    
}
