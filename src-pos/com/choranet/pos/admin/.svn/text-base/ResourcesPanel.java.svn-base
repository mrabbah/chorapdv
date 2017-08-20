//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.admin;

import javax.swing.ListCellRenderer;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.pos.forms.*;
import com.choranet.pos.panels.*;
import com.choranet.data.loader.TableDefinition;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.user.*;

/**
 *
 * @author adrianromero
 */
public class ResourcesPanel extends JPanelTable {

    private TableDefinition tresources;
    private ResourcesView jeditor;
    
    /** Creates a new instance of JPanelResources */
    public ResourcesPanel() {
    }
    
    protected void init() {
        DataLogicAdmin dlAdmin = (DataLogicAdmin) app.getBean("com.choranet.pos.admin.DataLogicAdmin");
        tresources = dlAdmin.getTableResources();         
        jeditor = new ResourcesView(dirty);           
    }    
    
    @Override
    public boolean deactivate() {
        if (super.deactivate()) {
            DataLogicSystem dlSystem = (DataLogicSystem) app.getBean("com.choranet.pos.forms.DataLogicSystemCreate");
            dlSystem.resetResourcesCache();
            return true;
        } else {
            return false;
        }    
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tresources);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tresources);        
    }
    
    public Vectorer getVectorer() {
        return tresources.getVectorerBasic(new int[] {1});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return tresources.getComparatorCreator(new int[] {1, 2});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tresources.getRenderStringBasic(new int[] {1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Resources");
    }        
}
