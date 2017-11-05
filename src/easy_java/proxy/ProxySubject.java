package easy_java.proxy;

/**
 * Created by Administrator on 2017/11/5 0005.
 */
public class ProxySubject implements JSubject {

    JSubject mJSubject;

    public ProxySubject(JSubject JSubject) {
        mJSubject = JSubject;
    }



    public void after() {
        System.out.println("ProxySubject after");
    }

    public void before() {
        System.out.println("ProxySubject before");
    }

    @Override
    public void request() {

        this.before();

        this.mJSubject.request();

        this.after();
    }
}
