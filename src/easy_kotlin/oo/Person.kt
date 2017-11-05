package easy_kotlin.oo

/**
 * Created by Administrator on 2017/11/4 0004.
 */
abstract class Person constructor(name:String,age:Int) {

    abstract var name: String
    abstract var age: Int

    abstract fun call()
    abstract fun play()

    fun buy() {

    }
}