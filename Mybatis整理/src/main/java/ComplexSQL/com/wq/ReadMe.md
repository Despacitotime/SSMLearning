在程序中，对于多对一的情况，用关联来表示；对于一对多的情况，用集合来表示。

环境准备：
````
//创建教师表
CREATE TABLE `teacher`
(
   `id` INT(10) NOT NULL PRIMARY KEY,
   `name` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO teacher(`id`,`name`)VALUES(1,'青老师');

//创建学生表
CREATE TABLE `student`(
   `id` INT(10) NOT NULL PRIMARY KEY,
   `name` VARCHAR(30) DEFAULT NULL,
   `tid` INT(10) DEFAULT NULL,
   KEY `fktid` (`tid`),
   CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `student` (`id`,`name`,`tid`) VALUES (1,'小明',1),
(2,'小红',1),
(3,'小张',1),
(4,'小李',1),
(5,'小土',1)
````

一对多：老师1，学生多；——（老师类）
多对一：学生多，老师1；——（学生类）