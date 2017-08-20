//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.basic.BasicException;
import com.choranet.data.gui.MessageInf;

/**
 *
 * @author adrianromero
 */
public interface ProcessAction {
   
    public MessageInf execute() throws BasicException;
}
