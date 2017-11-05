package easy_kotlin.oo.proxy

import org.testng.annotations.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class VetoableDemo {

    var grade: String by Delegates.vetoable("V0", {

        property, oldValue, newValue ->

        true
    })

    var noChangeGrade: String by Delegates.vetoable("V0", {

        property, oldValue, newValue ->

        false
    })

    @Test
    fun run() {
//        val ph = VetoableDemo()
//
//        ph.grade = "T1"
//
//        println(ph.grade) // T1
//        println(ph.noChangeGrade) // T0


        val ph = VetoableDemo()

        ph.noChangeGrade = "T1"

        println(ph.grade)// T0
        println(ph.noChangeGrade)// T0
    }
}