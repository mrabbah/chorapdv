//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.reports;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.QBFCompareEnum;
import com.choranet.data.loader.SerializerWrite;
import com.choranet.data.loader.SerializerWriteBasic;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.AppView;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.panels.JProductFinder;
import com.choranet.pos.ticket.ProductInfoExt;
import java.awt.Component;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author  adrianromero
 */
public class JParamsProduct extends javax.swing.JPanel implements ReportEditorCreator {
    
    private DataLogicSales dlProducts;
    private ProductInfoExt currentproduct;
    
    /** Creates new form JParamsCustomer */
    public JParamsProduct() {

        initComponents();
        
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                currentproduct = null;
            }
            public void removeUpdate(DocumentEvent e) {
                currentproduct = null;
            }
            public void changedUpdate(DocumentEvent e) {
                currentproduct = null;
            }
        });
    }

    public void init(AppView app) {
        dlProducts = (DataLogicSales) app.getBean("com.choranet.pos.forms.DataLogicSalesCreate");
    }
    
    public void activate() throws BasicException {
        
        currentproduct = null;
        jTextField1.setText(null);        
    }
            
    public SerializerWrite getSerializerWrite() {
        return new SerializerWriteBasic(new Datas[] {Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING});
    }

    public Component getComponent() {
        return this;
    }
    
    public Object createValue() throws BasicException {
        
        if (currentproduct == null) {
            if (jTextField1.getText() == null || jTextField1.getText().equals("")) {
                return new Object[] {QBFCompareEnum.COMP_NONE, null, QBFCompareEnum.COMP_NONE, null};
            } else {
                return new Object[] {QBFCompareEnum.COMP_NONE, null, QBFCompareEnum.COMP_RE, jTextField1.getText()};
            }
        } else {
            return new Object[] {QBFCompareEnum.COMP_EQUALS, currentproduct.getID(), QBFCompareEnum.COMP_NONE, null};
        }
    }     
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnCustomer = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(AppLocal.getIntString("label.byproduct"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 60));
        setLayout(null);

        jLabel1.setText(AppLocal.getIntString("label.product")); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 20, 120, 14);
        add(jTextField1);
        jTextField1.setBounds(140, 20, 200, 20);

        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/fileopen.png"))); // NOI18N
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        add(btnCustomer);
        btnCustomer.setBounds(350, 20, 50, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed

        currentproduct = JProductFinder.showMessage(this, dlProducts);
        if (currentproduct == null) {
            jTextField1.setText(null);
        } else {
            jTextField1.setText(currentproduct.getName());
        }
        
    }//GEN-LAST:event_btnCustomerActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
