//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.mant;
import javax.swing.ListCellRenderer;
import com.choranet.basic.BasicException;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.pos.forms.AppLocal;
import com.choranet.data.loader.TableDefinition;
import com.choranet.format.Formats;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.SaveProvider;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.panels.*;

/**
 *
 * @author adrianromero
 */
public class JPanelPlaces extends JPanelTable {
    
    private TableDefinition tplaces;
    private PlacesEditor jeditor;
    
    /** Creates a new instance of JPanelPlaces */
    public JPanelPlaces() {
    }
    
    protected void init() {
        DataLogicSales dlSales = null;
        dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        
        tplaces = new TableDefinition(app.getSession(),
            "PLACES"
            , new String[] {"ID", "NAME", "X", "Y", "FLOOR"}
            , new String[] {"ID", AppLocal.getIntString("Label.Name"), "X", "Y", AppLocal.getIntString("label.placefloor")}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.INT, Datas.INT, Datas.STRING}
            , new Formats[] {Formats.STRING, Formats.STRING, Formats.INT, Formats.INT, Formats.NULL}
            , new int[] {0}
        ); 
        jeditor = new PlacesEditor(dlSales, dirty); 
    }
        
    public ListProvider getListProvider() {
        return new ListProviderCreator(tplaces);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tplaces);      
    }
    
    public Vectorer getVectorer() {
        return tplaces.getVectorerBasic(new int[]{1});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tplaces.getRenderStringBasic(new int[]{1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }

    public String getTitle() {
        return AppLocal.getIntString("Menu.Tables");
    }      
    
    public void activate() throws BasicException {
        jeditor.activate(); // primero activo el editor 
        super.activate();   // segundo activo el padre        
    }     
}
