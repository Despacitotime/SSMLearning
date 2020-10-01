Bean Scopes(作用域）

Singleton（单例）：设计模式的单例模式，只有一个实例。
````
<!--因为默认的就是单例模式，所以加不加都可以-->
<bean id="user3" class="com.wq.pojo.User" p:name="wq" p:age="18" scope="singleton"/>
````

Prototype（原型）：每个新的对象都是独立的
````
<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
````

其余的request、session、application在后续使用时再补充

注解方式实现作用域@Scope
在一个类中完成，和bean中的作用域一个用法
@Scope("singleton")
