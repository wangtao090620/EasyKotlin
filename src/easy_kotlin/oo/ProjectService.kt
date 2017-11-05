package easy_kotlin.oo

/**
 * Created by Administrator on 2017/11/4 0004.
 */
interface ProjectService {
    var name: String

    abstract fun save()
    fun print() {
        println("project service")
    }
}