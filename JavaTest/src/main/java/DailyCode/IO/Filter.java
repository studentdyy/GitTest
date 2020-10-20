package DailyCode.IO;

import java.io.*;

public class Filter {
    public static void main(String[] args) throws IOException {
        byte[] data = "Hello Word!".getBytes("UTF-8");
        try(CountIntputStream input = new CountIntputStream(new ByteArrayInputStream(data))){
            int n;
            while ((n = input.read()) != -1){
                System.out.println((char)n);
            }
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }
    }
}
class  CountIntputStream extends FilterInputStream{
    private int count = 0;

    public CountIntputStream(InputStream in) throws FileNotFoundException {
        super(in);
    }


    public int getBytesRead(){
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = in.read();
        if( n != -1){
            count++;
        }
        return n;
    }
}