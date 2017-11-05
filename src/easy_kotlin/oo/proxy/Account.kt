package easy_kotlin.oo.proxy

import org.testng.annotations.Test

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class Account(val map: Map<String, Any?>) {

    val name: String by map
    val password: String by map

}