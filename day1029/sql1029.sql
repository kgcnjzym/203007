#修改表
#添加一列
alter table 表名 add 列名 数据类型 [约束];
#修改列类型、位置等
alter table 表名 modify 列名 数据类型 [约束]
[first|after 列名];
# 删除列
alter table 表名 drop 列名;
#修改列名（类型、位置等）
alter table 表名 change 旧列名 新列名 类型 [first|after 列名];
#修改表名
alter table 旧表名 rename 新表名;
#或者
rename table 旧表名 to 新表名;

# 查看表结构
desc 表名;
# 查看表定义
show create table 表名;
# 示例：users表
CREATE TABLE `users` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) NOT NULL,
  `password` char(32) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#DML
#添加数据（单条）
insert into 表名[(列名...)] values(值...);
#添加数据（多条）
insert into 表名[(列名...)] values(值...),(值...),(值...)...;
# 示例
insert into users 
	values(1,'mike','123456','M',22,'13012345678');
insert into users(name,phone) 
	values('tom','13012345677');
insert into users 
	values(3,'lisi','123456','F',22,'13112345678'), 
	(4,'zhangsan','123456','M',24,'13212345678'), 
	(5,'wanger','111111','F',30,'13312345678');

#查询数据
select * from 表名;
#示例
select * from users;

#修改数据
update 表名 set 列名=值 [条件语句];
#条件语句:where 列名=值

#示例1：每个用户加1岁
update users set age=age+1;
#示例2：修改tom的密码为888888
update users set password='888888'
	where name='tom';
#示例3：把年龄在20-30之间的用户年龄+1
update users set age=age+1
	where age between 20 and 30;
# 或者
update users set age=age+1
	where age >=20 and age<=30;
#示例4：把id大于3的用户年龄-1
update users set age=age-1 where id>3;
#示例5：把手机号130开头的用户密码改为'130130'，年龄-1
update users set password='130130',age=age-1
	where phone like '130%';
#或者
update users set password='888888',age=age+1
	where phone rlike '^130';
#示例6：把年龄为NULL的用户设为25岁
update users set age=25
	where age IS NULL;
#示例7：把性别不为NULL的用户年龄-1
update users set age=age-1
	where gender IS NOT NULL;


#删除数据
delete from 表名 [条件语句];
#示例1：删除users表所有数据
delete from users;
#示例2：删除users表中id为NULL的数据
delete from users where id is null;
#截断数据:更彻底，但不安全（无法撤回）
truncate  表名;

#查询操作
#去除重复记录：distinct
#示例
select distinct password,phone from users where id<3;
#in关键字示例
#select * from users where id=1 or id=5 or id=7;
select * from users where id in (1,5,7);

#聚合函数
#示例1：查找users表人数
select count(1) from users;
#示例2：查找users表的男、女人数
select gender,count(1) from users group by gender;





















