//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.ticket;

import com.choranet.format.Formats;
import com.choranet.pos.util.RoundUtils;


public class TicketTaxInfo {
    
    private TaxInfo tax;
    
    private double subtotal;
    private double taxtotal;
            
    /** Creates a new instance of TicketTaxInfo */
    public TicketTaxInfo(TaxInfo tax) {
        this.tax = tax;
        
        subtotal = 0.0;
        taxtotal = 0.0;
    }
    
    public TaxInfo getTaxInfo() {
        return tax;
    }
    
    public void add(double dValue) {
        subtotal += dValue;
        taxtotal = RoundUtils.round(subtotal * tax.getRate());
    }
    
    public double getSubTotal() {    
        return subtotal;
    }
    
    public double getTax() {       
        return taxtotal;
    }
    
    public double getTotal() {         
        return subtotal + taxtotal;
    }
    
    public String printSubTotal() {
        return Formats.CURRENCY.formatValue(new Double(getSubTotal()));
    }
    public String printTaxRate() {
        return Formats.PERCENT.formatValue(new Double(tax.getRate()));
    }
    public String printTax() {
        return Formats.CURRENCY.formatValue(new Double(getTax()));
    }    
    public String printTotal() {
        return Formats.CURRENCY.formatValue(new Double(getTotal()));
    }    
}
