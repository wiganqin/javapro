drop database if exists mldn;
create database mldn;
use mldn;
drop table if exists emp;
create table emp(
    empno    int(4)    primary key,
    ename    varchar(10),
    job    varchar(9),
    hiredate    date,
    sal    float(7,2)
);
insert into emp(empno,ename,job,hiredate,sal)values(6060,'李兴华','经理','2001-09-16',2000.3);
insert into emp(empno,ename,job,hiredate,sal)values(7369,'董明男','销售','2003-09-16',2200.3);
insert into emp(empno,ename,job,hiredate,sal)values(7698,'张惠妹','歌手','2005-09-03',2300.3);
insert into emp(empno,ename,job,hiredate,sal)values(7762,'周杰伦','销售','2005-09-16',2400.3);
insert into emp(empno,ename,job,hiredate,sal)values(7782,'马化腾','分析员','2006-02-16',2500.3);
insert into emp(empno,ename,job,hiredate,sal)values(7839,'马云','经理','2003-09-16',2600.3);
insert into emp(empno,ename,job,hiredate,sal)values(8964,'望月','分析员','2004-08-16',2600.3);