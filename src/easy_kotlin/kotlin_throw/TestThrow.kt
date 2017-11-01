package easy_kotlin.kotlin_throw

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class TestThrow {

    @Test
    fun testThrow(){
        fail("hello")
    }

    fun fail(msg:String):Nothing{
        throw IllegalArgumentException(msg)
    }


    //这是一个行注释

    /*
    这是一个多行注释

     */


    /**
     *
     * /**
     *
     *  fff
     *   /**
     *     gggg
     *   */
     * */
     *
     */

}