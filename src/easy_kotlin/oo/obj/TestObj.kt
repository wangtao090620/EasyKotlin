package easy_kotlin.oo.obj

import org.testng.annotations.Test
import java.awt.DisplayMode
import java.net.CookieHandler

/**
 * Created by Administrator on 2017/11/4 0004.
 */
class TestObj {

    @Test
    fun run() {
        println(distance(3.0,4.0))

    }

    fun distance(x: Double, y: Double): Double {
        val porigin = object {
            val x = 0.0
            val y = 0.0
        }
        return Math.sqrt((x - porigin.x) * (x - porigin.x) + (y - porigin.y) * (y - porigin.y))
    }

    @Test
    fun run01(){
        ClassA.create()
    }

    @Test
    fun run02(){
        val book = Book("java")

        val copy = book.copy(name = "android")

        println("book = $book copy book = $copy")
    }

    @Test
    fun run03(){
        val stu = Student("tom", 25)

        val (name,age) = stu

        println("name = $name age = $age")

    }

    @Test
    fun run04(){
        Car.QQCar.RedQQCar().run()
        Thread.sleep(200)

        println(Thread.currentThread().name)

    }
}