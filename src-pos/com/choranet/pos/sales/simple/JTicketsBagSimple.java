//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales.simple;

import com.choranet.pos.forms.*;
import javax.swing.*;
import com.choranet.pos.sales.*;
import com.choranet.pos.ticket.TicketInfo;

public class JTicketsBagSimple extends JTicketsBag {
    
    /** Creates new form JTicketsBagSimple */
    public JTicketsBagSimple(AppView app, TicketsEditor panelticket) {
        
        super(app, panelticket);
        
        initComponents();
    }
    
    public void activate() {
        
        m_panelticket.setActiveTicket(new TicketInfo(), null);
        
        // Authorization
        m_jDelTicket.setEnabled(m_App.getAppUserView().getUser().hasPermission("com.choranet.pos.sales.JPanelTicketEdits"));

    }
    public boolean deactivate() {
        m_panelticket.setActiveTicket(null, null);      
        return true;
    }
    
    public void deleteTicket() {           
        m_panelticket.setActiveTicket(new TicketInfo(), null);
    }
    
    protected JComponent getBagComponent() {
        return this;
    }
    protected JComponent getNullComponent() {
        return new JPanel();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        m_jDelTicket = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        m_jDelTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/choranet/images/editdelete.png")));
        m_jDelTicket.setFocusPainted(false);
        m_jDelTicket.setFocusable(false);
        m_jDelTicket.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jDelTicket.setRequestFocusEnabled(false);
        m_jDelTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jDelTicketActionPerformed(evt);
            }
        });

        add(m_jDelTicket);

    }// </editor-fold>//GEN-END:initComponents

    private void m_jDelTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jDelTicketActionPerformed
        
        int res = JOptionPane.showConfirmDialog(this, AppLocal.getIntString("message.wannadelete"), AppLocal.getIntString("title.editor"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            deleteTicket();
        }
        
    }//GEN-LAST:event_m_jDelTicketActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_jDelTicket;
    // End of variables declaration//GEN-END:variables
    
}