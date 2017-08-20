//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

/**
 *
 * @author adrianromero
 */
public abstract class BeanFactoryCache implements BeanFactoryApp {
    
    private Object bean = null;

    public abstract Object constructBean(AppView app) throws BeanFactoryException;
           
    public void init(AppView app) throws BeanFactoryException {
        bean = constructBean(app);
    }
    
    public Object getBean() {
        return bean;
    }
}
