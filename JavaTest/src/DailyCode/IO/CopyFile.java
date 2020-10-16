package DailyCode.IO;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        /*if (args.length != 2) {
            System.err.println("Usage:\n  java CopyFile.java <source> <target>");
            System.exit(1);
        }*/
        copy(new File("src\\DailyCode\\IO\\readme.txt"), new File("src\\DailyCode\\IO\\copyfile.txt"));
    }

    static void copy(File source, File target) throws IOException {
        // 友情提示：测试时请使用无关紧要的文件
        // TODO:
        try (InputStream input = new FileInputStream(source); OutputStream output = new FileOutputStream(target)) {
            int len;
            byte[] b = new byte[1024];
            while((len = input.read(b)) != -1){
                output.write(b,0,len);
            }
            System.out.println("copy success");
        }
    }
}
