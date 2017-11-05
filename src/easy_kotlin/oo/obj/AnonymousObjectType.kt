package easy_kotlin.oo.obj

import org.testng.annotations.Test
import java.util.*
import kotlin.Comparator

/**
 * Created by Administrator on 2017/11/4 0004.
 */
class AnonymousObjectType {

    private fun privateFoo() = object {
        val x: String = "x"
    }

    fun publicFoo() = object {
        val x: String = "x"
    }

    @Test

    fun test() {
        val x = privateFoo().x
        //val x1 = publicFoo().x  Unresolved reference: x

    }


    fun countCompare() {
        val list = mutableListOf(1, 4, 3, 7, 11, 9, 10, 20)
        var countCompare = 0

        Collections.sort(list, object : Comparator<Int> {
            override fun compare(o1: Int, o2: Int): Int {

                countCompare++

                return o1.compareTo(o2)
            }

        })
    }
}