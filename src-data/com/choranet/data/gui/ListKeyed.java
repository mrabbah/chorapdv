//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.gui;

import com.choranet.data.loader.IKeyed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrianromero
 */
public class ListKeyed<K extends IKeyed> extends ArrayList<K> {
    
    public ListKeyed(List<K> list) {
        this.addAll(list);
    }

    public K get(Object key) {

        for (K elem : this) {
            if ((key == null && elem.getKey() == null) || (key != null && key.equals(elem.getKey()))) {
                return elem;
            }
        }
        return null;
    }
}
