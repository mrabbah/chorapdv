@echo off

REM    CHORA POS is a point of sales application designed for touch screens.
REM    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
REM    http://www.choranet.com



set DIRNAME=%~dp0

set CP="%DIRNAME%chorapdv.jar"

set CP=%CP%;"%DIRNAME%locales/"
set CP=%CP%;"%DIRNAME%locales/substance.jar"

start /B javaw -cp %CP% com.choranet.pos.forms.JDlgAuthentication
