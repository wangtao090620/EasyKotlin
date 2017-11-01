package easy_java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by wangtao on 2017/10/23.
 */
public class NewThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //第一种方式

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread name: " + Thread.currentThread().getName());
            }
        };

        thread1.start();


        //第二种方式

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name: " + Thread.currentThread().getName());
            }
        });

        thread2.start();


        //第三种方式


        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("thread name: " + Thread.currentThread().getName());
                return "task";
            }
        });

        Thread thread3 = new Thread(task);

       thread3.start();


        String result = task.get();

        System.out.println(result);//输出task
    }
}
