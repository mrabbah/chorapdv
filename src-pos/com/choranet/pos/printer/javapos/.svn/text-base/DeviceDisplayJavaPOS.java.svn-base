//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer.javapos;

import jpos.JposException;
import jpos.LineDisplay;
import jpos.LineDisplayConst;
import com.choranet.pos.printer.DeviceDisplay;
import com.choranet.pos.printer.DeviceDisplayBase;
import com.choranet.pos.printer.DeviceDisplayImpl;
import com.choranet.pos.printer.TicketPrinterException;

public class DeviceDisplayJavaPOS implements DeviceDisplay, DeviceDisplayImpl {
    
    private String m_sName;
    private LineDisplay m_ld;
    
    private DeviceDisplayBase m_displaylines;
    
    /** Creates a new instance of DeviceDisplayJavaPOS */
    public DeviceDisplayJavaPOS(String sDeviceName) throws TicketPrinterException {
        m_sName = sDeviceName;
        
        m_ld = new LineDisplay();
        try {       
            m_ld.open(m_sName);
            m_ld.claim(10000);
            m_ld.setDeviceEnabled(true);
        } catch (JposException e) {
            throw new TicketPrinterException(e.getMessage(), e);
        }

        m_displaylines = new DeviceDisplayBase(this);
   }
    
    public String getDisplayName() {
        return m_sName;
    }    
    public String getDisplayDescription() {
        return null;
    }      
    public javax.swing.JComponent getDisplayComponent() {
        return null;
    }
    
    public void writeVisor(int animation, String sLine1, String sLine2) {
        m_displaylines.writeVisor(animation, sLine1, sLine2);
    }    
    
    public void writeVisor(String sLine1, String sLine2) {        
        m_displaylines.writeVisor(sLine1, sLine2);
    }
     
    public void clearVisor() {
        m_displaylines.clearVisor();
    }
    
    public void repaintLines() {
        try {
            m_ld.displayTextAt(0, 0, m_displaylines.getLine1(), LineDisplayConst.DISP_DT_NORMAL);
            m_ld.displayTextAt(1, 0, m_displaylines.getLine2(), LineDisplayConst.DISP_DT_NORMAL);
        } catch (JposException e) {
        }
    }
    
    public void finalize() throws Throwable {
   
        m_ld.setDeviceEnabled(false);
        m_ld.release();
        m_ld.close();
        
        super.finalize();
    }
}
