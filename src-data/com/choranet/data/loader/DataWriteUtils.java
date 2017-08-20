//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author  adrian
 */
public class DataWriteUtils {
    
    private static DateFormat tsf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
    
    /** Creates a new instance of DataWriteUtils */
    public DataWriteUtils() {
    }
    
    public static String getSQLValue(Object obj) {
        if (obj == null) {
            return "NULL";
        } else if (obj instanceof Double) {
            return getSQLValue((Double) obj);
        } else if (obj instanceof Integer) {
            return getSQLValue((Integer) obj);
        } else if (obj instanceof Boolean) {
            return getSQLValue((Boolean) obj);
        } else if (obj instanceof String) {
            return getSQLValue((String) obj);
        } else if (obj instanceof Date) {
            return getSQLValue((Date) obj);
        } else {
            return getSQLValue(obj.toString());
        }            
    }
    
    public static String getSQLValue(Integer iValue) {
        if (iValue == null) {
            return "NULL";
        } else {
            return iValue.toString();
        }
    }
    
    public static String getSQLValue(Double dValue) {
        if (dValue == null) {
            return "NULL";
        } else {
            return dValue.toString();
        }
    }
    
    public static String getSQLValue(Boolean bValue) {
        if (bValue == null) {
            return "NULL";
        } else {
            return bValue.booleanValue() ? "TRUE" : "FALSE";
        }
    }
    
    public static String getSQLValue(String sValue) {
        if (sValue == null) {
            return "NULL";
        } else {
            return '\'' + getEscaped(sValue) + '\'';
        }
    }
    
    public static String getSQLValue(Date dValue) {
        if (dValue == null) {
            return "NULL";
        } else {
            return "{ts '" + tsf.format(dValue) + "'}";
        }
    }
    
    public static String getEscaped(String sValue) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sValue.length(); i++) {
            switch (sValue.charAt(i)) {
                case '\\':
                    sb.append("\\\\");
                    break;
                 case '\'':
                    sb.append("\\'");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                default: 
                    sb.append(sValue.charAt(i));
                    break;
            }
        }
        return sb.toString();
    }
 }
