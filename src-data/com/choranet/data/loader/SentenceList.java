//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import java.util.List;
import com.choranet.basic.BasicException;

public interface SentenceList {
    
    public List list() throws BasicException;
    public List list(Object params) throws BasicException;
    
    public List listPage(int offset, int length) throws BasicException;
    public List listPage(Object params, int offset, int length) throws BasicException;    
}
