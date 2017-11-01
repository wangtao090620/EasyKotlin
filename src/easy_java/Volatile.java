package easy_java;

/**
 * Created by wangtao on 2017/10/23.
 */
public class Volatile {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
//        new ReaderThread().start();
//        number = 42;
//        ready = true;

        System.out.println(-1>>1);

    }







}
