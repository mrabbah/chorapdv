//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

/**
 *
 * @author  adrian
 */
public interface DataRead {
    
    public Integer getInt(int columnIndex) throws BasicException;
    public String getString(int columnIndex) throws BasicException;
    public Double getDouble(int columnIndex) throws BasicException;
    public Boolean getBoolean(int columnIndex) throws BasicException;
    public java.util.Date getTimestamp(int columnIndex) throws BasicException;

    //public java.io.InputStream getBinaryStream(int columnIndex) throws DataException;
    public byte[] getBytes(int columnIndex) throws BasicException;
    public Object getObject(int columnIndex) throws BasicException ;
    
//    public int getColumnCount() throws DataException;
    public DataField[] getDataField() throws BasicException;
}
