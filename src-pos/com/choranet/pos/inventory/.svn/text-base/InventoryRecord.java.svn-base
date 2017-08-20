//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.choranet.format.Formats;

/**
 *
 * @author adrianromero
 */
public class InventoryRecord {
    
    private Date m_dDate;
    private MovementReason m_reason;
    private LocationInfo m_locationOri;   
    private List<InventoryLine> m_invlines;
    
    /** Creates a new instance of InventoryRecord */
    public InventoryRecord(Date d, MovementReason reason, LocationInfo location, List<InventoryLine> invlines) {
        m_dDate = d;
        m_reason = reason;
        m_locationOri = location;
        m_invlines = invlines;
    }
    
    public Date getDate() {
        return m_dDate;
    }   
    public MovementReason getReason() {
        return m_reason;
    }    
    public LocationInfo getLocation() {
        return m_locationOri;
    }   
    
    public List<InventoryLine> getLines() {
        return m_invlines;
    }  
    
    public boolean isInput() {
        return m_reason.isInput();
    }
    
    public double getSubTotal() {
        double dSuma = 0.0;
        InventoryLine oLine;            
        for (Iterator<InventoryLine> i = m_invlines.iterator(); i.hasNext();) {
            oLine = i.next();
            dSuma += oLine.getSubValue();
        }        
        return dSuma;
    }
    
    public String printDate() {
        return Formats.TIMESTAMP.formatValue(m_dDate);
    }    
    public String printLocation() {
        return m_locationOri.toString();
    }
    public String printReason() {
        return m_reason.toString();
    }    
    public String printSubTotal() {
        return Formats.CURRENCY.formatValue(new Double(getSubTotal()));
    }    
}
