//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import com.choranet.basic.BasicException;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.SaveProvider;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.panels.JPanelTable;

/**
 *
 * @author adrianromero
 */
public class StockDiaryPanel extends JPanelTable {
    
    private StockDiaryEditor jeditor;    
    private DataLogicSales m_dlSales;
    
    /** Creates a new instance of JPanelDiaryEditor */
    public StockDiaryPanel() {
    }
    
    protected void init() {
        m_dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        jeditor = new StockDiaryEditor(app, dirty); 
    }
    
    public ListProvider getListProvider() {
        return null;
    }
    
    public SaveProvider getSaveProvider() {
        return  new SaveProvider(null
                , m_dlSales.getStockDiaryInsert()
                , m_dlSales.getStockDiaryDelete());      
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.StockDiary");
    }     
    
        
    public void activate() throws BasicException {
        jeditor.activate(); // primero activo el editor 
        super.activate();   // segundo activo el padre        
    } 
}
