# Kotlin之语言基础

## I.语言基础

### 1、包

包的定义：

```
package easy_kotlin

import org.testng.annotations.Test

```

### 2、声明变量和值

Kotlin的变量分为`var（可变的）`和`val（不可变的）`

例子：

```
package easy_kotlin.var_val

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class VariableVSValue {

    @Test
    fun run() {

        declareVar()
        declareVal()
    }

    fun declareVar() {
        var a = 1

        a = 2

        println(a::class)
        println(a::class.java)
        println(a)


        var x = 1

        x += 1

        println(x)
    }

    fun declareVal() {
        val a = 1

        //a = 2  Val cannot be reassigned

        println(a)
        println(a::class)
        println(a::class.java)

        val x = 2

        val c: Int
        c = 3

        val d: Int = 4

        println("x = $x, c = $c, d = $d")
    }
}

```

### 3、变量类型推断

例子：

```
package easy_kotlin.type

import org.testng.annotations.Test
import java.util.*

/**
 * Created by wangtao on 2017/11/1.
 */
class TypeInference {

    @Test
    fun typeInference() {
        val str = "abc"
        println(str is String)

        val d = Date()
        println(d is Date)

        val b = true
        println(b is Boolean)

        val arr = arrayOf(1, 2, 3)
        println(arr is Array)
    }

    fun getLength(obj: Any): Int {

        var result = 0
        if (obj is String) {
            result = obj.length
            println(result)
        }

        println(obj::class.java)

        return result
    }

    @Test
    fun testGetLength() {

        getLength("123")

        val obj = Any()

        getLength(obj)
    }
}

```


### 4、字符串与模板表达式

原始字符串用`'''需要的原始内容'''`分割，例如:

```
package easy_kotlin

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class RawString {

    @Test
    fun testRawString(){

        val x = """
        val str = "aaa"
        
        println(str)

        """

        println(x)
    }
}
```

### 5、流程控制语句

#### 5.1 if表达式

例子：

```
package easy_kotlin.process

/**
 * Created by wangtao on 2017/11/1.
 */
object ProcessControl {

    @JvmStatic
    fun main(args: Array<String>) {

        max(1,4)
        max1(1,4)
        max2(1,4)
        max3(1,4)
    }

    fun max(a: Int, b: Int): Int {
        val max = if (a > b) a else b
        println(max)
        return max
    }

    fun max1(a: Int, b: Int): Int {
        var max = a
        if (a < b)
            max = b
        println(max)
        return max
    }


    fun max2(a: Int, b: Int): Int {

        val max: Int

        if (a > b)
            max = a
        else
            max = b
        println(max)
        return max
    }

    fun max3(a: Int, b: Int): Int {
        val max = if (a > b)
            a else b
        println(max)
        return max
    }
}
```

#### 5.2 when表达式

例子：

```
fun testSwitch() {

    val x = 1
    val arr = arrayOf(1, 2, 3)

    when (x) {
        -1 -> print(x)
        in 1..10 -> print("x is in the range")
        in arr -> print("x is arr")
        !in 10..20 -> print("x outside the range")
        else -> print("none")

    }

}
```

#### 5.3 for循环

例子：

```
fun testFor() {
        
    val arr = arrayOf(1, 2, 3, 4)

    val list = arrayListOf(1, 2, 3, 4, 5)

    for (i in arr) {
        println(i)
    }


    for(i in list.indices){
        print(list[i])
    }


    for ((index, value) in list.withIndex()) {
        println("$index....$value")
    }
}
```

#### 5.4 while循环

例子：

```

@Test
fun testWhile() {
    var x = 10

    while (x > 0) {
        x--
        println("x = $x")
    }

    var y = 10

    do {
        y--
        println("y = $y")
    } while (y > 0)
}

```


#### 5.5 break和continue

break：结束循环

continue：结束本次循环，继续下次循环

```
@Test
fun testBreakContinue() {
    for (i in 1..10) {
        println("i = $i")
        if (i % 2 == 0) {
            break
        }
    }

    for (j in 1..10) {
        if (j % 2 == 0) {
            continue
        }
        println("j = $j")
    }
}
```

#### 5.6 return

Kotlin中`return`语句会从最近的函数或匿名函数中返回，但是在`Lambda表达式`中遇到`return`，则直接返回最近的外层函数。

例子：

```
@Test
fun testReturn() {
    println(sum(1,9))
    return_01()
    return_02()
}
fun sum(a:Int,b:Int):Int{
    return a+b
}

fun return_01() { //结果：1，2

    println("start return01")
    val arr = arrayOf(1, 2, 3, 4, 5)

    arr.forEach {
        if (it == 3)
            return
        println(it)
    }

    println("end return01")
}

fun return_02() {  //结果：1 2 4 5

    println("start return02")
    val arr = arrayOf(1, 2, 3, 4, 5)

    arr.forEach(
            fun(a: Int) {
                if (a == 3)
                    return
                println(a)
            }
    )

    println("end return02")
}
```

#### 5.7  标签

在Kotlin中任何表达式都可以用标签（label）来标记。标签的格式为`标识符后跟@符号`，例如：`abc@`、`love@`都是有效的标签。我们可以用label标签来控制`return`、`break`或`continue`的跳转行为。

例子（return）：

