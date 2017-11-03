# I.集合类之Map

Map是一种把键当做对象Key和值对象Value映射的集合

Kotlin的Map也分为可读的Map和可变的MutableMap

Map没有继承于Collection接口


## Map

### 1、创建Map

Kotlin中的Map区分为可读的Map和可编辑的Map（MutableMap、HashMap、LinkedHashMap）

#### a、mapOf

创建一个只读空Map

方式1：

`val map  = mapOf<String,String>()`

方式2：

`val map = emptyMap<String, String>()`


#### b、mapOf(pair: Pair<K, V>): Map<K, V>

调用的是LinkedHashMap的构造函数

```
 val map  = mapOf<String,String>("tom" to "123","jack" to "123","mary" to "123")
```

其他的创造Map都差不多，下面是其他一些方法创造Map

- mutableMapOf(): MutableMap<K, V> = LinkedHashMap()

- mutableMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V>

- hashMapOf(): HashMap<K, V> = HashMap<K, V>()

- linkedMapOf(): LinkedHashMap<K, V> = LinkedHashMap<K, V>()

- linkedMapOf(vararg pairs: Pair<K, V>): LinkedHashMap<K, V>

- sortedMapOf(vararg pairs: Pair<K, V>): SortedMap<K, V>


### 2、访问Map元素

### a、entries属性

```
@Test
fun run01() {
    
    val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")
    
    map.entries.forEach { println("key = " + it.key + " value = " + it.value) }

}

结果：

key = tom value = 123
key = jack value = 123
key = mary value = 123
```

### b、keys属性

```
@Test
fun run02() {

    val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

    println(map.keys)
}

结果：

[tom, jack, mary]
```

### c、values属性


```
@Test
fun run03() {

    val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

    println(map.values)

}
结果：

[123, 123, 123]
```

### e、size属性

获取map中键/值对的数目

### f、get(key:K)

根据key来获取value，操作符是`[]`


```
@Test
fun run04() {

    val map = mapOf("tom" to "123", "jack" to "123", "mary" to "123")

    println(map["tom"])

}

结果：

123
```

如果这个key不存在，则返回`null`


如果不想返回null，可以用`map.getOrDefault("key","14")`设置返回一个默认值

### 3、Map操作符函数


#### a、component1和component2

用来直接访问key和value

```
@Test
fun run01() {

    val map = mapOf("tom" to 18, "jack" to 25, "mary" to 19)

    map.entries.forEach { println("key = " + it.component1() + " value = " + it.component2()) }
}

结果：

key = tom value = 18
key = jack value = 25
key = mary value = 19
```

#### b、getOrElse(key: K, defaultValue: () -> V): V


通过`key`获取值，当没有值可以设置默认值

```
@Test
fun run02() {

    val map = mapOf("tom" to 18, "jack" to 25, "mary" to 19)

    val x = map.getOrElse("tom", { 24 })
    val y = map.getOrElse("aa", { 24 })

    println(x)
    println(y)
}
```

 #### c、getOrPut(key: K, defaultValue: () -> V): V

如果不存在这个key，就添加这个key到map中，对应的value是defaultValue

```
@Test
fun run03() {

    val map = mutableMapOf("tom" to 18, "jack" to 25, "mary" to 19)

    map.getOrPut("cc", { 2222 })

    println(map)
}


结果：

{tom=18, jack=25, mary=19, cc=2222}

```


#### d、iterator()

```
@Test
fun run04() {

    val map = mutableMapOf("tom" to 18, "jack" to 25, "mary" to 19)

    for((key,value) in map.iterator()){  //iterator() 可以省略
        println("key  = $key  value = $value")
    }
}

结果：

key  = tom  value = 18
key  = jack  value = 25
key  = mary  value = 19
```


#### e、mapKeys(transform: (Map.Entry<K, V>) -> R): Map<R, V> 

```
@Test
fun run04() {

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

    val mMap = map.mapKeys { it.key * it.key }

    println(mMap)
}

结果：

{1=cc, 4=b, 9=c}
```

1 的value通过转换被 -1的value覆盖了

 `mapValues`用法差不多


#### f、filterKeys(predicate: (K) -> Boolean): Map<K, V>

返回过滤出满足key判断条件的的元素组成的新的map

```
@Test
fun run05() {

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

    val fmap = map.filterKeys { it % 2 == 0 }

    println(fmap)
}

结果：

{2=b}
```


#### g、filterValues(predicate: (V) -> Boolean): Map<K, V>

返回过滤出满足value判断条件的的元素组成的新的map
```
@Test
fun run06() {

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

    val fmap = map.filterValues { it !== "c" }

    println(fmap)
}
```


#### h、filter(predicate: (Map.Entry<K, V>) -> Boolean): Map<K, V>

返回过滤出满足Entry判断条件的元素组成的心的Map

```
@Test
fun run07() {

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

    val fmap = map.filter { it.key == 1 && it.value == "a" }

    println(fmap)
}

结果：

{1=a}

```

#### i、toMap(): Map<K, V>

把持有Pait的Iterable集合转换成Map

```
@Test
fun run08() {

    val list = listOf(Pair(1,"a"),Pair(2,"b"))
    
    println(list)
    
    val map = list.toMap()

    println(map)
    
}

结果：

[(1, a), (2, b)]
{1=a, 2=b}

```


`MutableMap<in K, in V>> Iterable<Pair<K, V>>.toMap(destination: M): M`  ====>`val map = list.toMap(mutableMapOf())`

#### j、toMutableMap(): MutableMap<K, V> = LinkedHashMap(this)

把一个只读的Mao转成可以编辑MutableMap
```
@Test
fun run09() {

    val map = mapOf(1 to "a", 2 to "b", 3 to "c", -1 to "cc")

    val mumap = map.toMutableMap()
    mumap[1] = "vv"

    println(mumap)

}

结果：

{1=vv, 2=b, 3=c, -1=cc}

```


#### k、put、remove、clear略