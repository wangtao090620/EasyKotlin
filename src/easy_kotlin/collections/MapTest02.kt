package easy_kotlin.collections

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/3.
 */
class MapTest02 {

    @Test
    fun run01() {

        val map = mapOf("tom" to 18, "jack" to 25, "mary" to 19)

        map.entries.forEach { println("key = " + it.component1() + " value = " + it.component2()) }
    }

    @Test
    fun run02() {

        val map = mapOf("tom" to 18, "jack" to 25, "mary" to 19)

        val x = map.getOrElse("tom", { 24 })
        val y = map.getOrElse("aa", { 24 })

        println(x)
        println(y)
    }

    @Test
    fun run03() {

        val map = mutableMapOf("tom" to 18, "jack" to 25, "mary" to 19)

        map.getOrPut("cc", { 2222 })

        println(map)
    }


    @Test
    fun run04() {

        val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

        val mMap = map.mapKeys { it.key * it.key }

        println(mMap)
    }


    @Test
    fun run05() {

        val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

        val fmap = map.filterKeys { it % 2 == 0 }

        println(fmap)
    }


    @Test
    fun run06() {

        val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

        val fmap = map.filterValues { it !== "c" }

        println(fmap)
    }

    @Test
    fun run07() {

        val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

        val fmap = map.filter { it.key == 1 && it.value == "a" }

        println(fmap)
    }


    @Test
    fun run08() {

        val list = listOf(Pair(1,"a"),Pair(2,"b"))

        println(list)

        val map = list.toMap(mutableMapOf())

        println(map::class.java)

    }


    @Test
    fun run09() {

        val map = mapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

        val mumap = map.toMutableMap()
        mumap[1] = "vv"

        println(mumap)

    }


}