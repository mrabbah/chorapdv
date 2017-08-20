//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.editor;

public class JEditorString extends JEditorText {
    
    /** Creates a new instance of JEditorString */
    public JEditorString() {
        super();
    }
    
    protected final int getMode() {
        return EditorKeys.MODE_STRING;
    }
        
    protected int getStartMode() {
        return MODE_Abc1;
    }
    
}

