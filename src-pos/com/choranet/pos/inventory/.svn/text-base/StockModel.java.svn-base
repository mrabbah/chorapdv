//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import javax.swing.table.AbstractTableModel;
import com.choranet.basic.BasicException;
import com.choranet.data.user.BrowsableData;
import com.choranet.format.Formats;

/**
 *
 * @author adrianromero
 */
public class StockModel extends AbstractTableModel {
    
    private BrowsableData m_bd;
    private Formats[] m_formats;
    private boolean[] m_bedit;
    
    /** Creates a new instance of StockModel */
    public StockModel(BrowsableData bd, Formats[] f, boolean[] bedit) {
        m_bd = bd;
        m_formats = f;
        m_bedit = bedit;
    }
    public int getRowCount() {
        return m_bd.getSize();
    }
    public int getColumnCount() {
        return m_formats.length;
    }
    public Object getValueAt(int row, int column) {
        return m_formats[column].formatValue(
                ((Object[]) m_bd.getElementAt(row))[column]);
    }     
    public boolean isCellEditable(int row, int column) {
        return m_bedit[column];
    }
    public void setValueAt(Object aValue, int row, int column) {
        Object[] record = (Object[]) m_bd.getElementAt(row);
        try {
            record[column] = m_formats[column].parseValue((String) aValue);           
            m_bd.updateRecord(row, record);
        } catch (BasicException e) {           
        }
    }
}
