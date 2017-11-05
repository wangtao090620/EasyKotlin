package easy_kotlin.oo

/**
 * Created by Administrator on 2017/11/4 0004.
 */
class QQCar : Car, Tools {

    override var name: String = "QQ"
    override var price: String = "200"

    override fun call() {
        super<Car>.call()
        super<Tools>.call()
    }

    override fun run() {
    }

}