#多表查询
#示例1：无任何条件的多表查询，实际是笛卡尔积
select * from borrow ,reader;
#示例2：通过增加条件限制返回结果
select * from borrow ,reader 
where borrow.rid=reader.rid;
#示例3：通过内连接查询
select * from borrow inner join reader 
on borrow.rid=reader.rid;

#explain:语句分析,type
#system > const > eq_ref > ref > range > index > ALL

#示例4：通过外连接查询
select b.rid,b.bid,r.rid,r.rname 
from borrow b right join reader  r
on b.rid=r.rid;
#等同于
select b.rid,b.bid,r.rid,r.rname 
from reader r left join borrow b
on b.rid=r.rid;

#示例5：查找每本图书的借阅情况，未被借阅的图书信息也要显示
select bk.bid,bk.bname,bw.rid,bw.lenddate
from book bk left join borrow bw
on bk.bid=bw.bid;

#示例6：查询未被借阅过的图书
select bk.bid,bk.bname
from book bk left join borrow bw
on bk.bid=bw.bid
where bw.rid is null;

#示例7：查找每本图书的借阅信息，包括书编号、书名、读者名，借阅时间，归还时间
select bk.bid,bname,rname,lenddate,returndate
from book bk inner join borrow bw
on bk.bid=bw.bid inner join reader r
on bw.rid=r.rid;

#示例8：查找未归还图书的借阅信息，包括书编号、书名、读者名，借阅时间，归还时间
select bk.bid,bname,rname,lenddate,returndate
from book bk inner join borrow bw
on bk.bid=bw.bid inner join reader r
on bw.rid=r.rid
where returndate is null;

#MySQL使用联合查询左外、右外实现全外连接查询
#示例9：查找所有借阅信息，包括书编号、书名、读者编号、
#     读者名、借阅时间，归还时间，未借阅的图书、读者都要显示
select bk.bid,bname,r.rid,rname,lenddate,returndate
from book bk left join borrow bw
on bk.bid=bw.bid left join reader r
on bw.rid=r.rid
union
select bk.bid,bname,r.rid,rname,lenddate,returndate
from book bk right join borrow bw
on bk.bid=bw.bid right join reader r
on bw.rid=r.rid;

#自连接：特殊的连接，自己连自己
# 示例10：查询某市级行政区划名及其上级行政区划名
select c1.name,c2.name 
from city c1 inner join city c2
on c1.up=c2.id
where c1.id=10;
# 示例11：查询某行政区划名及其上级行政区划名,如果没有也显示
select c1.name,c2.name 
from city c1 left join city c2
on c1.up=c2.id
where c1.id=10;
# 示例12：根据身份证前6位查询三级行政区划名称
select concat(c3.name,c2.name ,c1.name)
from city c1 left join city c2
on c1.up=c2.id left join city c3
on c2.up=c3.id
where c1.idprefix='320102';

#子查询
#示例13：根据图书名查询其借阅情况
#连接实现
select bw.* from borrow bw
inner join book bk
on bw.bid=bk.bid
where bname like '%java%';
#子查询实现
select * from borrow
where bid in(
	select bid from book
	where bname like '%java%'
);
#示例14：示例5的子查询实现(仅查找有借阅记录的图书)
#select bk.bid,bk.bname,bw.rid,bw.lenddate
#rom book bk inner join borrow bw
#on bk.bid=bw.bid;
select bid,
	(select bname from book bk 
		where bk.bid=bw.bid) bname,rid,lenddate
from borrow bw;

# 示例15:示例10的子查询实现
#查询某市级行政区划名及其上级行政区划名
#select c1.name,c2.name 
#from city c1 inner join city c2
#on c1.up=c2.id
#where c1.id=902;
select c1.name,
	(select c2.name from city c2
		where c1.up=c2.id)
from city c1
where id=902;


# 示例16:使用子查询完成示例12
#根据身份证前6位查询三级行政区划名称
-- select c3.name,c2.name ,c1.name
-- from city c1 left join city c2
-- on c1.up=c2.id left join city c3
-- on c2.up=c3.id
-- where c1.idprefix='320102';
select 
	(select 
		(select c3.name from city  c3
			where c3.id=c2.up) 
		from city c2 where c1.up=c2.id
	) `一级`,
	(select c2.name from city  c2
			where c2.id=c1.up) `二级`,
	c1.name `三级`
from city c1
where c1.idprefix='320102';












