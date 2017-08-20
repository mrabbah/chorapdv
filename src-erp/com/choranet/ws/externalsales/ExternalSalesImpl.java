//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

/**
 * ExternalSalesImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.choranet.ws.externalsales;

public interface ExternalSalesImpl extends java.rmi.Remote {
    public com.choranet.ws.externalsales.Product[] getProductsCatalog(java.lang.String clientID, java.lang.String organizationId, java.lang.String salesChannel, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public com.choranet.ws.externalsales.ProductPlus[] getProductsPlusCatalog(java.lang.String clientID, java.lang.String organizationId, java.lang.String salesChannel, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean uploadOrders(java.lang.String clientID, java.lang.String organizationId, java.lang.String salesChannel, com.choranet.ws.externalsales.Order[] newOrders, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public com.choranet.ws.externalsales.Order[] getOrders(java.lang.String clientID, java.lang.String organizationId, com.choranet.ws.externalsales.OrderIdentifier[] orderIds, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
}
