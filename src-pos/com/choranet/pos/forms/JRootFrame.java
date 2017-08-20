//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;


import java.awt.BorderLayout;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import com.choranet.pos.instance.AppMessage;
import com.choranet.pos.instance.InstanceManager;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author  adrianromero
 */
public class JRootFrame extends JRoot implements AppMessage {
    
    
    /** Creates new form JRootFrame */
    public JRootFrame() {
        
        initComponents();    
    }
    
    public void initFrame(AppProperties props) {
        
        m_props = props;
        
        m_rootapp = new JRootApp();
        
        if (m_rootapp.initApp(m_props)) {
            
            // Register the running application
            try {
                m_instmanager = new InstanceManager(this);
            } catch (Exception e) {
            }
        
            // Show the application
            add(m_rootapp, BorderLayout.CENTER);            
 
            try {
                this.setIconImage(ImageIO.read(JRootFrame.class.getResourceAsStream("/com/choranet/images/favicon.png")));
            } catch (IOException e) {
            }   
            setTitle(AppLocal.APP_NAME + " - " + AppLocal.APP_VERSION);
            pack();
            setLocationRelativeTo(null);        
            
            setVisible(true);                        
        } else {
            //new JFrmConfig(props).setVisible(true); // Show the configuration window.
            System.exit(0);
        }
    }
    
    public void restoreWindow() throws RemoteException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (getExtendedState() == JFrame.ICONIFIED) {
                    setExtendedState(JFrame.NORMAL);
                }
                requestFocus();
            }
        });
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        m_rootapp.tryToClose();
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        System.exit(0);
        
    }//GEN-LAST:event_formWindowClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}