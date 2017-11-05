# I.类与构造函数

## 1、声明类

Kotlin使用`class`作为类的关键字，当我们声明一个类时，直接通过`class`加类名的方式实现

`class Animal {}`

## 2、构造函数

在Kotlin中，一个类有主体构造函数，同时还拥有一个或多个次构造函数

### a、主体构造函数

```
open class Animal constructor(var name: String) : Any() {

    init {
        println("init animal")
    }

}
```

init可以初始化一些代码

如果主体函数没有任何注解或者可见性修饰符，可以省略`constructor`，如果有不能省略，并且这些修饰符在它之前

```
annotation class MyAutowired
open class Animal public @MyAutowired constructor(var name: String) : Any() 
```

### b、次构造函数

```
class Student {

    constructor(name: String, age: Int) {
        
    }
}
```

如果一个类有一个主体构造函数，那么每个次类构造函数需要委托给主体构造函数，委托同一个类的另一个构造函数用`this`就可以

```
class SchoolStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {

    var id: Int = 100

    constructor(name: String, age: Int, id: Int) : this(name, age) {

        this.id = id

    }

    fun run(){
        println("run name = $name age = $age id = $id")
    }
}

open class Student public @MyAutowired constructor(val name: String, var age: Int) : Any() {

    init {

    }

    fun test(){
        println("test name = $name age = $age")
    }
}
```

如果一个非抽象类没有声明任何主次构造函数，它会有一个生成的不带参数的主构造函数。构造函数的可见性是`public`


### d、私有构造函数


```
class Dog private constructor() {
}
```

我们只能通过次构造函数引用这个私有主构造函数来实例化对象



### e、类的属性

```
class Dog {

    var name: String = "tom"

    var age: Int = 1
    
}
```

### f、函数

```
class Dog {

    var name: String = "tom"

    var age: Int = 1

    fun call() {
        println("小狗叫")
    }

}
```

# II.抽象类


### a、抽象类的定义 


含有抽象函数的类，称作为抽象类

```
abstract class Person {

    abstract var name: String
    abstract var age: Int

    abstract fun call()
    abstract fun play()

    fun buy() {
        
    }
}
```


### b、抽象函数


```

class Teacher(name: String, age: Int) : Person(name, age) {

    override var name: String = "tom"
    override var age: Int = 25

    override fun call() {

    }

    override fun play() {

    }

}
```

`Teacher`这个类不能重写`Person`中的 `buy`方法，如果要重写，需要加上`open`



### c、抽象属性和抽象类

```
abstract var name: String
abstract var age: Int

```


抽象类和普通类的区别：

- 抽象函数必须是`public`或者`protected`默认是`public`
- 抽象类不能用来创建实例对象
- 如果一个类集成与一个抽象类，则子类必须重写父类抽象类中的抽象方法，使用`override`关键字



# III.接口

和java一样Kotlin也是使用`interface`作为接口关键字

## 1、接口的定定义

Kotlin的接口可以包含抽象的方法以及方法的实现

```
interface ProjectService {
    var name: String

    abstract fun save()
    fun print() {
        println("project service")
    }
}
```

## 2、实现接口

接口是没有构造函数的，我们使用冒号`:`语法来实现一个接口，如果有多个，用逗号隔开

```
interface Tools {
    fun run()
}


interface Car {

    var name:String
    var price:String
}


class QQCar : Car ,Tools{
    override fun run() {
        
    }

    override var name: String = "QQ"
    override var price: String = "200"
}
```


## 3、覆盖冲突

如果`Tools`和`Car`都有`call()`方法时，如果我们直接调用`super.call()`编译器时无法知道调用哪一个的`call()`方法

```
interface Car {

    var name:String
    var price:String
    
    fun run()

    fun call(){

    }
}

interface Tools {
    fun call(){

    }
}

class QQCar : Car, Tools {

    override var name: String = "QQ"
    override var price: String = "200"

    override fun call() {
        super<Car>.call()
        super<Tools>.call()
    }

    override fun run() {
    }

}
```

