//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.user;

import com.choranet.basic.BasicException;

public interface Finder {

    public boolean match(Object obj) throws BasicException;
}
