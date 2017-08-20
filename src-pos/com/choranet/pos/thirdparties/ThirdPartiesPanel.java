//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.thirdparties;

import javax.swing.ListCellRenderer;
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

public class ThirdPartiesPanel extends JPanelTable {
    
    private TableDefinition tthirdparties;
    private ThirdPartiesView jeditor;
    
    /** Creates a new instance of JPanelPeople */
    public ThirdPartiesPanel() {
    }
    
    protected void init() {
        DataLogicThirdParties dlThirdParties = (DataLogicThirdParties) app.getBean("com.choranet.pos.thirdparties.DataLogicThirdParties");
        tthirdparties = dlThirdParties.getTableThirdParties();        
        jeditor = new ThirdPartiesView(app, dirty);     
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tthirdparties);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tthirdparties);      
    }
    
    public Vectorer getVectorer() {
        return tthirdparties.getVectorerBasic(new int[]{1, 2, 3, 4});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return tthirdparties.getComparatorCreator(new int[] {1, 2, 3, 4});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tthirdparties.getRenderStringBasic(new int[]{1, 2}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }       
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.ThirdPartiesManagement");
    }     
}