## 4、接口中的属性

```
var name:String
var price:String
```

# V.继承

## 1、open类

除了抽象类，接口默认可以被继承（实现）外，我们也可以把一个类声明成`open`，这样我们就可以继承这个类

定义一个父类时：

```
open class Person {
}
```

子类继承：

```
class Student : Person() {
}
```

如果分类有构造函数，那么必须在子类的主构造函数中进行继承，没有的话则可以选择主构造函数或者二级构造函数

```
//父类
open class Person(name: String, age: Int) {
}

//子类
class Student(name: String, age: Int) : Person(name, age) {
}
```


Kotlin中提倡所有的操作都是明确的，所以需要将希望被重写的方法设置成`open`


## 2、多重继承

Kotlin只能单继承，所以可以继承抽象类，实现接口来实现多重继承

```
abstract class Animal {

    abstract fun doEat()

}


interface Run {
    fun run()
}


class Cat: Animal(),Run{

    override fun run() {

    }

    override fun doEat() {

    }

}

```


# VI.枚举类

## 1、枚举类的基本用法

```
enum class Color {
    RED, GREEN, YELLOW
}

@Test
fun run(){
    val green = Color.GREEN

    println("name =  "+green.name+" ordinal = "+green.ordinal)
}

结果：

name =  GREEN ordinal = 1
```

## 2、初始化枚举值

```

enum class Color(var rgb:Int) {
    RED(0xff0000),
    GREEN(0x00ff00),
    YELLOW(0xffff00)
}


@Test
fun run01(){
    val green = Color.GREEN

    println("green rgb = "+green.rgb)
}
```

声明自己的匿名类

```

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

```

## 3、使用枚举常量

我们使用`enumValues`,每一个枚举常量都有`name名称`和`ordinal位置`的属性


```
@Test
fun run02() {
    val rgbs = enumValues<Color>().joinToString { "${it.name}:${it.ordinal}" }

    println(rgbs)
}

```

# VII.注解类

- @Target (指定元素用于哪些元素，类、函数、属性、表达式等)
- @Retention (指定这个注解的信息是否被保存到变异后的class文件中，以及运行时是否可以通过反射访问到它)
- @Repeatable (允许在单个元素上多次使用这个注解)
- @MustBeDocumented (这个注解是公开API的一部分，在自动产生的API文档的类或函数签名中，应该包含这个注解信息)

# VIII.单利模式和伴生对象

## 1、object对象

Kotlin没有静态属性和方法，但是也提供了单例的功能，我们可以使用`object`来声明一个类


```
object User {
    var username:String = "tom"
    var password:String = "123"
}
```

反编译后的java代码：

```
public final class User {
   @NotNull
   private static String username;
   @NotNull
   private static String password;
   public static final User INSTANCE;

   @NotNull
   public final String getUsername() {
      return username;
   }

   public final void setUsername(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      username = var1;
   }

   @NotNull
   public final String getPassword() {
      return password;
   }

   public final void setPassword(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      password = var1;
   }

   private User() {
      INSTANCE = (User)this;
      username = "tom";
      password = "123";
   }

   static {
      new User();
   }
}
```

所以被object修饰的的类不能使用`User()`来创建对象

## 2、嵌套object对象



## 3、匿名object

```
@Test
fun run() {
    println(distance(3.0,4.0))

}

fun distance(x: Double, y: Double): Double {
    val porigin = object {
        val x = 0.0
        val y = 0.0
    }
    return Math.sqrt((x - porigin.x) * (x - porigin.x) + (y - porigin.y) * (y - porigin.y))
}
```
匿名对象只能作用在本地和私有作用域中声明的类，例如：

```
private fun privateFoo() = object {
    val x: String = "x"
}

fun publicFoo() = object {
    val x: String = "x"
}

@Test

fun test() {
    val x = privateFoo().x
    //val x1 = publicFoo().x  Unresolved reference: x
    
}
```

与java匿名内部类类似，object对象表达式中的代码可以访问来自包含它作用域的变量，与java不同的是，这不限于final变量：

