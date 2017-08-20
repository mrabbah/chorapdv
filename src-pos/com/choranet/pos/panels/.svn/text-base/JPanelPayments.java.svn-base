//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.panels;

import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.SaveProvider;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSales;

/**
 *
 * @author adrianromero
 */
public class JPanelPayments extends JPanelTable {
    
    private PaymentsEditor jeditor;    
    private DataLogicSales m_dlSales = null;
    
    /** Creates a new instance of JPanelPayments */
    public JPanelPayments() {
    }
    
    protected void init() {
        m_dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        jeditor = new PaymentsEditor(app, dirty);    
    }
    
    public ListProvider getListProvider() {
        return null;
    }
    
    public SaveProvider getSaveProvider() {
        return  new SaveProvider(null
                , m_dlSales.getPaymentMovementInsert()
                , m_dlSales.getPaymentMovementDelete());
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Payments");
    }    
}
