//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.user;

import com.choranet.basic.BasicException;

public interface EditorCreator {

    public Object createValue() throws BasicException;
}
