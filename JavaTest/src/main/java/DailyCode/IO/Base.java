package DailyCode.IO;

import java.io.*;

public class Base {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\GitRepository\\JavaTest\\src\\DailyCode\\IO\\readme.txt");
        System.out.println(f);
        //调用isFile()，判断该File对象是否是一个已存在的文件
        System.out.println(f.isFile());
        //调用isDirectory()，判断该File对象是否是一个已存在的目录
        System.out.println(f.isDirectory());

        InputStream input = null;
        try {
            input = new FileInputStream("src\\DailyCode\\IO\\readme.txt");
            int n;
            while ((n = input.read()) != -1) { // 利用while同时读取并判断
                System.out.println(n);
            }
        } finally {
            if (input != null) { input.close(); }
        }

        //利用Java 7引入的新的try(resource)的语法，只需要编写try语句，让编译器自动为我们关闭资源
        try (InputStream input2 = new FileInputStream("src\\DailyCode\\IO\\readme.txt")) {
            int n;
            while ((n = input2.read()) != -1) {
                System.out.println((char)n);
            }
        } // 编译器在此自动为我们写入finally并调用close()

        /*
        缓冲
        在读取流的时候，一次读取一个字节并不是最高效的方法。很多流支持一次性读取多个字节到缓冲区，对于文件和网络流来说，利用缓冲区一次性读取多个字节效率往往要高很多。InputStream提供了两个重载方法来支持读取多个字节：

        int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
        int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
        */
        System.out.println("===========================================");
        try(InputStream input3 = new FileInputStream("src\\DailyCode\\IO\\readme.txt")){
            byte[] b = new byte[1000];
            int n;
            while((n = input3.read(b)) != -1){
                System.out.println("read "+n+" bytes");
            }
        }

        try(OutputStream output1 = new FileOutputStream("src\\DailyCode\\IO\\writerme.txt")){
            output1.write("Hello!".getBytes("UTF-8"));
        }


        try(InputStream input4 = Base.class.getResourceAsStream("readme.txt")){
            byte[] b = new byte[1024];
            int n = 0;
            System.out.println("=====");
            while( (n = input4.read(b)) != -1 ){
                System.out.println(n);
            }
        }
    }
}
