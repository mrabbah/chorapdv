#!/bin/sh

#    CHORA POS is a point of sales application designed for touch screens.
#    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
#    http://www.choranet.com


DIRNAME=`dirname $0`

CP=$DIRNAME/choranet.jar

CP=$CP:$DIRNAME/locales/
CP=$CP:$DIRNAME/lib/substance.jar


java -cp $CP -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel com.choranet.pos.config.JFrmConfig
