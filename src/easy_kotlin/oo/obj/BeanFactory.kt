package easy_kotlin.oo.obj

/**
 * Created by Administrator on 2017/11/5 0005.
 */
interface BeanFactory<T> {
    fun create(): T
}