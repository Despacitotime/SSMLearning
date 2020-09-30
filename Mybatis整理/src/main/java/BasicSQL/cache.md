MyBatis缓存
````
MyBatis系统中默认定义了两级缓存：一级缓存和二级缓存。
• 默认情况下，只启用了本地的会话缓存（一级缓存，SqlSession级别的缓存），它仅仅对一个会话中的数据进行缓存，
当SqlSession关闭则无效。
• 二级缓存需要手动开启和配置，它是基于namespace级别的缓存。
• 为了提高扩展性，MyBatis定义了缓存接口Cache，可以通过实现Cache接口来定义二级缓存。

清除策略有：	
• LRU – 最近最少使用：移除最长时间不被使用的对象。
• FIFO – 先进先出：按对象进入缓存的顺序来移除它们。
````
一级缓存(本地缓存)
````
• 与数据库同一次会话期间查询到的数据会放在本地缓存中；
• 以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库。
````
二级缓存(全局缓存)
````
二级缓存又称全局缓存，是基于namespace级别的缓存，一个命名空间对应一个二级缓存。
工作机制：
• 一个会话查询一条数据，这个数据会被放在当前会话的一级缓存中；
• 如果当前会话关闭了，一级缓存中的数据会被保存到二级缓存中；
• 不同的mapper查处的数据会放在自己对应的缓存中。

要启用全局的二级缓存，只需要在你的 SQL 映射文件中添加一行：
<cache/>
示例：
<cache
  eviction="FIFO"
  flushInterval="60000"
  size="512"
  readOnly="true"/>
这个更高级的配置创建了一个 FIFO 缓存，每隔 60 秒刷新，最多可以存储结果对象或列表的 512 个引用，
而且返回的对象被认为是只读的，因此对它们进行修改可能会在不同线程中的调用者产生冲突。
注意：二级缓存是事务性的。这意味着，当 SqlSession 完成并提交时，或是完成并回滚，但没有执行 flushCache=true 的 insert/delete/update 语句时，缓存会获得更新。
也就是两次查询必须是第一个查询死了之后第二个查询才开始：
在编写代码时，注意session的close.
````
flushCache
````
当为select语句时：
flushCache默认bai为false，表示任何时候语句被调用，都不会去清空本地du缓存zhi和二级缓存。
useCache默认为true，表示会将本条语句的结果进行二级缓存。

当为insert、update、delete语句时：
flushCache默认为true，表示任何时候语句被调用，都会导致本地缓存和二级缓存被清空。
useCache属性在该情况下没有。

让insert\update\delete语句不刷新缓存，则将其flushCache=false
让mapper下的某一个select语句使用缓存，其余的不使用，则将其余的select语句设置为useCache=false

注意：
直接使用<cache/>（没有任何其他配置的时候），需要将实体类序列化
implements Serializable（在实体类后加这句话）
````


