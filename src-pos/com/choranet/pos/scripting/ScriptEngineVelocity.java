//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scripting;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;

/**
 *
 * @author adrianromero
 * Created on 5 de marzo de 2007, 19:57
 *
 */
class ScriptEngineVelocity implements ScriptEngine {
    
    private static VelocityEngine m_ve = null;

    private VelocityContext c = null;
    
    /** Creates a new instance of ScriptEngineVelocity */
    public ScriptEngineVelocity() throws ScriptException {
        
        if (m_ve == null) {
            // Inicializo Velocity
            m_ve = new VelocityEngine();
            // ve.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM, this);

    //        m_ve.setProperty(VelocityEngine.RESOURCE_LOADER, "class");
    //        // m_ve.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");
    //        // m_ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    //        m_ve.setProperty("class.resource.loader.class", "com.choranet.pos.forms.SystemResourceLoader");
    //        m_ve.setProperty("class.resource.loader.description", "Velocity Resource Loader");
    //        m_ve.setProperty("class.resource.loader.appresources", this);

            m_ve.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogSystem");
            m_ve.setProperty(VelocityEngine.ENCODING_DEFAULT, "UTF-8");
            m_ve.setProperty(VelocityEngine.INPUT_ENCODING, "UTF-8");
            try {
                m_ve.init();
            } catch (Exception e) {
                throw new ScriptException("Cannot initialize Velocity Engine", e);
            } 
        }
         c = new VelocityContext();
    }
    
    public void put(String key, Object value) {
        c.put(key, value);
    }
    public Object get(String key) {
        return c.get(key);
    }
    
    public Object eval(String src) throws ScriptException {
        
        if (m_ve == null) {
            throw new ScriptException("Velocity engine not initialized.");
        } else {
            Writer w = new StringWriter();
            try {
                if (m_ve.evaluate(c, w, "log", new StringReader(src))) {
                    return w.toString();
                } else {
                    throw new ScriptException("Velocity engine unexpected error.");
                }
            } catch (ParseErrorException e) {
                throw new ScriptException(e.getMessage(), e);
            } catch (MethodInvocationException e) {
                throw new ScriptException(e.getMessage(), e);
            } catch (Exception e) {
                throw new ScriptException(e.getMessage(), e);
            }
        }
    }
}