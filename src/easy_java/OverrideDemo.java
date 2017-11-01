package easy_java;

/**
 * Created by wangtao on 2017/10/24.
 */
public class OverrideDemo {

    public static void main(String[] args) {

        method(null);
    }

    public static void method(Object str){
        System.out.println("method(Object str)");
    }

    public static void method(String str){
        System.out.println("method(String str)");
    }
}
