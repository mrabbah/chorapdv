//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public interface Vectorer {
    
    // public int size();
    public String[] getHeaders() throws BasicException;
    public String[] getValues(Object obj) throws BasicException;
}
