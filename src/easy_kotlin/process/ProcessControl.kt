package easy_kotlin.process

/**
 * Created by wangtao on 2017/11/1.
 */
object ProcessControl {

    @JvmStatic
    fun main(args: Array<String>) {

        max(1,4)
        max1(1,4)
        max2(1,4)
        max3(1,4)
    }

    fun max(a: Int, b: Int): Int {
        val max = if (a > b) a else b
        println(max)
        return max
    }

    fun max1(a: Int, b: Int): Int {
        var max = a
        if (a < b)
            max = b
        println(max)
        return max
    }


    fun max2(a: Int, b: Int): Int {

        val max: Int

        if (a > b)
            max = a
        else
            max = b
        println(max)
        return max
    }

    fun max3(a: Int, b: Int): Int {
        val max = if (a > b)
            a else b
        println(max)
        return max
    }
}