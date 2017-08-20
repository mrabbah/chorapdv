//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scripting;

import bsh.EvalError;
import bsh.Interpreter;

/**
 *
 * @author adrianromero
 * Created on 5 de marzo de 2007, 19:57
 *
 */
class ScriptEngineBeanshell implements ScriptEngine {

    private Interpreter i;
    
    /** Creates a new instance of ScriptEngineBeanshell */
    public ScriptEngineBeanshell() {
        i = new Interpreter();
    }
    
    public void put(String key, Object value) {
        
        try {
            i.set(key, value);
        } catch (EvalError e) {
        }
    }
    
    public Object get(String key) {
        
        try {
            return i.get(key);
        } catch (EvalError e) {
            return null;
        }
    }
    
    public Object eval(String src) throws ScriptException {

        try {
            return i.eval(src);  
        } catch (EvalError e) {
            throw new ScriptException(e.getMessage(), e);
        }        
    }   
}
