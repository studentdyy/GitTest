package DailyCode.IO;

import java.io.*;

/*
Reader是Java的IO库提供的另一个输入流接口。和InputStream的区别是，
InputStream是一个字节流，即以byte为单位读取，而Reader是一个字符流，即以char为单位读取：
InputStream	                            Reader
字节流，以byte为单位	                    字符流，以char为单位
读取字节（-1，0~255）：int read()	        读取字符（-1，0~65535）：int read()
读到字节数组：int read(byte[] b)	        读到字符数组：int read(char[] c)
*/
public class ReaderClass {
    public static void main(String[] args) throws IOException {
        try(Reader reader = new FileReader("src\\DailyCode\\IO\\writerme.txt")){
            char[] buffer = new char[1024];
            int n;
            while((n = reader.read(buffer)) != -1){
                System.out.println( "read " + n + " chars.");
            }
        }
/*
Reader和InputStream有什么关系？

除了特殊的CharArrayReader和StringReader，
普通的Reader实际上是基于InputStream构造的，
因为Reader需要从InputStream中读入字节流（byte），
然后，根据编码设置，再转换为char就可以实现字符流。
如果我们查看FileReader的源码，它在内部实际上持有一个FileInputStream。

既然Reader本质上是一个基于InputStream的byte到char的转换器，
那么，如果我们已经有一个InputStream，想把它转换为Reader，
是完全可行的。InputStreamReader就是这样一个转换器，
它可以把任何InputStream转换为Reader
*/
        try (Reader reader = new InputStreamReader(new FileInputStream("src\\DailyCode\\IO\\writerme.txt"), "UTF-8")) {
            // TODO:

        }
    }

}
/*
Reader定义了所有字符输入流的超类：

FileReader实现了文件字符流输入，使用时需要指定编码；
CharArrayReader和StringReader可以在内存中模拟一个字符流输入。
Reader是基于InputStream构造的：可以通过InputStreamReader在指定编码的同时将任何InputStream转换为Reader。

总是使用try (resource)保证Reader正确关闭。
*/