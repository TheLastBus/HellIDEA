package zy_thread;

import javax.swing.plaf.synth.SynthTreeUI;

public class ThreadDemo1 {
    public static void main(String[] args) {

        Myrunnable mu = new Myrunnable();
        Thread t = new Thread(mu);
        t.setName("Thread000");
        //优先级高 可以提高该线程抢占cpu时间片概率大
        t.setPriority(Thread.MAX_PRIORITY);
        //线程可以分为守护线程和 用户线程(非) 当进程中没有用户线程时  jvm会退出
        t.setDaemon(true); //把线程设置为守护线程(main 会执行完 而它不会.. 比如关机后)
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main"+i);
            try {
                t.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }
}
class Myrunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}