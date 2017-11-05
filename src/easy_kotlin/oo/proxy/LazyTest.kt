package easy_kotlin.oo.proxy

import org.testng.annotations.Test

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class LazyTest {

    @Test
    fun test() {
        val synchronizedLazy = lazy {

            println("lazy 3")
            println("lazy 2")
            println("lazy 1")
            "Hello"
        }

        val lazyValue: String by synchronizedLazy

        println(lazyValue)
        println(lazyValue)
    }

    @Test
    fun test01() {
        val synchronizedLazy = lazy(LazyThreadSafetyMode.NONE, {

            println("lazy 3")
            println("lazy 2")
            println("lazy 1")
            "Hello"
        })

        val lazyValue: String by synchronizedLazy

        println(lazyValue)
        println(lazyValue)
    }

    @Test

    fun run() {
        val account = Account(mapOf(
                "name" to "tom",
                "password" to "123"
        ))

        println("name = ${account.name},password = ${account.password}")
    }
}