//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.pos.scripting.ScriptEngine;
import com.choranet.pos.scripting.ScriptException;
import com.choranet.pos.scripting.ScriptFactory;
import com.choranet.pos.util.StringUtils;
import java.io.IOException;

/**
 *
 * @author adrianromero
 */
public class BeanFactoryScript implements BeanFactoryApp {
    
    private BeanFactory bean = null;
    private String script;
    
    public BeanFactoryScript(String script) {
        this.script = script;
    }
    
    public void init(AppView app) throws BeanFactoryException {
        
        // Resource
        try {
            ScriptEngine eng = ScriptFactory.getScriptEngine(ScriptFactory.BEANSHELL);
            eng.put("app", app);
            
            bean = (BeanFactory) eng.eval(StringUtils.readResource(script));
            if (bean == null) {
                // old definition
                bean = (BeanFactory) eng.get("bean");
            }
            
            // todo // llamar al init del bean
            if (bean instanceof BeanFactoryApp) {
                ((BeanFactoryApp) bean).init(app);
            }
        } catch (ScriptException e) {
            throw new BeanFactoryException(e);
        } catch (IOException e) {
            throw new BeanFactoryException(e);
        }     
    }

    public Object getBean() {
        return bean.getBean();
    }
}
