package easy_kotlin.collections

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/2.
 */
class ListTest {

    @Test
    fun run01() {

        val list: List<Int> = listOf()


        val list1 = listOf(1, 2, 3, 4, 5, 6)

        val list2 = list1.toMutableList()

        list2.add(7)

        val arrayList = arrayListOf(1, 2, 3)

        val muList = mutableListOf(1, 2, 3)

        muList.add(4)

        muList.forEach { println(it) }

    }

    @Test
    fun run02() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        val iter = list.listIterator()

        while (iter.hasNext()) {
            println(iter.next())
        }
    }

    @Test
    fun run03() {
        val list = listOf(1, 2, 3, 4, 5, 6)

//        list.forEach { println(it)}

        list.forEach(::println)
    }

    @Test
    fun run04() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        list.forEach(::println)
    }

    @Test
    fun run05() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        val x = list.elementAtOrElse(7, { 12 })

        val y = list.elementAtOrNull(7)

        list.single()
        println(x)
        println(y)
    }

    @Test
    fun run06() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        val x = list.single { it == 2 }

        println(x)
    }

    @Test
    fun run07() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        val x = list.any { it % 2 == 0 }

        println(x)
    }

    @Test
    fun run08() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        val x = list.all { it % 2 == 0 }

        println(x)
    }

    @Test
    fun run09() {
        val list = listOf(1, 2, 3)

        val sum = list.reduce { sum, i -> sum + i }

        println(sum)

    }

    @Test
    fun run10() {
        val list = listOf("a", "b", "c")

        val x = list.reduceRight { s, acc -> acc + s }

        println(x)

    }

    @Test
    fun run11() {
        val list = listOf(1, 2, 3)

        val x = list.fold(100, { acc, i -> i + acc })

        println(x)

    }

    @Test
    fun run12() {
        val list = listOf(1, 2, 3)

        list.forEach { value ->
            if (value > 2)
                print(value)
        }

    }


    @Test
    fun run13() {
        val list = listOf(1, 2, 3, 4, 5)

        list.forEachIndexed { index, value ->
            if (value > 2)
                println("index = $index,value = $value")

        }

    }

    @Test
    fun run14() {
        val list = listOf(1, 2, 3, -4)


        val max = list.maxBy { it * it }

        println(max)

    }


}
