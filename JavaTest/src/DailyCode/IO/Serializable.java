package DailyCode.IO;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.util.Arrays;

public class Serializable {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        //序列化
        try(ObjectOutputStream output = new ObjectOutputStream(buffer)){
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("LALALA");

        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        //反序列,反序列化时，由JVM直接构造出Java对象，不调用构造方法，构造方法内部的代码，在反序列化时根本不可能执行
        ByteArrayInputStream bufferin = new ByteArrayInputStream(buffer.toByteArray());
        try(ObjectInputStream input = new ObjectInputStream(bufferin)){
            int n = input.readInt();
            String s = input.readUTF();
            System.out.println(n);
            System.out.println(s);
        }
    }
}
