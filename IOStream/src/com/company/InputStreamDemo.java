package com.company;

import java.io.*;

public class InputStreamDemo {
    public static void main(String[] args) {
        String fileName="F:"+ File.separator+"fh"+File.separator+"1809.txt";
        File file=new File(fileName);
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
            byte[] bytes = new byte[1024];
//            int length=inputStream.read(bytes);
//            System.out.println(new String(bytes,0,length));
            int temp=0;
            int length=0;
            while ((temp=inputStream.read())!=-1){
                bytes[length]=(byte)temp;
                length++;
            }
            System.out.println(new String(bytes,0,length));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
