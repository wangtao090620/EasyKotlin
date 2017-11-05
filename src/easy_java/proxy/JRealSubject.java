package easy_java.proxy;

/**
 * Created by Administrator on 2017/11/5 0005.
 */
public class JRealSubject implements JSubject {
    @Override
    public void request() {
        System.out.println("JRealSubject request");
    }
}
