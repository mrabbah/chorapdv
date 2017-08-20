//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.reports;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.SerializerWrite;
import com.choranet.data.user.EditorCreator;
import com.choranet.pos.forms.AppView;
import java.awt.Component;

/**
 *
 * @author adrianromero
 */
public interface ReportEditorCreator extends EditorCreator {
    
    public void init(AppView app);
    public void activate() throws BasicException;
    public SerializerWrite getSerializerWrite();
    public Component getComponent();
}
