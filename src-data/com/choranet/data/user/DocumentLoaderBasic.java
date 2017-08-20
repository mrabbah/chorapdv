//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.user;

/**
 *
 * @author adrianromero
 * Created on 22 de marzo de 2007, 0:01
 *
 */
public class DocumentLoaderBasic implements DocumentLoader {
    
    public static final DocumentLoader INSTANCE = new DocumentLoaderBasic();
    
    /** Creates a new instance of DocumentLoaderBasic */
    private DocumentLoaderBasic() {
    }
    
    public Object getValue(Object key) {
        return key;
    }
    public Object getKey(Object value) {
        return value;
    }
}
