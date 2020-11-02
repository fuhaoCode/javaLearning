 package com.company;


 import java.io.*;

 public class InputStreamReader {
     public static void main(String[] args) {
         String fileName="F:"+ File.separator+"fh"+File.separator+"1809.txt";
         File file=new File(fileName);
         java.io.InputStreamReader inputStreamReader=null;
         try {
             inputStreamReader=new java.io.InputStreamReader(new FileInputStream(file));
             char[] chars = new char[1024];

            int length=inputStreamReader.read(chars);
            System.out.println(new String(chars,0,length));
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }finally {
             try {
                 inputStreamReader.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
 }
