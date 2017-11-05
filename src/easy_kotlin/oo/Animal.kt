package easy_kotlin.oo

/**
 * Created by Administrator on 2017/11/4 0004.
 */
open class Animal public @MyAutowired constructor(var name: String) : Any() {

    init {
        println("init animal")
    }

}