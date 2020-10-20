package DailyCode.NetworkProgramming;


import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(6666);//指定一个端口
        System.out.println("Server is running....");
        for(;;){
            Socket sock  = ss.accept();//当accept方法阻塞的时候，才会往下继续
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }

    }
}
  class Handler extends Thread{
    Socket sock;
    public Handler(Socket sock){
        this.sock = sock;
    }
    @Override
    public void run(){
        try(InputStream input = this.sock.getInputStream()){
            try(OutputStream output = this.sock.getOutputStream()){
                handle(input,output);
            }
        }catch (Exception e){
            try{
                this.sock.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected");
        }
    }

      private void handle(InputStream input, OutputStream output) throws IOException {
          BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
          BufferedReader reader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8));
          writer.write("hello\n");
          writer.flush();
          Scanner sc = new Scanner(System.in);
          for(;;){
              String s = reader.readLine();
              if(s.equals("bye")){
                  writer.write("bye\n");
                  writer.flush();
                  break;
              }else{
                  System.out.println("[ClientAnswer]"+s);
              }

              writer.write(sc.nextLine()+"\n");
              writer.flush();
          }
      }
  }