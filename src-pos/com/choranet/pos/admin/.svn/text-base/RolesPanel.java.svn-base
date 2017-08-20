//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.admin;

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
import com.choranet.pos.panels.JPanelTable;

/**
 *
 * @author adrianromero
 */
public class RolesPanel extends JPanelTable {
    
    private TableDefinition troles;
    private RolesView jeditor;
    
    /** Creates a new instance of RolesPanel */
    public RolesPanel() {
     }
    
    protected void init() {
        DataLogicAdmin dlAdmin  = (DataLogicAdmin) app.getBean("com.choranet.pos.admin.DataLogicAdmin");
        troles = dlAdmin.getTableRoles();                 
        jeditor = new RolesView(dirty);
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(troles);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(troles);        
    }
    
    public Vectorer getVectorer() {
        return troles.getVectorerBasic(new int[] {1});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return troles.getComparatorCreator(new int[] {1});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(troles.getRenderStringBasic(new int[] {1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Roles");
    }        
}
