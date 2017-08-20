//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.admin;

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

/**
 *
 * @author adrianromero
 */
public class PeoplePanel extends JPanelTable {
    
    private TableDefinition tpeople;
    private PeopleView jeditor;
    
    /** Creates a new instance of JPanelPeople */
    public PeoplePanel() {
    }
    
    protected void init() {      
        DataLogicAdmin dlAdmin = (DataLogicAdmin) app.getBean("com.choranet.pos.admin.DataLogicAdmin");
        tpeople = dlAdmin.getTablePeople();           
        jeditor = new PeopleView(dlAdmin, dirty);    
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tpeople);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tpeople);        
    }
    
    public Vectorer getVectorer() {
        return tpeople.getVectorerBasic(new int[]{1});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return tpeople.getComparatorCreator(new int[] {1, 3});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tpeople.getRenderStringBasic(new int[]{1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public void activate() throws BasicException {
        
        jeditor.activate(); // primero el editor    
        super.activate(); // y luego cargamos los datos
    }      
    public String getTitle() {
        return AppLocal.getIntString("Menu.Users");
    }     
}
