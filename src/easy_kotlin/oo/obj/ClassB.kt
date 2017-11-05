package easy_kotlin.oo.obj

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class ClassB {
    companion object :BeanFactory<ClassB> {
        override fun create(): ClassB {
            return ClassB()
        }

    }
}