package easy_kotlin.kotlin_key

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class Outer {

    val oh = "oh"

    inner class Inner {
        fun m() {

            val outer = this@Outer
            val inner = this@Inner

            val pthis = this

            println("outer = " + outer)
            println("inner = " + inner)
            println("pthis = " + pthis)

            println(this@Outer.oh)

            val fun1 = hell0@ fun String.() {
                val d1 = this
                println("d1 = "+d1)
            }

            val fun2 = {s:String->
                val d2 = this
                println("d2 = "+d2)
            }


            "abc".fun1()

            fun2
        }
    }

    @Test

    fun testKey(){
        val outer = Outer()

        outer.Inner().m()
    }
}