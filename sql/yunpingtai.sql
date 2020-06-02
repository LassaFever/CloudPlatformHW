CREATE DATABASE springbootdata;

use springbootdata;

DROP TABLE IF EXISTS `t_article`;
create table `t_article`(
    `id` int(20) not null AUTO_INCREMENT comment '文章id',
    `title` varchar(200) default null comment '文章标题',
    `content` longtext comment '内容',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_comment`;
create table `t_comment`(
    `id` int(20) not null AUTO_INCREMENT comment '评论id',
    `content` longtext comment '评论内容',
    `author` varchar(20) default null comment 'author',
    `a_id` int(20) default null comment 'article_id',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT into `t_comment` VALUES ('1', '1111', 'lassafever','1');
INSERT into `t_comment` VALUES ('2', '2222', 'rmrf','1');
INSERT into `t_comment` VALUES ('3', '不错', 'lassafever','2');
INSERT into `t_comment` VALUES ('4', '阿三发射点发', 'rmrf','2');
INSERT into `t_article` VALUES ('1', 'springboot', 'rmrf');
INSERT into `t_article` VALUES ('2', 'springcloud', 'rmrf');
