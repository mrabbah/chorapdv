//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales;

/**
 *
 * @author adrianromero
 */
public class TaxesException extends Exception {

    /**
     * Creates a new instance of <code>TaxesException</code> without detail message.
     */
    public TaxesException(Throwable t) {
        super(t);
    }
    
    public TaxesException(String msg, Throwable t) {
        super(msg, t);
    }
    /**
     * Constructs an instance of <code>TaxesException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TaxesException(String msg) {
        super(msg);
    }
}
