//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import javax.swing.ListCellRenderer;
import com.choranet.basic.BasicException;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.panels.*;
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
public class CategoriesPanel extends JPanelTable {
    
    private TableDefinition tcategories;
    private CategoriesEditor jeditor;
    
    /** Creates a new instance of JPanelCategories */
    public CategoriesPanel() {        
    }   
    
    protected void init() {   
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        tcategories = dlSales.getTableCategories();
        jeditor = new CategoriesEditor(app, dirty);    
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tcategories);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tcategories);      
    }
    
    public Vectorer getVectorer() {
        return tcategories.getVectorerBasic(new int[]{1});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return tcategories.getComparatorCreator(new int[]{1});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tcategories.getRenderStringBasic(new int[]{1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Categories");
    }        
}
