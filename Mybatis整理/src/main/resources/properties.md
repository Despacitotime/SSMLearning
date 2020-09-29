可以通过properties文件来实现引用配置文件,在mybatis-config.xml文件中：
````
<dataSource type="POOLED">
   <property name="driver" value="${driver}"/>
   <property name="url" value="${url}"/>
   <property name="username" value="${username}"/>
   <property name="password" value="${password}"/>
</dataSource>
````
在db.properties文件中：
````
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8
username=admin
password=admin
````

或者不创建db.properties文件，而直接在mybatis-config.xml文件中写properties:
````
<properties resource="org/mybatis/example/config.properties">
  <property name="username" value="dev_user"/>
  <property name="password" value="F2Fa3!33TYyg"/>
</properties>
````

配置文件里写一半，另一半在mybatis-config.xml文件中写：
````
db.properties：
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8

mybatis-config.xml：
<properties resource="db.properties">
   <property name="username" value="admin"/>
   <property name="password" value="admin"/>
</properties>
````

存在的优先级问题:
````
由于db.properties和mybatis-config.xml都可以配置用户名和密码，这就会使得存在一个冲突问题，
此时优先使用web配置文件中（db.properties）的用户名和密码，如果连接不上再使用mybatis-config.xml的。

注意：在XML中所有的标签都可以规定其顺序，所以在书写的时候一定要注意properties标签的位置是否正确。
properties应紧跟在configuration后面。
````