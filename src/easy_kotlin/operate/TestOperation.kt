package easy_kotlin.operate

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/2.
 */
class TestOperation {


    @Test
    fun run() {


        val x = null

        val y = x ?: 0// if(x!==null) x else 0

        println(y)

        var a = "123"

        //a = null  //Null can not be a value of a non-null type String

    }

    @Test
    fun testNull() {

        var x: String? = "abc"

        x = null

        // val b = x.length  Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?

        println(x?.length)
    }
}