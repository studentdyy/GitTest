package DailyCode.NetworkProgramming;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost",6666);
        try(InputStream input = sock.getInputStream()){
            try(OutputStream output = sock.getOutputStream()){
                handle(input,output);
            }
        }
        sock.close();
        System.out.println("disconnected");
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in);
        System.out.println("[Server]" + reader.readLine());
        for(;;){
            String s = sc.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("[ServerAnswer]" + resp);
            if(resp.equals("bye")){
                break;
            }
        }
    }
}
