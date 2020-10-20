package DailyCode.MultiThreading;

/*
Java用Thread对象表示一个线程，通过调用start()启动一个新线程；

一个线程对象只能调用一次start()方法；

线程的执行代码写在run()方法中；

线程调度由操作系统决定，程序本身无法决定调度顺序；

Thread.sleep()可以把当前线程暂停一段时间。
*/
public class Base {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");
        Thread t = new Thread(()->{
            System.out.println("启动了一个新线程 t");
            System.out.println("结束了一个线程 t");
        });
        Thread th = new Thread(){
            public void run(){
                System.out.println("启动了一个新线程 th");
                System.out.println("结束了一个线程 th");
            }
        };
        th.setPriority(1);
        t.setPriority(6);
        th.start();
        //当main线程对线程对象t调用join()方法时，主线程将等待变量t表示的线程运行结束，
        //即join就是指等待该线程结束，然后才继续往下执行自身线程。
        th.join();
        t.start();
        //此外，join(long)的重载方法也可以指定一个等待时间，超过等待时间后就不再继续等待。
        t.join();
        System.out.println("main end...");
    }
}
/*
在Java程序中，一个线程对象只能调用一次start()方法启动新线程，并在新线程中执行run()方法。一旦run()方法执行完毕，线程就结束了。因此，Java线程的状态有以下几种：

New：新创建的线程，尚未执行；
Runnable：运行中的线程，正在执行run()方法的Java代码；
Blocked：运行中的线程，因为某些操作被阻塞而挂起；
Waiting：运行中的线程，因为某些操作在等待中；
Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
Terminated：线程已终止，因为run()方法执行完毕。
*/