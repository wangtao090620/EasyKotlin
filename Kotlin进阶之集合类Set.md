# I.集合类之Set

Kotlin中的Set也分为：不可变Set和可变的MutableSet（支持增加和删除）

不可变Set同样是继承Collection。

## Set

### 1、空集

创建空集

空集继承Serializable，它的size是0，isEmpty()返回true，hashCode()也是0

```
 val emptySet = emptySet<Any>()
```

### 2、创建Set


#### a、常用的创建Set的函数

- `setOf `:使用元素`elements`创建一个`Set`
- ` mutableSetOf()`:创建一个可变的`Set`


#### b、setOf

```
@Test
fun run01() {
    val set = setOf(1, 1, 2, 2, 3, 3, 3)
    println(set)
    
}

结果：

[1, 2, 3]
```

#### c、mutableSetOf

```
@Test
fun run02() {
    val set = mutableSetOf(1, 1, 2, 2, 3)
    set.add(4)
    println(set)
}

结果：
[1, 2, 3, 4]
```

### 3、使用java中的Set类

- hashSetOf（HashSet）
- linkedSetOf （LinkedHashSet）
- mutableSetOf （LinkedHashSet）
- sortedSetOf （TreeSet）


### 4、Set元素的加减操作plus、minus

```
@Test
fun run03() {
    val set = mutableSetOf(1, 2, 3, 4, 5, 6, 7)
    println(set+10)

}

结果：

[1, 2, 3, 4, 5, 6, 7, 10]


@Test
fun run04() {
    val set = mutableSetOf(1, 2, 3, 4, 5, 6, 7)

    println(set- listOf(1,3))

}

结果：

[2, 4, 5, 6, 7]
```

