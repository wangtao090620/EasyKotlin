# I.集合类之List

Kotlin集合类分为：可变集合类（Mutable）与不可变集合类（Immutable）

集合类型主要分为三种：list（列表）、set（集）、map（映射）

## List

### 1、创建不可变的List

1、创建空的list

`val list: List<Int> = listOf()`

2、创建多元素的list

`val list = listOf(1, 2, 3, 4, 5, 6)`

3、创建ArrayList对象实例

`val arrayList = arrayListOf(1,2,3)`

### 2、 创建可变集合MutableList

在MutableList中，新增了add、addAll、remove、removeAll、set、clear、retainAll等更新操作的函数

1、创建可变的集合MutableList

```
val muList = mutableListOf(1,2,3)

muList.add(4)
```

2、将list转成MutableList

```
val list1 = listOf(1, 2, 3, 4, 5, 6)

val list2 = list1.toMutableList()

list2.add(7)
```

### 3、遍历List

1、Iterator遍历

```
@Test
fun run02() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    val iter = list.listIterator()

    while (iter.hasNext()){
        println(iter.next())
    }
}
```

2、forEach遍历

```
@Test
fun run03() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    list.forEach { println(it)}
}

或者

@Test
fun run04() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    
    list.forEach(::println)
}
```

### 4、List元素操作函数

add、remove、set、clear、retainAll、contains等：略

#### a、elementAt

查找下标对应的元素，如果角标越界，会抛异常

elementAtOrElse：不会抛异常，例如：

```
 @Test
fun run05() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    val x = list.elementAtOrElse(7, { 12 })

    val y = list.elementAtOrNull(7)

    println(x)
    println(y)
}


结果：

12
null
```

elementAtOrElse：查找下标对应元素，如果越界会根据方法返回默认值

elementAtOrNull：查找下标对应元素，如果越界就返回null


#### b、first

返回集合的第一个元素，如果是空集，抛出异常


#### c、single() 

该集合如果只有一个元素，则返回改元素。否则抛出异常


#### d、single(predicate: (T) -> Boolean): T

返回符合条件的单个元素，如果没有则抛出异常，例如：

```
@Test
fun run06() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    val x = list.single { it == 2 }

    println(x)
}

结果：2
```


### 5、List集合的基本运算符

#### a、any()

判断集合知道有一个元素，返回值Boolean

#### b、any(predicate: (T) -> Boolean): Boolean

判断集合中是否有满足条件的元素

#### c、all(predicate: (T) -> Boolean): Boolean

```
@Test
fun run07() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    val x = list.any { it % 2 == 0 }

    println(x)
}
```


#### d、all(predicate: (T) -> Boolean): Boolean

判断集合中的元素是否都满足条件，例如：

```
@Test
fun run08() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    val x = list.all { it % 2 == 0 }

    println(x)
}

```


#### e、none()

判断集合无元素


#### f、none(predicate: (T) -> Boolean): Boolean

判断集合中所有元素都不满足条件


#### g、count()

计算集合中元素的个数

#### h、count(predicate: (T) -> Boolean): Int

计算集合中满足条件的元素的个数

#### i、reduce

从第一项到最后一项进行累计运算


```
@Test
fun run09() {
    val list = listOf(1, 2, 3)

    val sum = list.reduce { sum, i -> sum + i }

    println(sum)

}

结果：6

```


#### j、reduceRight

从最后一项到第一项累计运算

```

@Test
fun run10() {
    val list = listOf("a", "b", "c")

    val x = list.reduceRight { s, acc -> acc + s }

    println(x)

}

结果：cba
```


#### k、fold(initial: R, operation: (acc: R, T) -> R): R

带初始值的reduce

```

@Test
fun run11() {
    val list = listOf(1, 2, 3)

    val x = list.fold(100, { acc, i -> i + acc })

    println(x)

}

结果：106
```


#### l、forEach

循环遍历

```
@Test
fun run12() {
    val list = listOf(1, 2, 3)

    list.forEach { value ->
        if (value > 2)
            print(value)
    }

}

结果：3
```

#### m、forEachIndexed(action: (index: Int, T) -> Unit): Unit

带index（下标）的元素遍历

```
@Test
fun run13() {
    val list = listOf(1, 2, 3, 4, 5)

    list.forEachIndexed { index, value ->
        if (value > 2)
            println("index = $index,value = $value")

    }

}

结果：

index = 2,value = 3
index = 3,value = 4
index = 4,value = 5
```

#### n、max、min

查询最大值、最小值，空集则返回null

#### o、maxBy(selector: (T) -> R): T?

获取函数映射结果的最大值、最小值对应的那个元素的值，如果没有怎返回null。

```
@Test
fun run14() {
    val list = listOf(1, 2, 3, -4)


    val max = list.maxBy { it * it }

    println(max)

}

结果：-4
```


### 6、过滤操作函数

#### a、take(n: Int): List<T>

挑出集合前n个元素的子集合

```
@Test
fun run01(){

    val list = arrayListOf(1, 2, 3, 4, 5)

    val subList = list.take(2)

    println(subList)
}
```


#### b、takeWhile(predicate: (T) -> Boolean): List<T>

挑出满足条件的子集合，从第一个元素开始，判断是否满足predicate为true，如果满足条件的元素就丢到返回的ArrayList中。只要遇到任何一个元素不满足条件，就结束循环。

```
@Test
fun run02() {

    val list = arrayListOf(2, 4, 6, 8, 5)

    val subList = list.takeWhile { it % 2 == 0 }

    println(subList)
}

结果：

[2, 4, 6, 8]

```


#### c、takeLast

挑出后n个元素的子集合

```
@Test
fun run03() {

    val list = arrayListOf(2, 4, 6, 8, 5)

    val subList = list.takeLast(3)

    println(subList)
}

结果：

[6, 8, 5]
```

#### d、takeLastWhile(predicate: (T) -> Boolean): List<T>

从最后开始挑出满足条件元素的子集合

```
@Test
fun run04() {

    val list = arrayListOf(2, 1, 6, 8, 10)

    val subList = list.takeLastWhile { it % 2 == 0 }

    println(subList)
}

结果：

[6, 8, 10]
```

#### e、drop

去除n个元素返回剩下的元素的子集合


```

@Test
fun run05() {

    val list = arrayListOf(2, 1, 6, 8, 10)

    val subList = list.drop(3)

    println(subList)
}

结果：

[8, 10]
```

#### f、

### 7、映射操作函数


### 8、分组操作函数


### 9、排序操作符


### 10、生产操作符


