//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.mant;

import javax.swing.ListCellRenderer;
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
import com.choranet.pos.panels.*;

/**
 *
 * @author adrianromero
 */
public class JPanelFloors extends JPanelTable {
    
    private TableDefinition tfloors;
    private FloorsEditor jeditor;
    
    /** Creates a new instance of JPanelFloors */
    public JPanelFloors() {
    }
    
    protected void init() {
        tfloors = new TableDefinition(app.getSession(),
            "FLOORS"
            , new String[] {"ID", "NAME", "IMAGE"}
            , new String[] {"ID", AppLocal.getIntString("Label.Name"), "IMAGE"}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.IMAGE}
            , new Formats[] {Formats.NULL, Formats.STRING}
            , new int[] {0}
        );  
        jeditor = new FloorsEditor(dirty); 
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(tfloors);
    }
    
    public Vectorer getVectorer() {
        return tfloors.getVectorerBasic(new int[]{1});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tfloors.getRenderStringBasic(new int[]{1}));
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tfloors);      
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Floors");
    }     
}
