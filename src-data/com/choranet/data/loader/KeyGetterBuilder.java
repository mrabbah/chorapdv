//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

/**
 *
 * @author adrianromero
 * Created on 27 de febrero de 2007, 22:09
 *
 */
public class KeyGetterBuilder implements IKeyGetter {
  
    public final static IKeyGetter INSTANCE = new KeyGetterBuilder();
    
    /** Creates a new instance of KeyGetterBuilder */
    public KeyGetterBuilder() {
    }
    
    public Object getKey(Object value) {
        
        return (value == null) 
            ? null
            : ((IKeyed) value).getKey();
    }   
}
