# I.泛型

<p>

编程中的泛型就是以类型T为变量的类型，即参数化类型。这样类型的变量就叫做类型参数，简单说就是将类型由原来的具体的类型“参数化”。


## 1、泛型和多态

完整的多态概念由以下三个组成部分：

特殊多态：此类下又包含函数的重载及类型转换多态

参数化多态：java里的泛型

子类型多态：通过类型继承关系获得的多态


在面向对象编程中，函数的重载、继承/方法重写、泛型、运算符重载等都体现了多态。


## 2、Java中的泛型


```
public interface Map<K, V> {

default V merge(K key, V value,BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = get (key);
        V newValue =(oldValue == null) ? value :
        remappingFunction.apply(oldValue, value);
        if (newValue == null) {
            remove(key);
        } else {
            put(key, newValue);
        }
        return newValue;
    }
}

```

### a、Java中的通配符

-  ? extends T：子类型上限限定符，指定类型参数的上限（该类型必须是T或者T的子类）
-   ? super T：超类型下界限定符，指定类型参数的下限（该类型必须是T或者T的父类型）


什么时候有extends，什么时候用super呢？

`producer-extends，consumer-super`

完美诠释PECS（Producer Extends Consumer Super）：

```

public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (srcSize > dest.size())
            throw new IndexOutOfBoundsException("Source does not fit in dest");

        if (srcSize < COPY_THRESHOLD ||
            (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            for (int i=0; i<srcSize; i++)
                dest.set(i, src.get(i));
        } else {
            ListIterator<? super T> di=dest.listIterator();
            ListIterator<? extends T> si=src.listIterator();
            for (int i=0; i<srcSize; i++) {
                di.next();
                di.set(si.next());
            }
        }
    }
```

**频繁往外读取内容的，适合用上界Extends。**

**经常往里插入的，适合用下界Super。**


## 3、Kotlin中的泛型


### a、out T 与 in T


`out T `等价于 `? extends T`

`in T` 等价于 `? super T`



### b、声明处类型


例如：

```
class GenericType {

    fun testGeneric(str: Source<String>) {
        val obj: Source<Any> = str
    }

}

interface Source<out T> {
    fun <T> nextT()
}
```

### c、类型投影

例子：

```
public class Array<T> { 
    public inline constructor(size: Int, init: (Int) -> T)  
    public operator fun get(index: Int): T 
    public operator fun set(index: Int, value: T): Unit
    public val size: Int
    public operator fun iterator(): Iterator<T>
}
```


Kotlin中的无界类型的通配符，如果类型被声明成`interface Function<in T, out U>`,我们可以有以下的`*`投影

- Function<*,String>：表示   Function<in Nothing,String>
- Function<Int,*>  表示  Function<Int,out Any?>
- Function<*,*>  表示 Function<in Nothing,out Any?>


## 4、泛型类


```
class Box<T>(t: T) {
    var value = t
}


val box = Box<Int>(3)
```

## 5、泛型函数

```
fun <T> testGeneric(t: T) :String{
        //TODO
    }
```