# 基本数据类型与类型系统

# I.基本数据类型与类型系统

## 1、编译时类型和运行时类型

Kotlin是一门强类型、静态类型、支持隐式类型的显式类型语言

强类型语言在运行时会确保不会发生未经明确转换（显式调用）的类型转换。但是，强和弱知识相对的

静态类型检查是基于编译器来分析源码本身，从而确保类型安全。

显式类型语言在定义变量时显式给出变量的类型

隐式类型语可以使用类型推论来确定变量的类型

## 2、根类型（Any）

等价于Java中的Object


## 3、基本类型

### 数字类型

> Double、Float、Long、Int、Short、Byte

### 布尔类型

> Boolean

### 字符串类型

> String

`trimMargin()`、`trimIndent()`去除前导空格。`trimMargin()`默认市容`“|”`来作为边界字符，`trimIndent(`)则是把左边空白对齐切割，例子

```
@Test
fun run() {

    val text = """
                 Hello
        World!

    """

    val s = text.trimIndent()

    println(s)
}

结果：
         Hello
World!




@Test
fun run() {

    val text = """
           #我是一只小小鸟
    """

    val s = text.trimMargin("#")

    println(s)
}

结果：

我是一只小小鸟

```


字符串模板，例子：

```
 @Test
fun run01(){

    val x = 3

    val text = "x = $x"

    val y = "abcd"

    val str = "str length ${y.length}-----$y.length"

    val price = "10.9"

    val strP = "price is $$price"

    println(text)
    println(str)
    println(strP)
}

结果：

x = 3
str length 4-----abcd.length
price is $10.9
```

### 数组类型

数组在Kotlin中更实用`Array`类来表示，可以使用`arrayOf()`来创建一个数组并传递元素值给它，例如：

```
@Test
fun run02() {

    val arr = arrayOf(1, 2, "abc", true)

    arr.forEach { println(it) }
    
}

结果：

1
2
abc
```

数组Array类还提供一个构造函数：

`public inline constructor(size: Int, init: (Int) -> T)`,l例子：

```
@Test
fun run03() {
    val square = Array(10, { i -> i * i })

    square.forEach { " " + it }
}

结果：

 0 1 4 9 16 25 36 49 64 81
```

原生数组类型：

- ByteArray（byteArrayOf）
- CharArray（charArrayOf）
- ShortArray（shortArrayOf）
- IntArray（intArrayOf）
- LongArray（longArrayOf）
- FloatArray（floatArrayOf）
- DoubleArray（doubleArrayOf）
- BooleanArray （booleanArrayOf）


## 4、可空类型


例子：

```

 @Test
fun fun04() {
    
    var x: String? = "acc"

    x = null

}

```


## 5、kotlin.Unit类型

声明一个函数的返回值是Unit：

```

fun testUnit(): Unit {
        
    }

```

## 6、kotlin.Nothing类型

Kotlin中咩有Java和C中的相类似函数没有返回值的标记`void`，但是拥有一个对应`Nothing`，例如：

```
var y: Nothing? = null
        
y = null

```

Nothing?唯一允许的值是null

## 7、类型检测与类型转换

`is`和`!is`

`is`运算符类似于java中的instanceOf

区别于java，Kotlin在类型判断过后不需要进行强转，例如：

```
fun strLen(ani: Any): Int {
    if (ani is String)
        return ani.length
    else if (ani is Number)
        return ani.toString().length
    else if (ani is Char)
        return 1
    else if (ani is Boolean)
        return 1
    else return -1
}

```
