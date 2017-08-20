/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.choranet.pos.util;

/**
 *
 * @author mohamed
 */
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiskUtils {
  private DiskUtils() {  }

 public static void main(String args[]) {
         String serialnumberC = DiskUtils.getSerialNumber("C");
         System.out.println("Serial Number of C drive is "+serialnumberC);
         String serialnumberD = DiskUtils.getSerialNumber("D");
         System.out.println("Serial Number of D drive is "+serialnumberD);
     }

     public static String getSerialNumber(String drive) {
         String result = "";
         try {
             File file = File.createTempFile("tmp",".vbs");
             file.deleteOnExit();
             FileWriter fw = new java.io.FileWriter(file);

             String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                     +"Set colDrives = objFSO.Drives\n"
                     +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
                     +"Wscript.Echo objDrive.SerialNumber";
             fw.write(vbs);
             fw.close();
             Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
             BufferedReader input =
                     new BufferedReader
                     (new InputStreamReader(p.getInputStream()));
             String line;
             while ((line = input.readLine()) != null) {
                 result += line;
             }
             input.close();
         } catch(Exception e){
             System.out.println("Foo bar "+e);

             System.exit(1);
         }
         if(result.trim().length() < 1){
             System.exit(1);
         }

         return result.trim();
     }

     public static String getDefaultSerialNumber() {
         return getSerialNumber("C");
     }
}

