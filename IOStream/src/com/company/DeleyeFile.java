package com.company;

import java.io.File;

public class DeleyeFile {
    public static void main(String[] args) {
        String  fileName = "F:"+ File.separator+"fh"+File.separator+"1809.txt";
        File file=new File(fileName);
        if (file.exists()){
            file.delete();
            System.out.println("删除文件成功");
        }else{
            System.out.println("文件不存在");
        }
    }
}
