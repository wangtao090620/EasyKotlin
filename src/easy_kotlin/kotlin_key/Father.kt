package easy_kotlin.kotlin_key

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
open class Father {

    open val name = "tom"
    open val password = "123"

    fun fun1() {
        println("AAAA")
    }

}

class Son : Father {

    override var name = super.name
    override var password = "456"

    constructor(password: String) {
        this.password = password
    }

    fun login() {
        super.fun1()

        println(super.name + " " + super.password + " login " + this.name + " " + this.password)

    }
}

class TestDemo {
    @Test
    fun testKey() {
        val son = Son("789")

        son.login()
    }
}
