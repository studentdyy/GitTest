package DailyCode.MultiThreading;

import java.util.concurrent.CompletableFuture;

public class Asynchronization {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Asynchronization::fetchPrice);
        //如果执行成功
        cf.thenAccept((result)->{
           System.out.println("price:" + result);
        });
        //如果执行失败
        cf.exceptionally((e)->{
           e.printStackTrace();
           return null;
        });
        Thread.sleep(200);
    }

    static Double fetchPrice(){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
        }
        if(Math.random() < 0.3){
            throw new RuntimeException("fetch price failed!");
        }
        return 5+Math.random() * 20;
    }
}
