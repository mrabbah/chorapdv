//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

/**
 *
 * @author adrianromero
 */
public interface BeanFactoryApp extends BeanFactory {

    public void init(AppView app) throws BeanFactoryException;

}
