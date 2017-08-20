//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales;

import com.choranet.pos.sales.simple.JTicketsBagSimple;
import com.choranet.pos.forms.*;
import javax.swing.*;
import com.choranet.pos.sales.restaurant.JTicketsBagRestaurantMap;
import com.choranet.pos.sales.shared.JTicketsBagShared;

public abstract class JTicketsBag extends JPanel {
    
    protected AppView m_App;     
    protected DataLogicSales m_dlSales;
    protected TicketsEditor m_panelticket;    
    
    /** Creates new form JTicketsBag */
    public JTicketsBag(AppView oApp, TicketsEditor panelticket) {        
        m_App = oApp;     
        m_panelticket = panelticket;        
        m_dlSales = (DataLogicSales) m_App.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
    }
    
    public abstract void activate();
    public abstract boolean deactivate();
    public abstract void deleteTicket();
    
    protected abstract JComponent getBagComponent();
    protected abstract JComponent getNullComponent();
    
    public static JTicketsBag createTicketsBag(String sName, AppView app, TicketsEditor panelticket) {
        
        if ("standard".equals(sName)) {
            // return new JTicketsBagMulti(oApp, user, panelticket);
            return new JTicketsBagShared(app, panelticket);
        } else if ("restaurant".equals(sName)) {
            return new JTicketsBagRestaurantMap(app, panelticket);
        } else { // "simple"
            return new JTicketsBagSimple(app, panelticket);
        }
    }   
}
