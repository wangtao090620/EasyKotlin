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

    @Test
    fun run07() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.dropLast(2)

        println(subList)

    }


    @Test
    fun run08() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.dropLastWhile { it % 2 == 0 }

        println(subList)

    }


    @Test
    fun run09() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.slice(1..2)

        println(subList)

    }


    @Test
    fun run10() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.slice(listOf(2, 4))

        println(subList)

    }

    @Test
    fun run11() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.filterTo(mutableListOf(), { it % 2 == 0 })

        println(subList)

    }

    @Test
    fun run12() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val subList = list.filter { it % 2 == 0 }

        println(subList)

    }

    @Test
    fun run13() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val map = list.map { it + 1 }

        println(map)

    }

    @Test
    fun run14() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val map = list.mapIndexed { index, i -> index * i }

        println(map)


    }

    @Test
    fun run15() {

        val list = arrayListOf(2, 1, 6, 8, 10, null, true)

        val map = list.mapNotNull { it }

        println(map)


    }


    @Test
    fun run16() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val map = list.flatMap { it -> listOf(it + 1, it + 2, it + 3) }

        println(map)


    }

    @Test
    fun run17() {

        val list = arrayListOf(2, 1, 6, 8, 10)

        val map = list.map { it -> listOf(it + 1, it + 2, it + 3) }.flatten()

        println(map)

    }


    @Test
    fun run18() {

        val list = arrayListOf("aa", "bbb", "c", "dddd", "ee")

        val group = list.groupBy { it.length }

        println(group)

    }


    @Test
    fun run19() {

        val list = arrayListOf("aa", "abc", "bbb", "c", "dddd", "de")

        val group = list.groupingBy { it.first() }.eachCount()

        println(group)

    }

    @Test
    fun run20() {

        val list = arrayListOf("aa", "abc", "bbb", "c", "dddd", "de")

        val reList = list.reversed()

        println(reList)

    }


    @Test
    fun run21() {

        val list1 = listOf(1, 2)
        val list2 = listOf(5, 7)
        val list3 = listOf(6, 0, 10)

        val zip = list1.zip(list2).zip(list3)

        println(zip)

    }

    @Test
    fun run22() {

        val list1 = listOf(1, 2)
        val list2 = listOf("x", "y")

        val zip = list1.zip(list2, { a, b -> b + a })

        println(zip)

    }

    @Test
    fun run23() {

        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val partList = list.partition { it > 5 }


        println(partList)
    }

    @Test
    fun run24() {

        val list1 = listOf(1, 2, 3, 4, 5)
        val list2 = listOf(6, 7, 8, 9, 10)

        val pList = list1.plus(list2)


        println(pList)
    }


}