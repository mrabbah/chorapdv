//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com


package com.choranet.data.user;

/**
 *
 * @author  adrian
 */
public interface StateListener extends java.util.EventListener {
 
    public void updateState(int iState);   
}
