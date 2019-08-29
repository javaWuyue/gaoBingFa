package lockSupport;


import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");


    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run (){
            synchronized (u){
                System.out.println("in  " + getName());
                LockSupport.park();  // 阻塞当前线程 将许可变为 不可用
            }
        }
    }


    @Test
    public void testDemo () throws InterruptedException{
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);    // 同行当前线程  将不可用许可 变为可用许可
        LockSupport.unpark(t2);
        t1.join();     //让主线程等带t1线程执行完毕
        t2.join();

    }

}
