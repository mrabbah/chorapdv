//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.user;

import java.awt.Component;

public interface EditorRecord extends EditorCreator {
       
    public void writeValueEOF();
    public void writeValueInsert(); 
    public void writeValueEdit(Object value); // not null por definicion.
    public void writeValueDelete(Object value); // not null por definicion.
    
    public void refresh();
    
    public Component getComponent(); 
}
