自动装配时Spring满足Bean依赖的一种方式；Spring会在上下文中自动寻找，并自动给bean装配属性。
Spring中有三种装配方式：
• 在xml中显示的配置；（之前学习的手动设置注入）
• 在Java中显示的配置；
• 隐式的自动装配；
包括.xml文件中的自动装配和注解形式的自动装配
.xml文件中的自动装配
````
<!--autowire自动装配方法-->
    <!--方法一：byName会自动在容器上下文中查找和自己对象set方法后面的值对应的bean的id，
    如果id=dog改为id=dog2，则无法自动装配
    注意：byName的时候，需要保证所有的bean的id唯一，且这个bean需要自动注入的属性的set方法的值一致-->
    <bean id="people" class="IOC.pojo.People" autowire="byName">
        <property name="name" value="wq"/>
    </bean>

    <!--方法二：byType会自动在容器上下文中查找和自己对象属性类型相同的bean-->
    <!--如果有多个同类型的bean则无法装配成功，在byType方式下bean可以没有id（如果没有其他需要用到他的地方）
    注意：byType的时候，需要保证所有的bean的class唯一，并且把这个bean需要自动注入的属性类型一致-->
    <bean id="people" class="IOC.pojo.People" autowire="byType">
        <property name="name" value="wq"/>
    </bean>
````

注解形式的自动装配
````
要使用注解，需要导入context约束，并在beans.xml文件中加一些支持：
xmlns:context="http://www.springframework.org/schema/context"
http://www.springframework.org/schema/context
https://www.springframework.org/schema/context/spring-context.xsd"
和
<context:annotation-config/>

在实体类中对应类的声明语句前添加：@Autowired
注意：能够成功装配的前提，属性名和spring中的id名一致。
拓展：
用@Nullable字段标记了@Autowired注解时，说明这个字段值可以为null
 /*加了nullable之后，如果String name传入的值为空也不会报错*/
    public People(@Nullable String name) {
        this.name = name;
    }
 /*如果显示的定义了@Autowired的required = false，就说明这个对象可以为null，否则不允许为空*/
    @Autowired(required = false)
    private Cat cat;

需要注意的地方：
在名字不一致的情况下，@Autowired也能装配成功（前提是该类型对象在spring中唯一）：
    <bean id="cat1" class="com.wq.pojo.Cat"/>
    <bean id="dog1" class="com.wq.pojo.Dog"/>

在存在多个同类型对象的情况下，可以结合@Qualifier使用：
@Autowired
@Qualifier(value="dog2")
private Dog dog;
````

@Resource
````
查找顺序：找名字相同——>找类型相同——>报错 
可以指定查找的对象的名字（别名），和@Autowired结合@Qualifier使用一样
@Resource(name="cat2")
private Cat cat;
````

@Autowired与@Resource的区别
````
@Autowired默认哦通过byType的方式实现，且必须要求这个对象存在！
@Resource默认通过byName的方式实现，如果找不到名字，则通过byType方式实现。当两个都找不到则报错。
由上可知二者执行顺序不同。
````