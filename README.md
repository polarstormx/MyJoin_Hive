# MyJoin_Hive

jar包执行命令：
hadoop jar /home/2020st18/HiveMyJoin.jar MyJoin.JoinDriver /data/exercise\_3 output2 

hive建表命令：
create table orders(id int,order\_date string,pid string,name string,price int,num int) row format delimited fields terminated by '\t' location '/user/2020st18/output2/';
