#查询每个课程及其授课老师的名字
SELECT
	c. NAME,
	t. NAME
FROM
	course c
INNER JOIN teacher t ON c.tecid = t.tecid;

#查询每个老师所教课程的数量，
#并按照降序显示教师姓名和教课数量（没有授课的显示0）
SELECT
	t. NAME,
	count(c.tecid)
FROM
	course c
RIGHT JOIN teacher t ON c.tecid = t.tecid
GROUP BY
	t.tecid;

#查询每个学生所参加的每门课程的考试成绩，
#显示学号、学生姓名、课程名、成绩
SELECT
	s.stuid,
	s. NAME,
	c. NAME,
	score
FROM
	student s
INNER JOIN score sc ON s.stuid = sc.stuid
INNER JOIN course c ON sc.corid = c.corid;

#查询学习了“Will”老师所教课程的学生信息
SELECT
	*
FROM
	student
WHERE
	stuid IN (
		SELECT
			stuid
		FROM
			score
		WHERE
			corid IN (
				SELECT
					corid
				FROM
					course
				WHERE
					tecid IN (
						SELECT
							tecid
						FROM
							teacher
						WHERE
							NAME = 'will'
					)
			)
	) 
#查询学习了“Will”老师所教所有课程的学生信息
select * from student 
where stuid in(
	select stuid
	from score
	where corid in (
		select corid
		from course 
		where tecid =(
			select tecid from teacher
			where name='will'
		)
	)
	group by stuid
	having count(1)=(
		select count(1)
		from course 
		where tecid =(
			select tecid from teacher
			where name='will'
		)
	)
);

#查询没有学习“Zhang”老师所教课程的学生信息
select * from student
where stuid not in(
select stuid from score
where corid  in(
select corid
	from course 
	where tecid =(
		select tecid from teacher
		where name='zhang')
		)
);


#查询所有学生的总分，并按总分降序排列，显示学生姓名和总分
select (
	select name from student s
	where s.stuid=sc.stuid
),sum(score) summary
from score sc
group by sc.stuid
order by summary desc;

#查询排名前三的学生的均分，
#并按降序排列，显示学生姓名和均分
select (
	select name from student s
	where s.stuid=sc.stuid
),avg(score) average
from score sc
group by sc.stuid
order by average desc
limit 3;

#查询每门课程的选修人数，
#按人数降序排列，显示课程名称和人数
select c.name, count(1) cnt
from course c inner join score sc
on c.corid=sc.corid
group by c.corid
order by cnt desc;


#查询每个老师所教所有课程的选修人数，按人数降序排列，
#显示教师姓名和人数（需去掉同一个学生选修
#一个老师的2门或以上课程；没有授课的显示0）
select t.tecid,count( distinct stuid)
from course c inner join score sc
on c.corid=sc.corid right join teacher t
on t.tecid=c.tecid
group by t.tecid;

#使用子查询获得当前没有被读者借阅的图书信息。
#要求：输出图书名称、图书编号、作者姓名、出版社和单价
select bname,bid,author,pubcomp,price from book
where bid not in (
	select bid from borrow
);

#使用子查询获得今年的所有缴纳罚款的读者清单，
#要求输出的数据包括读者姓名、图书名称、
#罚款日期和缴纳罚金等
select r.rname,b.bname,pdate,amount
from penalty p inner join reader r
on p.rid=r.rid inner join book b
on p.bid=b.bid
where year(pdate)=year(now());

#使用子查询获得地址为空的所有读者尚未归还的图书清单。
#要求：按读者编号从高到低、借书日期由近至远的顺序输出读者编号、读者姓名、图书名称、借书日期和应归还日期
select rid,(
	select rname from reader r 
	where r.rid=bw.rid
),(
	select bname from book b
	where b.bid=bw.bid
),lenddate,willdate
from borrow bw
where returndate is null
and rid in (
	select rid from reader 
	where raddress is null
)
order by rid desc,lenddate desc;

#使用连接实现上述要求
select r.rid,rname,bname,lenddate,willdate
from borrow bw inner join reader r
on bw.rid=r.rid inner join book b
on bw.bid=b.bid
where raddress is null and returndate is null
order by bw.rid desc,lenddate desc;


select rid,rname
from reader
where rid not in (
	select rid from borrow
);

select rid,rname
from reader r
where not exists  (
	select 1 from borrow b
	where b.rid=r.rid
);

select  (
	select rname from reader r 
	where r.rid=bw.rid
),(
	select bname from book b
	where b.bid=bw.bid
),willdate
from borrow bw
where willdate<now() 
	and returndate is null;



#查询各种图书未借出的本数，
#显示查询书名和本数。
#要求：使用 SELECT子查询、FROM 子查询
select bname,bcount-(
	select count(1) from borrow bw
	where bw.bid=bk.bid
		and returndate is null
)
from book bk;



#从已完成借阅的记录（即图书归还日期不为空）中，
#统计每位读者的借书次数，显示读者姓名和借书次数
select r.rname ,count(1)
from reader r inner join borrow b
on r.rid=b.rid
where returndate is not null
group by r.rid;


#查询总罚款金额大于 5 元的读者姓名和总罚款金额
select (
	select rname from reader r 
	where r.rid=p.rid
),sum(amount) summary 
from penalty p
group by rid
having summary>5;


#统计已完成借阅的记录（即图书归还日期不为空）
#中每本书的借阅次数，
#显示借阅次数排名在前 5 位的图书名称和借阅次数
select bid,(
	select bname from book b
	where b.bid=bw.bid
),count(1) cnt
from borrow bw
where returndate is not null
group by bid
order by cnt desc
limit 5;