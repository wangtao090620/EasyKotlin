package easy_kotlin.oo

/**
 * Created by Administrator on 2017/11/4 0004.
 */
class SchoolStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {

    var id: Int = 100

    constructor(name: String, age: Int, id: Int) : this(name, age) {

        this.id = id

    }

    fun run(){
        println("run name = $name age = $age id = $id")
    }
}

open class Student public @MyAutowired constructor(val name: String, var age: Int) : Any() {

    init {

    }

    fun test(){
        println("test name = $name age = $age")
    }
}