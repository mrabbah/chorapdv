//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import java.util.Date;
import com.choranet.data.loader.Session;
import com.choranet.pos.printer.*;
import com.choranet.pos.scale.DeviceScale;
import com.choranet.pos.scanpal2.DeviceScanner;

/**
 *
 * @author adrianromero
 */
public interface AppView {
    
    public DeviceScale getDeviceScale();
    public DeviceTicket getDeviceTicket();
    public DeviceScanner getDeviceScanner();
      
    public Session getSession();
    public AppProperties getProperties();
    public Object getBean(String beanfactory) throws BeanFactoryException;
     
    public void setActiveCash(String value, int iSeq, Date dStart, Date dEnd);
    public String getActiveCashIndex();
    public int getActiveCashSequence();
    public Date getActiveCashDateStart();
    public Date getActiveCashDateEnd();
    
    public String getInventoryLocation();
    
    public void waitCursorBegin();
    public void waitCursorEnd();
    
    public AppUserView getAppUserView();
}

