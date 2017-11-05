package easy_kotlin.oo.proxy

import javax.security.auth.Subject

/**
 * Created by Administrator on 2017/11/5 0005.
 */
class ProxyProject(val sb: JSubject) : JSubject by sb {

    override fun hello() {

    }
}