```
fun countCompare() {
    val list = mutableListOf(1, 4, 3, 7, 11, 9, 10, 20)
    var countCompare = 0

    Collections.sort(list, object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            
            countCompare++
            
            return o1.compareTo(o2)
        }

    })
}
```

## 4、伴生对象

伴生对象`companion object`关键字声明

```
class ClassA {
    companion object {
        fun create(): ClassA = ClassA()
    }
}
```

一个类中只能有一个伴生对象

伴生对象的默认引用名是`Companion`,我们可以直接像`java静态类`中的静态方法一样使用给一个类的伴生对象的函数和属性


```
@Test
fun run01(){
    ClassA.create()
}

```

`Companion`可以省略不写，伴生对象的初始化是在相应的类被加载解析时，与Java静态初始化器的语义相匹配

伴生对象的成员看起来像其他语言中的静态成员，但是在运行时任然是真实对象的实例成员，而且还可以实现接口

```

interface BeanFactory<T> {
    fun create(): T
}

class ClassB {
    companion object :BeanFactory<ClassB> {
        override fun create(): ClassB {
            return ClassB()
        }

    }
}
```

另外如果想使用Jva中的静态成员和静态方法的话，我们可以使用如下的方法：

- @JvmField：生成与该属性相同的静态字段
- @JvmStatic：在单例对象和伴生对象中生成对象的静态方法


# IX.密封类和数据类

声明一个密封类在类名前加上`sealed`修饰符，密封类的所有子类必须与密封类在同一个文件中声明

## 1、数据类

### a、构造函数的val/var

方法一：

```
class ClassC(name:String) {
    
}
```

这个`name`变量是无法被外部访问到的

方法二：

```
class ClassD(name:String) {
    val name = name
}
```

此时这个`name`变量可以被访问到

方法三：

```
class ClassE(val name:String)
class ClassE(var name:String)
```

构造函数中带`val`、`var`修饰的悲凉，Kotlin编译器会自动为它们生成`getter`、`setter`函数

### b、领域实体类

我们写Java代码时候，会经常创建一些只保留数据的类

- POJO（Plan Ordinary Java Object/Pure Old Java Object） 具有`getter、setter`方法的那种类
- DTO（Data Transfer Object） 数据传输对象类，表示层与服务层之间的数据传输对象
- VO ViewObject、ValueObject
- PO（Persisient Object）持久对象，封装原始数据
- BO（Business Object） 业务对象
- DO（Domain Object） 领域对象

### c、数据类的概念

在Kotlin中，也有对应这样的领域实体类的概念，叫做（data class），例如：

```
data class Book(val name: String)
data class Book(var name: String)

```

这里的`val、var`必须带上，编译器会自动生成以下函数：

- equals/hashCode
- toString
- componentN函数
- copy 函数

如果我们需要复制一个对象来改变它的部分属性，而其余不变，可以用`copy`函数

```
@Test
fun run02(){
    val book = Book("java")

    val copy = book.copy(name = "android")

    println("book = $book copy book = $copy")
}
```

### d、数据类的限制

1)：主构造函数需要至少有一个参数

2)：主构造函数的所参数必须标记为`val、var`

3)：数据类不能是抽象、开放、密封或者内部的，下面的写法都是错误的

- abstract data class Book(val name: String)
- open data class Book(val name: String)
- sealed data class Book(val name: String)
- inner data class Book(val name: String)

数据类只能是`final`


### e、数据类的解构

```
@Test
fun run03(){
    val stu = Student("tom", 25)
    
    val (name,age) = stu

    println("name = $name age = $age")
    
}
```

### f、标准数据类Pair、Triple


# X.嵌套类

## 1、嵌套类

```
class Car {

    class QQCar {

        class RedQQCar {
            
        }
    }
}
```

## 2、内部类

类可以标记为`inner`以便能够访问到外部类的成员

```
class Car {

    class QQCar {
        
        val name = "QQ"

        inner class RedQQCar {

            fun print(){
                println(name)
            }
        }
    }
}
```

