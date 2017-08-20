//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.editor;

import java.awt.Component;

public interface EditorComponent {
    
    public void addEditorKeys(EditorKeys ed);    
    public Component getComponent();
    
    public void deactivate();
    public void typeChar(char c) ;
    public void transChar(char c);
}
