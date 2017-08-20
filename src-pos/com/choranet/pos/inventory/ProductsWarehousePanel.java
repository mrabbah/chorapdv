//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListCellRenderer;
import com.choranet.basic.BasicException;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.data.loader.ComparatorCreatorBasic;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.RenderStringBasic;
import com.choranet.data.loader.SentenceExec;
import com.choranet.data.loader.SentenceExecTransaction;
import com.choranet.data.loader.SerializerReadBasic;
import com.choranet.data.loader.SerializerWriteBasicExt;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.loader.VectorerBasic;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.data.user.SaveProvider;
import com.choranet.format.Formats;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.panels.JPanelTable;
import com.choranet.pos.reports.JParamsLocation;

/**
 *
 * @author adrianromero
 */
public class ProductsWarehousePanel extends JPanelTable {

    private JParamsLocation m_paramslocation;
    
    private ProductsWarehouseEditor jeditor;
    private ListProvider lpr;
    private SaveProvider spr;
    
    private Datas[] prodstock = new Datas[] {Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.DOUBLE, Datas.DOUBLE, Datas.DOUBLE};
    
    /** Creates a new instance of ProductsWarehousePanel */
    public ProductsWarehousePanel() {
    }
    
    protected void init() {   
               
        m_paramslocation =  new JParamsLocation();
        m_paramslocation.init(app);
        m_paramslocation.addActionListener(new ReloadActionListener());
        

        lpr = new ListProviderCreator(new PreparedSentence(app.getSession(),
                "SELECT PRODUCTS.ID, PRODUCTS.REFERENCE, PRODUCTS.NAME, ?," +
                "S.STOCKSECURITY, S.STOCKMAXIMUM, COALESCE(S.UNITS, 0) " +
                "FROM PRODUCTS LEFT OUTER JOIN " +
                "(SELECT PRODUCT, LOCATION, STOCKSECURITY, STOCKMAXIMUM, UNITS FROM STOCKCURRENT WHERE LOCATION = ?) S " +
                "ON PRODUCTS.ID = S.PRODUCT ORDER BY PRODUCTS.NAME",
                new SerializerWriteBasicExt(new Datas[] {Datas.OBJECT, Datas.STRING}, new int[]{1, 1}),
                new SerializerReadBasic(prodstock)),
                m_paramslocation);
        
        
        SentenceExec updatesent =  new SentenceExecTransaction(app.getSession()) {
            public int execInTransaction(Object params) throws BasicException {
                if (new PreparedSentence(app.getSession()
                        , "UPDATE STOCKCURRENT SET STOCKSECURITY = ?, STOCKMAXIMUM = ? WHERE LOCATION = ? AND PRODUCT = ?"
                        , new SerializerWriteBasicExt(prodstock, new int[] {4, 5, 3, 0})).exec(params) == 0) {
                    return new PreparedSentence(app.getSession()
                        , "INSERT INTO STOCKCURRENT (LOCATION, PRODUCT, STOCKSECURITY, STOCKMAXIMUM, UNITS) VALUES (?, ?, ?, ?, 0)"
                        , new SerializerWriteBasicExt(prodstock, new int[] {3, 0, 4, 5})).exec(params);
                } else {
                    return 1;
                }
            }
        };     
        
        spr = new SaveProvider(updatesent, null, null);
         
        jeditor = new ProductsWarehouseEditor(dirty);   
    }    
    
    public ListProvider getListProvider() {
        return lpr;
    }
    
    public SaveProvider getSaveProvider() {
        return spr;        
    }    
    
    @Override
    public Vectorer getVectorer() {
        return new VectorerBasic(
                new String[]{"ID", AppLocal.getIntString("label.prodref"), AppLocal.getIntString("label.prodname"), "MINIMUM", "MAXIMUM", "UNITS"},
                new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.DOUBLE, Formats.DOUBLE, Formats.DOUBLE}, 
                new int[]{1, 2});        
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return new ComparatorCreatorBasic(
                new String[]{"ID", AppLocal.getIntString("label.prodref"), AppLocal.getIntString("label.prodname"), "MINIMUM", "MAXIMUM", "UNITS"},
                prodstock, 
                new int[]{1, 2});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(new RenderStringBasic(new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING}, new int[]{1, 2}));
    }
    
    @Override
    public Component getFilter() {
        return m_paramslocation.getComponent();
    }  
    
    public EditorRecord getEditor() {
        return jeditor;
    }  
    
    @Override
    public void activate() throws BasicException {
        
        m_paramslocation.activate(); 
        super.activate();
    }     
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.ProductsWarehouse");
    }      
    
    private class ReloadActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                ProductsWarehousePanel.this.bd.actionLoad();
            } catch (BasicException w) {
            }
        }
    }
}
