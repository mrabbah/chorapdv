/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.choranet.pos.forms;

import com.choranet.basic.BasicException;
import com.choranet.pos.instance.InstanceManager;
import javax.swing.JFrame;

/**
 *
 * @author mohamed
 */
public class JRoot extends JFrame {

    protected InstanceManager m_instmanager = null;

    protected JRootApp m_rootapp;
    protected AppProperties m_props;

    public JRoot() {
    }

    // Variables declaration - do not modify
    // End of variables declaration

    public RefClient getRefClient() throws BasicException{
        return m_rootapp.getM_dlSystem().findRefClient();
    }

    public void execKeyDD(Object params) throws BasicException{
        m_rootapp.getM_dlSystem().execKeyDD(params);
    }

    public int getPtoductNomber() throws BasicException{
       return Integer.parseInt(m_rootapp.getM_dlSystem().findProductsNbr());
    }
    public String getHostName() {
        return m_rootapp.getM_props().getHost();
    }



}
