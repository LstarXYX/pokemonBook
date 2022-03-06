drop table if exists `pets`;
create table `pets`(
                       `rec_id` int(11) not null auto_increment,
                       `name` varchar(80) not null comment '精灵名字',
                       `no` varchar(20) not null default '' comment '编号',
                       `image_url` varchar(255) default null comment '精灵图片地址',
                       `attr_one` int(5) default 0 comment '属性1',
                       `attr_two` int(5) default 0 comment '属性2',
                       primary key (`rec_id`),
                       key `IX_NAME`(`name`),
                       key `IX_ATTRIBUTE`(`attr_one`,attr_two)
)engine = innodb default charset =utf8 comment '宠物精灵表';

drop table if exists `attributes`;
create table `attributes`(
                             `rec_id` int(5) not null auto_increment,
                             `name` varchar(50) not null comment '属性名称',
                             primary key (`rec_id`)
)engine = innodb default charset =utf8 comment '属性表';

drop table if exists `wx_record`;
create table `wx_record`(
                            `rec_id` int(11) not null auto_increment primary key,
                            `unionid` varchar(255) not null comment '微信用于区分用户唯一性的id，不同平台下是一致的',
                            unique key `UX_UID`(`unionid`)
)engine =innodb default charset =utf8 comment '微信记录表';

drop table if exists `user`;
create table `user`(
                       `rec_id` int(11) not null auto_increment primary key,
                       `name` varchar(80) not null comment '用户名',
                       `pwd` varchar(20) not null comment '密码',
                       `salt` varchar(10) not null,
                       `modified` datetime not null default current_timestamp on update current_timestamp,
                       `created` datetime not null default current_timestamp,
                       key `IX_name`(`name`)
)engine =innodb default charset =utf8 comment '用户表 主要后端用';