//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.panels;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataField;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.Datas;

/**
 *
 * @author adrianromero
 */
public class SQLTableModel extends AbstractTableModel {
    
    private List m_aRows;
    
    private DataField[] m_df;
    private Datas[] m_classes;
    
    /** Creates a new instance of SQLTableModel */
    public SQLTableModel(DataField[] df) {
        m_aRows = new ArrayList();

        m_df = df;
        m_classes = new Datas[df.length];
        for (int i = 0; i < df.length; i++) {
            switch (df[i].Type) {
                case Types.INTEGER:
                case Types.BIGINT:
                case Types.SMALLINT:
                case Types.TINYINT:
                    m_classes[i] = Datas.INT;
                    break;
                case Types.BIT:
                case Types.BOOLEAN:
                    m_classes[i] = Datas.BOOLEAN;
                    break;
                case Types.DECIMAL:
                case Types.DOUBLE:
                case Types.FLOAT:
                case Types.REAL:
                case Types.NUMERIC:
                    m_classes[i] = Datas.DOUBLE;
                    break;
                case Types.CHAR:
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                case Types.CLOB:
                    m_classes[i] = Datas.STRING;
                    break;
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    m_classes[i] = Datas.TIMESTAMP;
                    break;
                case Types.BINARY:
                case Types.VARBINARY:
                case Types.LONGVARBINARY:
                case Types.BLOB:
                    m_classes[i] = Datas.BYTES;
                    break;
                case Types.ARRAY:                    
                case Types.DATALINK:
                case Types.DISTINCT:
                case Types.JAVA_OBJECT:
                case Types.NULL:
                case Types.OTHER:
                case Types.REF:
                case Types.STRUCT:
                default:
                    m_classes[i] = Datas.OBJECT;
                    break;
            }
        }
    }

    public void addRow(DataRead dr) throws BasicException {
        
        Object[] m_values = new Object[m_classes.length];
        for (int i = 0; i < m_classes.length; i++) {
            m_values[i] = m_classes[i].getValue(dr, i + 1);
        }
         m_aRows.add(m_values);
    }     
    public String getColumnString(int row) {
        Object [] rowvalues = (Object[]) m_aRows.get(row);
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < rowvalues.length; i++) {
            if (i > 0) {
                s.append(", ");
            }
            s.append(m_classes[i].toString(rowvalues[i]));
        }
        return s.toString();
    }
    
    public Class getColumnClass(int columnIndex) {
        return m_classes[columnIndex].getClassValue();
    }
    public String getColumnName(int columnIndex) {
        return m_df[columnIndex].Name;
    }    
    public int getRowCount() {
        return m_aRows.size();
    }
    public int getColumnCount() {
        return m_df.length;
    }
    public Object getValueAt(int row, int column) {
        Object [] rowvalues = (Object[]) m_aRows.get(row);
        return rowvalues[column];
    }  
}
