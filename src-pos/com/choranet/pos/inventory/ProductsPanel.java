//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ListCellRenderer;
import com.choranet.basic.BasicException;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.data.loader.ComparatorCreatorBasic;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.RenderStringBasic;
import com.choranet.data.loader.SentenceList;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.loader.VectorerBasic;
import com.choranet.data.user.BrowsableData;
import com.choranet.data.user.EditorListener;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.data.user.SaveProvider;
import com.choranet.format.Formats;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.panels.JPanelTable;
import com.choranet.pos.ticket.ProductFilter;

/**
 *
 * @author adrianromero
 * Created on 1 de marzo de 2007, 22:15
 *
 */
public class ProductsPanel extends JPanelTable implements EditorListener {
    
    private SentenceList liststock;
    private BrowsableData m_bdstock;

    private ProductsEditor jeditor;
    private ProductFilter jproductfilter;    
    
    private DataLogicSales m_dlSales = null;
    
    /** Creates a new instance of ProductsPanel2 */
    public ProductsPanel() {
    }
    
    protected void init() {   
        m_dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        
        // el panel del filtro
        jproductfilter = new ProductFilter();
        jproductfilter.init(app);
        
        // el panel del editor
        jeditor = new ProductsEditor(m_dlSales, dirty);       

        liststock = m_dlSales.getProductStock();

        // El editable data del stock
        m_bdstock = new BrowsableData(null, new SaveProvider(
                m_dlSales.getStockUpdate(),
                null,
                null));    
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(m_dlSales.getProductCatQBF(), jproductfilter);

    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(
            m_dlSales.getProductCatUpdate(), 
            m_dlSales.getProductCatInsert(), 
            m_dlSales.getProductCatDelete());        
    }
    
    @Override
    public Vectorer getVectorer() {
        return  new VectorerBasic(
                new String[]{"ID", AppLocal.getIntString("label.prodref"), AppLocal.getIntString("label.prodbarcode"), AppLocal.getIntString("label.prodname"), "ISCOM", "ISSCALE", AppLocal.getIntString("label.prodpricebuy"), AppLocal.getIntString("label.prodpricesell"), AppLocal.getIntString("label.prodcategory"), AppLocal.getIntString("label.taxcategory"), "IMAGE", "STOCKCOST", "STOCKVOLUME"},
                new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.BOOLEAN, Formats.BOOLEAN, Formats.CURRENCY, Formats.CURRENCY, Formats.STRING, Formats.STRING, Formats.NULL, Formats.CURRENCY, Formats.DOUBLE},
                new int[] {1, 2, 3, 6, 7});
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return new ComparatorCreatorBasic(
                new String[]{"ID", AppLocal.getIntString("label.prodref"), AppLocal.getIntString("label.prodbarcode"), AppLocal.getIntString("label.prodname"), "ISCOM", "ISSCALE", AppLocal.getIntString("label.prodpricebuy"), AppLocal.getIntString("label.prodpricesell"), AppLocal.getIntString("label.prodcategory"), AppLocal.getIntString("label.taxcategory"), "IMAGE", "STOCKCOST", "STOCKVOLUME"},
                // El productCatDatas del SentenceContainer, igualito
                new Datas[]{Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.BOOLEAN, Datas.BOOLEAN, Datas.DOUBLE, Datas.DOUBLE, Datas.STRING, Datas.STRING, Datas.IMAGE, Datas.DOUBLE, Datas.DOUBLE, Datas.BOOLEAN, Datas.INT},
                new int[]{1, 2, 3, 6, 7, 8, 9});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(new RenderStringBasic(new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING}, new int[]{1, 3}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    @Override
    public Component getFilter() {
        return jproductfilter.getComponent();
    }  
    
    @Override
    public Component getToolbarExtras() {
        
        JButton btnScanPal = new JButton();
        btnScanPal.setText("ScanPal");
        btnScanPal.setVisible(app.getDeviceScanner() != null);
        btnScanPal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanPalActionPerformed(evt);
            }
        });      
        
        return btnScanPal;
    }
    
    private void btnScanPalActionPerformed(java.awt.event.ActionEvent evt) {                                           
  
        JDlgUploadProducts.showMessage(this, app.getDeviceScanner(), bd);
    }  
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Products");
    } 
        
    @Override
    public void activate() throws BasicException {
        
        jeditor.activate(); 
        jproductfilter.activate();
        
        super.activate();
    } 
    
    public void updateValue(Object value) {
        
        // recargo 
        try {
            m_bdstock.loadList(liststock.list(value));
        } catch (BasicException e) {
            m_bdstock.loadList(null);
        }
    }    
}
