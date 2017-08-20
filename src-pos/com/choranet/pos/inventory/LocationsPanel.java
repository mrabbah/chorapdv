//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import javax.swing.ListCellRenderer;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.data.loader.TableDefinition;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.data.user.SaveProvider;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.AppView;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.panels.JPanelTable;

/**
 *
 * @author adrianromero
 */
public class LocationsPanel extends JPanelTable {
    
    private TableDefinition tlocations;
    private LocationsView jeditor;
    
    /** Creates a new instance of LocationsPanel */
    public LocationsPanel() {
    }
    
    protected void init() {   
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        tlocations = dlSales.getTableLocations();
        jeditor = new LocationsView(dirty);
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tlocations);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tlocations);        
    }
    
    public Vectorer getVectorer() {
        return tlocations.getVectorerBasic(new int[]{1, 2});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return tlocations.getComparatorCreator(new int[] {1, 2});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tlocations.getRenderStringBasic(new int[]{1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Locations");
    }      
}
