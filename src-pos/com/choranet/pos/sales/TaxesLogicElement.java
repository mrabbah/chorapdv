//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales;

import com.choranet.pos.ticket.TaxInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrianromero
 */
public class TaxesLogicElement {
    
    private TaxInfo tax;
    private List<TaxesLogicElement> taxsons;
    
    public TaxesLogicElement(TaxInfo tax) {
        this.tax = tax;
        this.taxsons = new ArrayList<TaxesLogicElement>();
    }
    
    public TaxInfo getTax() {
        return tax;
    }
    
    public List<TaxesLogicElement> getSons() {
        return taxsons;
    }
}
