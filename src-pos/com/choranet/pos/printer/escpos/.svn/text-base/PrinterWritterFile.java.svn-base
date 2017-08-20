//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer.escpos;

import java.io.*;

public class PrinterWritterFile extends PrinterWritter {
    
    private String m_sFilePrinter;
    private OutputStream m_out;
    
    public PrinterWritterFile(String sFilePrinter) {
        m_sFilePrinter = sFilePrinter;
        m_out = null;
        
        write(ESCPOS.INIT); // Arrancamos la impresora
        flush();
    }  
    
    protected void daemonWrite(byte[] data) {
        try {  
            if (m_out == null) {
                m_out = new FileOutputStream(m_sFilePrinter);  // No poner append = true.
            }
            m_out.write(data);
        } catch (IOException e) {
            System.err.println(e);
        }    
    }
    
    protected void daemonFlush() {
        try {  
            if (m_out != null) {
                m_out.flush();
                m_out.close();
                m_out = null;
            }
        } catch (IOException e) {
            System.err.println(e);
        }    
    }
    
    protected void daemonClose() {
        try {  
            if (m_out != null) {
                m_out.flush();
                m_out.close();
                m_out = null;
            }
        } catch (IOException e) {
            System.err.println(e);
        }    
    }    
}
