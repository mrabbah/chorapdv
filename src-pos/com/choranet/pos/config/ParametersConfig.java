/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.choranet.pos.config;

import com.choranet.data.user.DirtyManager;
import com.choranet.pos.util.StringParser;
import java.awt.Component;

/**
 *
 * @author mohamed
 */
public interface ParametersConfig {

    public Component getComponent();

    public void addDirtyManager(DirtyManager dirty);

    public void setParameters(StringParser p);
    public String getParameters();


}
