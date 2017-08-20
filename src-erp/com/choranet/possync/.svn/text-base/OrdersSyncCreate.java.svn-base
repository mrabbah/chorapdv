//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.possync;

import com.choranet.pos.forms.AppView;
import com.choranet.pos.forms.BeanFactoryCache;
import com.choranet.pos.forms.BeanFactoryException;
import com.choranet.pos.forms.DataLogicSystem;

/**
 *
 * @author adrian
 */
public class OrdersSyncCreate extends BeanFactoryCache {
    
    public Object constructBean(AppView app) throws BeanFactoryException {

        DataLogicSystem dlSystem = (DataLogicSystem) app.getBean("com.choranet.pos.forms.DataLogicSystemCreate");
        DataLogicIntegration dli = (DataLogicIntegration) app.getBean("com.choranet.possync.DataLogicIntegrationCreate");

        OrdersSync bean = new OrdersSync(dlSystem, dli);
        return bean;
    }
}
