package easy_kotlin.collections

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/3.
 */
class MapTest {

    @Test
    fun run01() {

        val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

        map.entries.forEach { println("key = " + it.key + " value = " + it.value) }

    }


    @Test
    fun run02() {

        val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

        println(map.keys)

    }


    @Test
    fun run03() {

        val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

        println(map.values)

    }

    @Test
    fun run04() {

        val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

        println(map["tom"])

        map.getOrDefault("key","14")


    }
}