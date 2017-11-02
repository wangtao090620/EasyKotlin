package easy_kotlin.collections

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/2.
 */
class ListTest02 {

    @Test
    fun run01() {

        val list = arrayListOf(1, 2, 3, 4, 5)

        val subList = list.take(2)

        println(subList)
    }

    @Test
    fun run02() {

        val list = arrayListOf(2, 4, 6, 8, 5)

        val subList = list.takeWhile { it % 2 == 0 }

        println(subList)
    }


    @Test
    fun run03() {

        val list = arrayListOf(2, 4, 6, 8, 5)

        val subList = list.takeLast(3)

        println(subList)
    }


    @Test
    fun run04() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.takeLastWhile { it % 2 == 0 }

        println(subList)
    }


    @Test
    fun run05() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.drop(3)

        println(subList)
    }


    @Test
    fun run06() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.dropWhile { it % 2 == 0 }

        println(subList)
    }




}