package easy_kotlin.oo.enum

import com.sun.org.apache.xpath.internal.SourceTree
import org.testng.annotations.Test

/**
 * Created by Administrator on 2017/11/4 0004.
 */
class TestEnum {

    @Test
    fun run() {
        val green = Color.GREEN

        println("name = " + green.name + " ordinal = " + green.ordinal)
    }

    @Test
    fun run01() {
        val green = Color.GREEN

        println("green rgb = " + green.rgb)
    }


    @Test
    fun run02() {
        val rgbs = enumValues<Color>().joinToString { "${it.name}:${it.ordinal}" }

        println(rgbs)
    }
}