```
 @Test
fun testLabel() {

    return_03()
}

fun return_03() {//结果：1，2，4，5
    println("start return03")
    val arr = arrayOf(1, 2, 3, 4, 5)

    arr.forEach test@{
        if (it == 3)
            return@test
        println(it)
    }

    println("end return03")
}

//直接跳出forEach

fun return_04() {//结果：1，2，4，5
    println("start return04")
    val arr = arrayOf(1, 2, 3, 4, 5)

    arr.forEach {
        if (it == 3)
            return@forEach
        println(it)
    }

    println("end return04")
}

```

例子（break）：

```
fun break_01() {
    outer@ for (outer in 1..5)
        for (inner in 1..10) {

            println("inner = " + inner)
            println("outer = " + outer)

            if (inner % 2 == 0) {
                break@outer
            }
        }

}

结果：

inner = 1
outer = 1
inner = 2
outer = 1
```

#### 5.8  throw表达式

例子：

```

package easy_kotlin.kotlin_throw

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class TestThrow {
    
    @Test
    fun testThrow(){
        fail("hello")
    }

    fun fail(msg:String):Nothing{
        throw IllegalArgumentException(msg)
    }



}


结果：

java.lang.IllegalArgumentException: hello
	at easy_kotlin.kotlin_throw.TestThrow.fail(TestThrow.kt:16)
	at easy_kotlin.kotlin_throw.TestThrow.testThrow(TestThrow.kt:12)
	...


```

### 6、代码注释


例子：


```

 //这是一个行注释
    
    /*
    这是一个多行注释
    
     */


和Java不同的是Kotlin可以这样注释：

    /**
     * 
     * /**
     * 
     *  fff
     *   /**
     *     gggg
     *   */
     * */
     * 
     */

```

### 7、语法与标识符

#### 7.1、修饰符

kotlin/grammar/src/modifiers.grm 文件中,地址：https://github.com/JetBrains/kotlin/blob/master/grammar/src/modifiers.grm，描述了Kotlin语言的修饰符

```
/**
## Modifiers
*/

modifiers
  : (modifier | annotations)*
  ;

typeModifiers
  : (suspendModifier | annotations)*
  ;

modifier
  : classModifier
  : accessModifier
  : varianceAnnotation
  : memberModifier
  : parameterModifier
  : typeParameterModifier
  : functionModifier
  : propertyModifier
  ;

classModifier 类修饰符
  : "abstract" 抽象类
  : "final" 不可被继承final类
  : "enum" 枚举类
  : "open" 可继承的open类
  : "annotation" 注解类
  : "sealed" 密封类
  : "data" 数据类
  ;

memberModifier
  : "override" 重写函数
  : "open" 可被重写
  : "final" 不可被重写
  : "abstract" 抽象函数
  : "lateinit" 后期初始化
  ;

accessModifier 访问权限控制，默认是public
  : "private"
  : "protected"
  : "public"
  : "internal"
  ;

varianceAnnotation 泛型可变性
  : "in"
  : "out"
  ;

parameterModifier
  : "noinline"
  : "crossinline"
  : "vararg" 变长参数
  ;

typeParameterModifier
  : "reified"
  ;

functionModifier
  : "tailrec" 尾递归
  : "operator"
  : "infix"
  : "inline"
  : "external"
  : suspendModifier
  ;

propertyModifier
  : "const"
  ;

suspendModifier
  : "suspend"
  ;

```


#### 7.2、关键字

地址：https://github.com/JetBrains/kotlin/blob/master/compiler/frontend/src/org/jetbrains/kotlin/lexer/KtTokens.java

主要就是：`this`、`super`

例子（this关键字）：

```
package easy_kotlin.kotlin_key

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
class Outer {

    val oh = "oh"

    inner class Inner {
        fun m() {

            val outer = this@Outer
            val inner = this@Inner

            val pthis = this

            println("outer = " + outer)
            println("inner = " + inner)
            println("pthis = " + pthis)

            println(this@Outer.oh)

            val fun1 = hell0@ fun String.() {
                val d1 = this
                println("d1 = "+d1)
            }

            val fun2 = {s:String->
                val d2 = this
                println("d2 = "+d2)
            }


            "abc".fun1()

            fun2
        }
    }

    @Test

    fun testKey(){
        val outer = Outer()

        outer.Inner().m()
    }
}



结果：

outer = easy_kotlin.kotlin_key.Outer@48cf768c
inner = easy_kotlin.kotlin_key.Outer$Inner@59f95c5d
pthis = easy_kotlin.kotlin_key.Outer$Inner@59f95c5d
oh
d1 = abc
```

例子（super关键字）：

```

package easy_kotlin.kotlin_key

import org.testng.annotations.Test

/**
 * Created by wangtao on 2017/11/1.
 */
open class Father {

    open val name = "tom"
    open val password = "123"

    fun fun1() {
        println("AAAA")
    }

}

class Son : Father {

    override var name = super.name
    override var password = "456"

    constructor(password: String) {
        this.password = password
    }

    fun login() {
        super.fun1()

        println(super.name + " " + super.password + " login " + this.name + " " + this.password)

    }
}

class TestDemo {
    @Test
    fun testKey() {
        val son = Son("789")

        son.login()
    }
}


结果：

AAAA
tom 123 login tom 789

```



### 8、扩展函数和扩展属性

### 9、空指针安全