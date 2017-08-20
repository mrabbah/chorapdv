//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer.escpos;

import java.util.LinkedList;

final class PrinterBuffer {
    
    private LinkedList m_list;
    
    /** Creates a new instance of PrinterBuffer */
    public PrinterBuffer() {        
        m_list = new LinkedList();
    }
   
    public synchronized void putData(Object data) {
        m_list.addFirst(data);
        notifyAll();
    }
    
    public synchronized Object getData() {
        while (m_list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        notifyAll();
        return m_list.removeLast();
    }   
}
