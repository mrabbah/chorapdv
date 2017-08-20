//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import java.util.Comparator;

public interface ComparatorCreator {
    public String[] getHeaders();
    public Comparator createComparator(int[] index);
}
