package com.company;

import java.io.*;

public class ReaderDemo {
    public static void main(String[] args) {
        String fileName="F:"+ File.separator+"fh"+File.separator+"1809.txt";
        File file=new File(fileName);
        Reader reader=null;

        try {
            reader=new FileReader(file);
            char[] chars = new char[1024];

            int length=reader.read(chars);

            System.out.println(new String(chars,0,length));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