## 3、匿名内部类

```
class QQCar {
    class RedQQCar {
        val name = "RedQQCar"
        fun run() {
            Thread(object : Runnable {
                override fun run() {
                    println(name)
                }

            }).start()
        }
    }
}

或者

class QQCar {
    class RedQQCar {
        val name = "RedQQCar"
        fun run() {
            Thread(Runnable {
                println(name)
            }).start()
        }
    }
}
```

# XI.委托


## 1、代理模式

```

public interface JSubject {
    public void request();
}


public class JRealSubject implements JSubject {
    @Override
    public void request() {
        System.out.println("JRealSubject request");
    }
}


public class ProxySubject implements JSubject {

    JSubject mJSubject;

    public ProxySubject(JSubject JSubject) {
        mJSubject = JSubject;
    }
    
    

    public void after() {
        System.out.println("ProxySubject after");
    }

    public void before() {
        System.out.println("ProxySubject before");
    }

    @Override
    public void request() {
        
        this.before();
        
        this.mJSubject.request();
        
        this.after();
    }
}



```

## 2、类的委托

```
interface JSubject {
    fun hello()
}

class RealProject(name:String):JSubject {
    override fun hello() {

    }
}

class ProxyProject(val sb: JSubject) : JSubject by sb {

    override fun hello() {

    }
}
```

委托代理类`ProxyProject`继承接口`JSubject`，并将所有的共有的方法委托给一个指定对象`sb`

## 3、委托属性

### a、Kotlin的委托属性

```
class DelegatePropertiesDemo {
    var content: String by Content()
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        TODO("not implemented")
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        TODO("not implemented")
    }
    
}
```

` var content: String by Content()`中，`by`后面的表达式`Content()`就是委托对象。`content`属性对应的`get(`)和`set()`会委托给`Content()`的`operator fun getValue`和`operator fun setValue`

### b、懒加载属性委托

```
@Test
fun test(){
    val synchronizedLazy = lazy {

        println("lazy 3")
        println("lazy 2")
        println("lazy 1")
        "Hello"
    }

    val lazyValue :String by synchronizedLazy

    println(lazyValue)
    println(lazyValue)
}

结果：

lazy 3
lazy 2
lazy 1
Hello
Hello
```

第一次调用`get()`会执行已传递给`lazy()`的`lamda表达式`并记录结果，后续调用`get()`只是返回之前记录的结果。

默认情况下，对于lazy属性的求值是同步的

如果初始化委托多个线程可以同步执行，不需要同步锁，使用`LazyThreadSafetyMode.PUBLICATION`

```
@Test
fun test01() {
    val synchronizedLazy = lazy(LazyThreadSafetyMode.PUBLICATION, {

        println("lazy 3")
        println("lazy 2")
        println("lazy 1")
        "Hello"
    })
}
```

如果属性初始化是单线程的，那么我们使用`LazyThreadSafetyMode.NONE`模式，性能是最高的

### c、可观察属性委托

我们把属性委托给``,当属性值被重新赋值的时候，触发其中的回调函数``

```
class ObservableDemo {

    var level: String by Delegates.observable("aa",
            { property: KProperty<*>, oldValue: String, newValue: String ->

                println("oldValue = $oldValue,newValue = $newValue")
            })

}

@Test
fun test() {
    val ob = ObservableDemo()

    ob.level = "bb"

    println(ob.level)

}

结果：
oldValue = aa,newValue = bb
bb
```

### d、可否决属性委托

```
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
```

### e、非空属性委托

`var name: String by Delegates.notNull()`

name不能赋值为null

### f、属性委托给Map映射

```
class Account(val map: Map<String, Any?>) {

    val name: String by map
    val password: String by map

}

@Test

fun run() {
    val account = Account(mapOf(
            "name" to "tom",
            "password" to "123"
    ))

    println("name = ${account.name},password = ${account.password}")
}

结果：

name = tom,password = 123
```

如果是可变的map就用`MutableMap`
