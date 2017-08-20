//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scripting;

/**
 *
 * @author adrianromero
 */
public class ScriptException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>ScriptException</code> without detail message.
     */
    public ScriptException() {
    }
    
    
    /**
     * Constructs an instance of <code>ScriptException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ScriptException(String msg) {
        super(msg);
    }
    public ScriptException(String msg, Throwable cause) {
        super(msg, cause);
    }
        
}
