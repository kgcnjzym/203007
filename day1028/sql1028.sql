#查看数据库
show databases [like '...']; 

#创建数据库
create database [if not exists] 数据库名 [charset utf8mb4];

#删除数据库
drop database [if exists] 数据库名;

#修改数据库
alter database 数据库名 charset utf8mb4;

#查看数据库定义
show create database 数据库名;

#选用数据库
use 数据库名;

#查看数据库中的所有表
show tables;

#创建表
create table [if not exists] 表名(
	列名 数据类型 [约束],
	列名 数据类型 [约束],
	......
	列名 数据类型 [约束]
);

#删除表
drop table [if exists] 表名;

#修改表
#添加一列
alter table 表名 add 列名 数据类型 [约束];
