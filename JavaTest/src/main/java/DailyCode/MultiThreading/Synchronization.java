package DailyCode.MultiThreading;
/*
不需要synchronized的操作
JVM规范定义了几种原子操作：

基本类型（long和double除外）赋值，例如：int n = m；
引用类型赋值，例如：List<String> list = anotherList。
*/
public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Count.count);
    }
}
class Count{
    public static final Object object = new Object();
    public static int count = 0;
}
class AddThread extends Thread{
    public void run(){
        for (int i = 0; i < 1000; i++){
            synchronized (Count.object){
                Count.count += 1;
            }
        }
    }
}
class DecThread extends Thread{
    public void run(){
        for (int i = 0; i < 1000; i++){
            synchronized (Count.object){
                Count.count -= 1;
            }
        }
    }
}
/*
多线程同时读写共享变量时，会造成逻辑错误，因此需要通过synchronized同步；

同步的本质就是给指定对象加锁，加锁后才能继续执行后续代码；

注意加锁对象必须是同一个实例；

对JVM定义的单个原子操作不需要同步。
*/