package easy_kotlin.collections

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/3.
 */
class SetTest {

    @Test
    fun run01() {
        val set = setOf(1, 1, 2, 2, 3, 3, 3)
        println(set)

    }


    @Test
    fun run02() {
        val set = sortedSetOf(1, 1, 2, 2, 3)
        set.add(4)
        println(set)
        println(set::class.java)

    }


    @Test
    fun run03() {
        val set = mutableSetOf(1, 2, 3, 4, 5, 6, 7)
        println(set+10)

    }

    @Test
    fun run04() {
        val set = mutableSetOf(1, 2, 3, 4, 5, 6, 7)

        println(set- listOf(1,3))

    }
}

