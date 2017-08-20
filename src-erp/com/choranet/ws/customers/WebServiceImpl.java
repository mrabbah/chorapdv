//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

/**
 * WebServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.choranet.ws.customers;

public interface WebServiceImpl extends java.rmi.Remote {
    public com.choranet.ws.customers.Customer[] getCustomers(java.lang.String clientId, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public com.choranet.ws.customers.Customer getCustomer(java.lang.String clientId, java.lang.String customerId, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public com.choranet.ws.customers.Customer getCustomer(java.lang.String clientId, java.lang.String name, java.lang.String searchKey, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean updateCustomer(com.choranet.ws.customers.BusinessPartner customer, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public int[] getCustomerAddresses(java.lang.String clientId, java.lang.String customerId, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public com.choranet.ws.customers.Location getCustomerLocation(java.lang.String clientId, java.lang.String customerId, java.lang.String locationId, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean updateAddress(com.choranet.ws.customers.Location addr, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public com.choranet.ws.customers.Contact getCustomerContact(java.lang.String clientId, java.lang.String customerId, java.lang.String contactId, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean updateContact(com.choranet.ws.customers.Contact contact, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
}
