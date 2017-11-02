package easy_kotlin.type_sys

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/2.
 */
class TestType {

    @Test
    fun run() {

        val text = """
               #我是一只小小鸟
        """

        val s = text.trimMargin("#")

        println(s)
    }


    @Test
    fun run01() {

        val x = 3

        val text = "x = $x"

        val y = "abcd"

        val str = "str length ${y.length}-----$y.length"

        val price = "10.9"

        val strP = "price is $$price"

        println(text)
        println(str)
        println(strP)
    }

    @Test
    fun run02() {

        val arr = arrayOf(1, 2, "abc", true)

        arr.forEach { println(it) }

    }

    @Test
    fun run03() {
        val square = Array(10, { i -> i * i })

        square.forEach { print(" " + it) }
    }

    fun testUnit(): Unit {

    }

    @Test
    fun fun04() {

        var x: String? = "acc"

        x = null

        var y: Nothing? = null

        y = null


    }

    @Test
    fun run05() {


    }

    fun strLen(ani: Any): Int {
        if (ani is String)
            return ani.length
        else if (ani is Number)
            return ani.toString().length
        else if (ani is Char)
            return 1
        else if (ani is Boolean)
            return 1
        else return -1
    }

}

