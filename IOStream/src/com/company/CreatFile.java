package com.company;

import java.io.File;
import java.io.IOException;

public class CreatFile {
    public static void main(String[] args) {
        File file = new File("F:"+File.separator+"fh"+File.separator+"1809.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
                System.out.println("创建文件成功");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
