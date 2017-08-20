//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scanpal2;

public interface DeviceScanner {

    public void connectDevice() throws DeviceScannerException;
    public void disconnectDevice();

    public void startDownloadProduct() throws DeviceScannerException;
    public ProductDownloaded recieveProduct() throws DeviceScannerException;
    
    public void startUploadProduct() throws DeviceScannerException;
    public void sendProduct(String sName, String sCode, Double dPrice) throws DeviceScannerException;
    public void stopUploadProduct() throws DeviceScannerException;    
}
