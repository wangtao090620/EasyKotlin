package easy_kotlin.process

import org.testng.annotations.Test


class TestWhen {

    @Test
    fun run() {

//        switch(3)
        testFor()
    }


    fun switch(x: Int) {
        when (x) {
            1 -> print("x==1")
            2 -> print("x==2")
            else -> print("x = " + x)
        }
    }

    fun testSwitch() {

        val x = 1
        val arr = arrayOf(1, 2, 3)

        when (x) {
            -1 -> print(x)
            in 1..10 -> print("x is in the range")
            in arr -> print("x is arr")
            !in 10..20 -> print("x outside the range")
            else -> print("none")

        }

    }

    fun testFor() {

        val arr = arrayOf(1, 2, 3, 4)

        val list = arrayListOf(1, 2, 3, 4, 5)

        for (i in arr) {
            println(i)
        }


        for (i in list.indices) {
            print(list[i])
        }


        for ((index, value) in list.withIndex()) {
            println("$index....$value")
        }
    }

    @Test
    fun testWhile() {
        var x = 10

        while (x > 0) {
            x--
            println("x = $x")
        }

        var y = 10

        do {
            y--
            println("y = $y")
        } while (y > 0)
    }

    @Test
    fun testBreakContinue() {
        for (i in 1..10) {
            println("i = $i")
            if (i % 2 == 0) {
                break
            }
        }

        for (j in 1..10) {
            if (j % 2 == 0) {
                continue
            }
            println("j = $j")
        }
    }

    @Test
    fun testReturn() {
        println(sum(1, 9))
        return_01()
        return_02()
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun return_01() { //结果：1，2

        println("start return01")
        val arr = arrayOf(1, 2, 3, 4, 5)

        arr.forEach {
            if (it == 3)
                return
            println(it)
        }

        println("end return01")
    }

    fun return_02() {  //结果：1 2 4 5

        println("start return02")
        val arr = arrayOf(1, 2, 3, 4, 5)

        arr.forEach(
                fun(a: Int) {
                    if (a == 3)
                        return
                    println(a)
                }
        )

        println("end return02")
    }

    @Test
    fun testLabel() {

//        return_04()
        break_01()
    }

    fun return_03() {//结果：1，2，4，5
        println("start return03")
        val arr = arrayOf(1, 2, 3, 4, 5)

        arr.forEach test@ {
            if (it == 3)
                return@test
            println(it)
        }

        println("end return03")
    }

    fun return_04() {
        println("start return04")
        val arr = arrayOf(1, 2, 3, 4, 5)

        arr.forEach {
            if (it == 3)
                return@forEach
            println(it)
        }

        println("end return04")
    }

    fun break_01() {
        outer@ for (outer in 1..5)
            for (inner in 1..10) {

                println("inner = " + inner)
                println("outer = " + outer)

                if (inner % 2 == 0) {
                    break@outer
                }
            }

    }
}