//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com


package com.choranet.pos.customers;

import com.choranet.basic.BasicException;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.data.loader.TableDefinition;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.data.user.SaveProvider;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

/**
 *
 * @author adrianromero
 */
public class CustomersPanel extends JPanelTable {
    
    private TableDefinition tcustomers;
    private CustomersView jeditor;
    
    /** Creates a new instance of CustomersPanel */
    public CustomersPanel() {    
    }
    
    protected void init() {        
        DataLogicCustomers dlCustomers  = (DataLogicCustomers) app.getBean("com.choranet.pos.customers.DataLogicCustomersCreate");
        tcustomers = dlCustomers.getTableCustomers();        
        jeditor = new CustomersView(app, dirty);    
    }
    
    @Override
    public void activate() throws BasicException { 
        
        jeditor.activate();         
        super.activate();
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tcustomers);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tcustomers, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22});      
    }
    
    @Override
    public Vectorer getVectorer() {
        return tcustomers.getVectorerBasic(new int[]{1, 2, 3, 4});
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tcustomers.getComparatorCreator(new int[] {1, 2, 3, 4});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tcustomers.getRenderStringBasic(new int[]{3}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }       
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.CustomersManagement");
    }    
}
