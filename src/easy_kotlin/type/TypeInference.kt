package easy_kotlin.type

import org.testng.annotations.Test
import java.util.*

/**
 * Created by wangtao on 2017/11/1.
 */
class TypeInference {

    @Test
    fun typeInference() {
        val str = "abc"
        println(str is String)

        val d = Date()
        println(d is Date)

        val b = true
        println(b is Boolean)

        val arr = arrayOf(1, 2, 3)
        println(arr is Array)
    }

    fun getLength(obj: Any): Int {

        var result = 0
        if (obj is String) {
            result = obj.length
            println(result)
        }

        println(obj::class.java)

        return result
    }

    @Test
    fun testGetLength() {

        getLength("123")

        val obj = Any()

        getLength(obj)
    }
}