//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.inventory;

import com.choranet.basic.BasicException;
import com.choranet.data.gui.ListCellRendererBasic;
import com.choranet.data.loader.ComparatorCreator;
import com.choranet.data.loader.TableDefinition;
import com.choranet.data.loader.Vectorer;
import com.choranet.data.user.EditorRecord;
import com.choranet.data.user.ListProvider;
import com.choranet.data.user.ListProviderCreator;
import com.choranet.data.user.SaveProvider;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.panels.JPanelTable;
import com.choranet.pos.panels.AuxiliarFilter;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListCellRenderer;

/**
 *
 * @author jaroslawwozniak
 */
public class AuxiliarPanel extends JPanelTable{

    private AuxiliarEditor jeditor;
    private TableDefinition tAuxiliar;
    private DataLogicSales dlSales;
    private AuxiliarFilter filter;
    private ListProviderCreator lpr;

    protected void init() {
        dlSales = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
        filter = new AuxiliarFilter();
        filter.addActionListener(new ReloadActionListener());
        filter.init(app);
        tAuxiliar = dlSales.getTableAuxiliar();
        jeditor = new AuxiliarEditor(app, dirty, filter);
        filter.forwardEditor(jeditor);     
    }

    @Override
    public void activate() throws BasicException {
        jeditor.activate();
        filter.activate();
        super.activate();
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public ListProvider getListProvider() {
        return  new ListProviderCreator(dlSales.getAuxiliarList(), filter);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(dlSales.getAuxiliarInsert()
                            , dlSales.getAuxiliarInsert()
                            , dlSales.getAuxiliarDelete());
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Auxiliar");
    }

    @Override
    public Vectorer getVectorer() {
        return tAuxiliar.getVectorerBasic(new int[]{1});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return tAuxiliar.getComparatorCreator(new int[] {1});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tAuxiliar.getRenderStringBasic(new int[]{0}));
    }

    @Override
    public Component getFilter(){
        return filter.getComponent();
    }

    private class ReloadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AuxiliarPanel.this.bd.actionLoad();
            } catch (BasicException w) {
            }
        }
    }

    public void refresh(){
    }
}
