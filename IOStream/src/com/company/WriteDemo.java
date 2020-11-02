package com.company;

import java.io.*;

public class WriteDemo {
    public static void main(String[] args) {
        String fileName="F:"+ File.separator+"fh"+File.separator+"1809.txt";
        File file=new File(fileName);
        Writer writer=null;
        try {
            writer=new FileWriter(file);
            String str="湖北师范大学";
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
