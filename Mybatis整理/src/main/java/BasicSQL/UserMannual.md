当环境配置好后，主要操作为（以UserMapper为例）：
````
1.在UserMapper中书写接口方法（抽象）；
2.在UserMapper.xml中写对应的SQL语句。
3.在test中新建文件进行测试。
````

注意点：
````
1.Dao文件和.xml文件尽量文件名相同，因为大部分情况下，两个
文件不会在同一个文件夹下，文件名一致方便环境自动对应。
````