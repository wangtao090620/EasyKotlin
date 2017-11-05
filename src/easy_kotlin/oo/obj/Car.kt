package easy_kotlin.oo.obj

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class Car {

    class QQCar {
        class RedQQCar {
            val name = "RedQQCar"
            fun run() {
                Thread(Runnable {
                    println(name + " " + Thread.currentThread().name)
                }).start()
            }
        }
    }
}