package com.company;

import java.io.File;

public class PrintFiles {
    public static void main(String[] args) {
        String filePath="F:"+ File.separator+"fh";
        File file = new File(filePath);

        printAllFiles(file);

    }

    private static void printAllFiles(File file) {
        if (file != null){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f:files) {
                    printAllFiles(f);
                }
            }else {
                if (file.getAbsolutePath().endsWith(".java")){
                    System.out.println(file);
                }
            }
        }
    }
}
