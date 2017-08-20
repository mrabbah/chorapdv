@echo off

REM    CHORA POS is a point of sales application designed for touch screens.
REM    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
REM    http://www.choranet.com


set DIRNAME=%~dp0

set CP="%DIRNAME%chorapdv.jar"

set CP=%CP%;"%DIRNAME%lib/jasperreports-3.7.0.jar"
set CP=%CP%;"%DIRNAME%lib/jcommon-1.0.0.jar"
set CP=%CP%;"%DIRNAME%lib/jfreechart-1.0.13.jar"
set CP=%CP%;"%DIRNAME%lib/jdt-compiler-3.1.1.jar"
set CP=%CP%;"%DIRNAME%lib/commons-beanutils-1.7.jar"
set CP=%CP%;"%DIRNAME%lib/commons-digester-1.7.jar"
set CP=%CP%;"%DIRNAME%lib/itext-1.3.1.jar"
set CP=%CP%;"%DIRNAME%lib/poi-3.0.1-FINAL-20070705.jar"
set CP=%CP%;"%DIRNAME%lib/barcode4j-light.jar"
set CP=%CP%;"%DIRNAME%lib/commons-codec-1.3.jar"
set CP=%CP%;"%DIRNAME%lib/velocity-1.5.jar"
set CP=%CP%;"%DIRNAME%lib/oro-2.0.8.jar"
set CP=%CP%;"%DIRNAME%lib/commons-collections-3.1.jar"
set CP=%CP%;"%DIRNAME%lib/commons-lang-2.1.jar"
set CP=%CP%;"%DIRNAME%lib/bsh-core-2.0b4.jar"
set CP=%CP%;"%DIRNAME%lib/RXTXcomm.jar"
set CP=%CP%;"%DIRNAME%lib/jpos1121.jar"
set CP=%CP%;"%DIRNAME%lib/swingx-0.9.3.jar"
set CP=%CP%;"%DIRNAME%lib/substance.jar"
set CP=%CP%;"%DIRNAME%lib/substance-swingx.jar"

rem Apache Axis SOAP libraries.
set CP=%CP%;"%DIRNAME%lib/axis.jar"
set CP=%CP%;"%DIRNAME%lib/jaxrpc.jar"
set CP=%CP%;"%DIRNAME%lib/saaj.jar"
set CP=%CP%;"%DIRNAME%lib/wsdl4j-1.5.1.jar"
set CP=%CP%;"%DIRNAME%lib/commons-discovery-0.2.jar"
set CP=%CP%;"%DIRNAME%lib/commons-logging-1.0.4.jar"

set CP=%CP%;"%DIRNAME%locales/"
set CP=%CP%;"%DIRNAME%reports/"

start /B javaw -cp %CP% -Djava.library.path="%DIRNAME%lib/Windows/i368-mingw32" -Ddirname.path="%DIRNAME%./" com.choranet.pos.forms.StartPOS %1
