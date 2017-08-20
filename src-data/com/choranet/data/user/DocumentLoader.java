//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.user;

/**
 *
 * @author adrianromero
 * Created on 22 de marzo de 2007, 0:00
 *
 */
public interface DocumentLoader {
    
    public Object getValue(Object key);
    public Object getKey(Object value);
}
