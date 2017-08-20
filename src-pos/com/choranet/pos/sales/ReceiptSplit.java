//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales;

import com.choranet.pos.customers.DataLogicCustomers;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.ticket.TicketInfo;
import com.choranet.pos.ticket.TicketLineInfo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author  adrianromero
 */
public class ReceiptSplit extends javax.swing.JDialog {
    
    private boolean accepted;
    
    SimpleReceipt receiptone;
    SimpleReceipt receipttwo;
    
    /** Creates new form ReceiptSplit */
    protected ReceiptSplit(java.awt.Frame parent) {
        super(parent, true);
    }
    /** Creates new form ReceiptSplit */
    protected ReceiptSplit(java.awt.Dialog parent) {
        super(parent, true);
    } 
    
    private void init(String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers, TaxesLogic taxeslogic) {
        
        initComponents();        
        getRootPane().setDefaultButton(m_jButtonOK); 
        
        receiptone = new SimpleReceipt(ticketline, dlSales, dlCustomers, taxeslogic);
        receiptone.setCustomerEnabled(false);
        jPanel5.add(receiptone, BorderLayout.CENTER);
        
        receipttwo = new SimpleReceipt(ticketline, dlSales, dlCustomers, taxeslogic);
        jPanel3.add(receipttwo, BorderLayout.CENTER);
    }
    
    public static ReceiptSplit getDialog(Component parent, String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers, TaxesLogic taxeslogic) {
         
        Window window = getWindow(parent);
        
        ReceiptSplit myreceiptsplit;
        
        if (window instanceof Frame) { 
            myreceiptsplit = new ReceiptSplit((Frame) window);
        } else {
            myreceiptsplit = new ReceiptSplit((Dialog) window);
        }
        
        myreceiptsplit.init(ticketline, dlSales, dlCustomers, taxeslogic);         
        
        return myreceiptsplit;
    } 
    
    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
    
    public boolean showDialog(TicketInfo ticket, TicketInfo ticket2, Object ticketext) {

        receiptone.setTicket(ticket, ticketext);
        receipttwo.setTicket(ticket2, ticketext);
        
        setVisible(true);    
        return accepted;
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        m_jButtonOK = new javax.swing.JButton();
        m_jButtonCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("caption.split")); // NOI18N
        setResizable(false);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/button_ok.png"))); // NOI18N
        m_jButtonOK.setText(AppLocal.getIntString("Button.OK")); // NOI18N
        m_jButtonOK.setFocusPainted(false);
        m_jButtonOK.setFocusable(false);
        m_jButtonOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOK.setRequestFocusEnabled(false);
        m_jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonOK);

        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/button_cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel5);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/2rightarrow.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        jPanel4.add(jButton1, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/1rightarrow.png"))); // NOI18N
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jButton5.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton5.setRequestFocusEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jButton5, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/1leftarrow.png"))); // NOI18N
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/2leftarrow.png"))); // NOI18N
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jButton3, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-730)/2, (screenSize.height-470)/2, 730, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOKActionPerformed

        if (receipttwo.getTicket().getLinesCount() > 0) {
            accepted = true;
            dispose();
        }

    }//GEN-LAST:event_m_jButtonOKActionPerformed

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_m_jButtonCancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean b = false;
        boolean b2 = false;
        
        int ini = receiptone.findAuxiliarParent();
        if (ini>=0){
            receiptone.getJticketLine().setSelectedIndex(ini);
            b = receipttwo.sameProduct(receiptone.getTicket().getLine(receiptone.getJticketLine().getSelectedIndex()));
            b2 = receipttwo.sameProduct(receiptone.getTicket().getLine(ini));
        }
        
        int numAux = receiptone.countNumberAuxiliar();
        
        for (int i = ini; i <= ini+numAux; i++) {
            TicketLineInfo line = receiptone.getSelectedLine();
            if (line != null){                
                if ((numAux!=0) && (line.isProductCom()) && (b || b2)){
                        receipttwo.addLineAfterSelectedLine(line);
                }
                else {
                    receipttwo.addSelectedLine(line);
                }
            }
        }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        TicketLineInfo line;
        boolean b = false;
        boolean b2 = false;
        
        int ini = receiptone.findAuxiliarParent();
        if (ini>=0) {
            b = receipttwo.sameProduct(receiptone.getTicket().getLine(receiptone.getJticketLine().getSelectedIndex()));
            b2 = receipttwo.sameProduct(receiptone.getTicket().getLine(ini));
        }
        
        if (ini != -1){
            receiptone.getJticketLine().setSelectedIndex(ini);
            int numAux = receiptone.countNumberAuxiliar();

            if (numAux!=0){            
                line = receiptone.getSelectedLineUnit();
                receipttwo.addSelectedLine(line);

                int a = receiptone.countNumberAuxiliar();
                if (a != 0){
                    receiptone.getJticketLine().selectionDown();
                }
                
                ini = receiptone.getJticketLine().getSelectedIndex();
                for (int i = ini+1; i <= ini+numAux; i++) {
                    line = receiptone.getSelectedLine();
                    if (line != null){
                        if ((line.isProductCom()) && (b || b2)){
                            receipttwo.addLineAfterSelectedLine(line);
                        }
                        else {
                            receipttwo.addSelectedLine(line);
                        }
                    }
                }    
            }
            else {
                line = receiptone.getSelectedLineUnit();
                receipttwo.addSelectedLine(line);
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        TicketLineInfo line;
        boolean b = false;
        boolean b2 = false;
        
        int ini = receipttwo.findAuxiliarParent();
        if (ini>=0) {
            b = receiptone.sameProduct(receipttwo.getTicket().getLine(receipttwo.getJticketLine().getSelectedIndex()));
            b2 = receiptone.sameProduct(receipttwo.getTicket().getLine(ini));
        }
        
        if (ini != -1){
            receipttwo.getJticketLine().setSelectedIndex(ini);
            int numAux = receipttwo.countNumberAuxiliar();

            if (numAux!=0){            
                line = receipttwo.getSelectedLineUnit();
                receiptone.addSelectedLine(line);

                int a = receipttwo.countNumberAuxiliar();
                if (a != 0){
                    receipttwo.getJticketLine().selectionDown();
                }
                
                ini = receipttwo.getJticketLine().getSelectedIndex();
                for (int i = ini+1; i <= ini+numAux; i++) {
                    line = receipttwo.getSelectedLine();
                    if (line != null){
                        if ((line.isProductCom()) && (b || b2)){
                            receiptone.addLineAfterSelectedLine(line);
                        }
                        else {
                            receiptone.addSelectedLine(line);
                        }
                    }
                }    
            }
            else {
                line = receipttwo.getSelectedLineUnit();
                receiptone.addSelectedLine(line);
            }
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        boolean b = false;
        boolean b2 = false;
        
        int ini = receipttwo.findAuxiliarParent();
        if (ini>=0){
            receipttwo.getJticketLine().setSelectedIndex(ini);
            b = receiptone.sameProduct(receipttwo.getTicket().getLine(receipttwo.getJticketLine().getSelectedIndex()));
            b2 = receiptone.sameProduct(receipttwo.getTicket().getLine(ini));
        }
        
        int numAux = receipttwo.countNumberAuxiliar();
        
        for (int i = ini; i <= ini+numAux; i++) {
            TicketLineInfo line = receipttwo.getSelectedLine();
            if (line != null){                
                if ((numAux!=0) && (line.isProductCom()) && (b || b2)){
                        receiptone.addLineAfterSelectedLine(line);
                }
                else {
                    receiptone.addSelectedLine(line);
                }
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOK;
    // End of variables declaration//GEN-END:variables
    
}