 package com.company;

import java.io.*;

public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        String fileName="F:"+ File.separator+"fh"+File.separator+"1809.txt";
        File file=new File(fileName);
        OutputStreamWriter outputStreamWriter=null;
        try {
            outputStreamWriter=new OutputStreamWriter(new FileOutputStream(file));
            String str="\nhello";
            outputStreamWriter.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
