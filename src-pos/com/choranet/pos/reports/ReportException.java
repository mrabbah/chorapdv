//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.reports;

public class ReportException extends Exception {
    
    public ReportException() {
    }
    public ReportException(String msg) {
        super(msg);
    }
    public ReportException(Exception e) {
        super(e);
    }
}
