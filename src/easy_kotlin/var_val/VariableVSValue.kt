package easy_kotlin.var_val

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class VariableVSValue {

    @Test
    fun run() {

        declareVar()
        declareVal()
    }

    fun declareVar() {
        var a = 1

        a = 2

        println(a::class)
        println(a::class.java)
        println(a)


        var x = 1

        x += 1

        println(x)
    }

    fun declareVal() {
        val a = 1

        //a = 2  Val cannot be reassigned

        println(a)
        println(a::class)
        println(a::class.java)

        val x = 2

        val c: Int
        c = 3

        val d: Int = 4

        println("x = $x, c = $c, d = $d")
    }
}
