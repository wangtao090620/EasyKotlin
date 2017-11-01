package easy_java;

/**
 * Created by wangtao on 2017/10/23.
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {

        Singleton.getInstance();
    }
}
