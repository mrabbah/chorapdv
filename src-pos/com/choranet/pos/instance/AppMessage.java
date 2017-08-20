//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.instance;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author adrianromero
 */
public interface AppMessage extends Remote {
    
    public void restoreWindow() throws RemoteException;    
}
