package easy_kotlin.oo.proxy

import org.testng.annotations.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class ObservableDemo {

    var level: String by Delegates.observable("aa",
            { property: KProperty<*>, oldValue: String, newValue: String ->

                println("oldValue = $oldValue,newValue = $newValue")
            })

    @Test
    fun test() {
        val ob = ObservableDemo()

        ob.level = "bb"

        println(ob.level)

    }
}