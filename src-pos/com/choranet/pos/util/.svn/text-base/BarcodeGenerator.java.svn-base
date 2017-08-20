/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.choranet.pos.util;

/**
 *
 * @author mohamed
 */
public class BarcodeGenerator {

    public static String getEANKey(String code) {

        // {1 - 6}
        int key = -1,
                codeLength = code.length();
        // {12 - ...}
        if (codeLength >= 12) {
            key = getEANKey(code, 13);
            code = code.substring(0, 12);
        } else {
            // {7 - 11}
            if (codeLength >= 7) {
                key = getEANKey(code, 8);
                code = code.substring(0, 7);
            }
        }
        if (key == -1) {
            //message d'erreur : taille du code est non valide
            return null;
        }
        return code.concat(String.valueOf(key));
    }

    public static int getEANKey(String code, int codeEAN) {
        //int key = -1;
        //if (code.length()>= codeEAN-1){
        int key = 0;
        code = code.concat("0");
        //System.out.println("code ;;; " + code);
        codeEAN = codeEAN - 1;
        int sum = 0, rest,
        // for EAN13
        poid = 1 ;
        // for EAN8
        if (codeEAN == 7){
            poid = 3;
        }
        //System.out.println("poid : " + poid);
        int[] digits = new int[codeEAN];
        for (int ind = 0; ind < codeEAN; ind++) {
            digits[ind] = Integer.parseInt(code.substring(ind, ind + 1)) * poid;
            sum += digits[ind];
            if (poid == 3) {
                poid = 1;
            } else {
                poid = 3;
            }
        }
        rest = sum % 10;
        if (rest != 0) {
            key = 10 - rest;
        }
        //}
        return key;
    }

    public static String getEAN13Code(String code) {
        int key = getEANKey(code, 13);
        if (key == -1) {
            //message d'erreur : taille du code est non valide
            return null;
        }
        return code.substring(0, 12).concat(String.valueOf(key));
    }

    public static String getEAN8Code(String code) {
        int key = getEANKey(code, 8);
        if (key == -1) {
            //message d'erreur : taille du code est non valide
            return null;
        }
        return code.substring(0, 7).concat(String.valueOf(key));
    }

    public static void main(String args[]) {

        String code = "370059211786544";
        code = getEANKey(code);
        System.out.println("code = " + code);

        code = "370059211786";
        code = getEANKey(code);
        System.out.println("code = " + code);

        code = "37005921178";
        code = getEANKey(code);
        System.out.println("code = " + code);

        code = "3700596";
        code = getEANKey(code);
        System.out.println("code = " + code);

        code = "1314315";
        code = getEANKey(code);
        System.out.println("code = " + code);
    }
}
