package easy_kotlin.oo.enum

/**
 * Created by Administrator on 2017/11/4 0004.
 */
enum class ActivityLifeState {

    onCreate {
        override fun singl() = onStart

    },

    onStart {
        override fun singl() = onStop


    },

    onStop {
        override fun singl() = onStart


    },

    onDestroy {
        override fun singl() = onDestroy


    };

    abstract fun singl(): ActivityLifeState


}