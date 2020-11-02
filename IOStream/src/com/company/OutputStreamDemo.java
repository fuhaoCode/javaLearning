package com.company;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        String fileName="F:"+ File.separator+"fh"+File.separator+"1809.txt";
        File file=new File(fileName);
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file,true);
            String s="\nhello";
            byte[] bytes = s.getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
