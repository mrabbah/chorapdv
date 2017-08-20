//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.data.loader.Session;

/**
 *
 * @author adrianromero
 */
public abstract class BeanFactoryDataSingle implements BeanFactoryApp {
    
    /** Creates a new instance of BeanFactoryData */
    public BeanFactoryDataSingle() {
    }
    
    public abstract void init(Session s);

    public void init(AppView app) throws BeanFactoryException {        
        init(app.getSession());                     
    }   
    
    public Object getBean() {
        return this;
    }  
}
