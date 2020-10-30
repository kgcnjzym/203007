#聚合函数
#示例1：查找users表人数
select count(1) from users;
#示例2：查找users表的男、女人数
select gender,count(1) from users group by gender;
#示例3：查找users表平均年龄大于25岁的性别和人数
select gender,avg(age) as avgage from users 
group by gender
having avgage>25;

#排序：order by
#示例1：按照年龄排序（默认升序）
select * from users order by age;
#示例2：按照phone降序排列，如果相同则按照年龄升序排序
select * from users order by phone desc,age;

#限制结果数量limit：mysql特有
# limit n		前n条记录
# limit n,m		从n开始取m条记录
#示例1：查询年龄最大的人
select * from users order by age desc limit 1;
#示例2：查询年龄次大的2个人
select * from users order by age desc limit 1,2;
#分页：页号pageNo，页大小pageSize
# n=(pageNo-1)*pageSize
# m=pageSize


# 约束
# 非空、唯一
alter table users modify phone char(11) not null unique;
# 主键
# 已有表添加主键
alter table users add constraint primary key(id);
# 新建表添加主键
create table demo (
	id int primary key,
	name varchar(10),
	...
);
create table demo (
	id int ,
	name varchar(10),
	...,
	primary key (id)
);
# 组合键（由2个或以上字段组成的主键），只能使用表级约束
create table demo2 (
	id1 int ,
	id2 int ,
	name varchar(10),
	...,
	primary key (id1,id2)
);

#外键约束：MySQL只能写在表级上
#创建表时：
create table `order`( 
	oid int primary key, 
	uid int ,
	orderdate datetime, 
	foreign key (uid) references users(id)
);
#修改表时：
alter table 表名 
	add constraint 外键约束名 
	foreign key(外键字段) references 引用参照表(引用参照字段);

alter table `order` 
	add constraint FK_order_uid 
	foreign key(uid) references users(id);

#检查约束（MySQL不生效）
alter table users 
modify gender char check gender in('M','F');

#自增
create table demo4( 
	id int primary key auto_increment,
	 name varchar(10) )
[auto_increment=10000];
















