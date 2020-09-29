创建mybatis数据库的语句：
````
CREATE DATABASE `mybatis`;
USE `mybatis`;

CREATE TABLE `user`(
    `id` INT(20) NOT NULL PRIMARY KEY,
    `name` VARCHAR(30) DEFAULT NULL,
    `pwd` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`,`name`,`pwd`) VALUES 
(1,'1号','123456'),
(2,'2号','123456'),
(3,'3号','123456')
````