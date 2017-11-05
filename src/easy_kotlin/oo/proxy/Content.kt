package easy_kotlin.oo.proxy

import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        TODO("not implemented")
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        TODO("not implemented")
    }

}