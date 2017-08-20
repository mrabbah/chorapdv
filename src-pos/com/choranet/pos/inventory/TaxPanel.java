//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import com.choranet.basic.BasicException;
import com.choranet.pos.panels.*;
import javax.swing.ListCellRenderer;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.pos.forms.AppLocal;
import com.choranet.data.loader.TableDefinition;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.SaveProvider;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.pos.forms.DataLogicSales;

/**
 *
 * @author adrianromero
 */
public class TaxPanel extends JPanelTable {

    private TableDefinition ttaxes;
    private TaxEditor jeditor;
    
    /** Creates a new instance of JPanelDuty */
    public TaxPanel() {
    }
    
    protected void init() {
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        ttaxes = dlSales.getTableTaxes();
        jeditor = new TaxEditor(app, dirty);
    }
    
    @Override
    public void activate() throws BasicException { 
        
        jeditor.activate();         
        super.activate();
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(ttaxes);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(ttaxes);      
    }
    
    @Override
    public Vectorer getVectorer() {
        return ttaxes.getVectorerBasic(new int[]{1, 5, 7});
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return ttaxes.getComparatorCreator(new int[] {1, 5, 7});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(ttaxes.getRenderStringBasic(new int[]{1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
        
    public String getTitle() {
        return AppLocal.getIntString("Menu.Taxes");
    }     
}
