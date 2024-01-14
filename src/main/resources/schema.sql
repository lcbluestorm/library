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