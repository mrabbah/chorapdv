//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;

public interface SentenceEnum {
    
    public void load() throws BasicException;
    public void load(Object params) throws BasicException;

    public Object getCurrent() throws BasicException;
    public boolean next() throws BasicException;    
}
