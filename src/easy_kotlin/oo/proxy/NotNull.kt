package easy_kotlin.oo.proxy

import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class NotNull {

    var name: String by Delegates.notNull()
}