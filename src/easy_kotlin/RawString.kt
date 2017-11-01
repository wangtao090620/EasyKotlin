package easy_kotlin

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class RawString {

    @Test
    fun testRawString(){

        val x = """
        val str = "aaa"

        println(str)

        """

        println(x)
    }
}