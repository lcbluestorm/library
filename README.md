# 简介
本项目是一个基于Spring boot + Mybatis的图书管理系统后端，数据库采用mysql。  
主要功能包括 用户登录和图书管理（增删查改以及分页查询），虽然功能简单， 
但是它包含一个完整项目所需要的各个模块，是一套完整的web应用框架； 比如用户登录、
代码分层、统一权限控制、统一异常处理、统一数据返回响应、数据库、swagger、restful规范接口等。


# 快速开始
1. 下载代码到本地    
`git clone https://github.com/lcbluestorm/library.git`
2. 数据库/表准备  
首先需要安装mysql数据库，连接数据库，然后执行项目中schema.sql文件中sql:  
```
create database library;

CREATE TABLE `user` (
`id` bigint(20) AUTO_INCREMENT primary key,
`nickname` varchar(50) NOT NULL COMMENT '登录用户名',
`password` varchar(32) NOT NULL COMMENT '密码',
`token` varchar(32) NOT NULL COMMENT 'token',
`status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-正常 1-已注销',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
unique(nickname),
unique(token)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into user(id, nickname, password, token) values(1, 'admin', 'admin', 'asfdasfda2312313lsfcsaaaiqpaf');

CREATE TABLE `book`(
`id` bigint(20) AUTO_INCREMENT primary key,
`ISBN` varchar(32) NOT NULL COMMENT 'ISBN号',
`name` varchar(32) NOT NULL COMMENT '书名',
`author` varchar(32) NOT NULL COMMENT '作者',
`category` varchar(32) NOT NULL COMMENT '类别',
`status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-在馆 1-出借',
`publish_time` datetime NOT NULL,
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
unique ISBN_unique(ISBN),
index name_index(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

3. 修改application.properties配置文件
* 将数据库url中的host改为自己的数据库ip  
>spring.datasource.url=jdbc:mysql://host:3306/library?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8&autoReconnect=true &allowMultiQueries=true
* 将数据库的user改为自己数据库的user  
>spring.datasource.username=xxx
* 将数据库用户密码改为自己数据库的密码  
>spring.datasource.password=xxx

4. 编译打包  
执行打包命令：`mvn clean package -D maven.test.skip=true`    
然后的target目录下会产生 ***library-0.0.1-SNAPSHOT.jar*** 包。  
5. 运行程序  
执行命令：`java -jar  library-0.0.1-SNAPSHOT.jar`  
这样程序就运行起来了，接口就可以正常访问了。
6. swagger查看API文档  
   这样就可以打开 [swagger界面](http://localhost:6800/swagger-ui/index.html)查看api文档了。


# API
## user接口
* 登录接口(/api/v1/user/login POST)

## book接口
* 查询book列表(/api/v1/books GET)
* 新建book(/api/v1/books POST)
* 查询某个book(/api/v1/books/{bookId} GET)
* 更新book(/api/v1/books/{bookId} PUT)
* 删除book(/api/v1/books/{bookId} DELETE)

更多api详情，可以查看 [swagger界面](http://localhost:6800/swagger-ui/index.html)

