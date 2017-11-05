package easy_kotlin.oo

import org.testng.annotations.Test

/**
 * Created by Administrator on 2017/11/4 0004.
 */
class OO {

    @Test
    fun run01() {

        val schoolStudent = SchoolStudent("tom", 123,200)
        schoolStudent.test()
        schoolStudent.run()
    }

}
