//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

/**
 *
 * @author adrianromero
 */
public interface AppUserView {
    
    public static final String ACTION_TASKNAME = "taskname";
    
    // Acciones de la aplicacion
    public AppUser getUser(); // Usuario logado
    public void showTask(String sTaskClass);
    public void executeTask(String sTaskClass);
}
