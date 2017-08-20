//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scripting;

/**
 *
 * @author adrianromero
 * Created on 5 de marzo de 2007, 19:56
 *
 */
public interface ScriptEngine {
    
    public void put(String key, Object value);
    public Object get(String key);
    
    public Object eval(String src) throws ScriptException;
    
}
