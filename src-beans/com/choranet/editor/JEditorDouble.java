//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.editor;

import com.choranet.format.Formats;

public class JEditorDouble extends JEditorNumber {
    
    /** Creates a new instance of JEditorDouble */
    public JEditorDouble() {
    }
    
    protected Formats getFormat() {
        return Formats.DOUBLE;
    }    
    
    protected int getMode() {
        return EditorKeys.MODE_DOUBLE;
    }      
}
