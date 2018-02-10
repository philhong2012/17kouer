1、创建数据库前一定要设置好编码,通常是指编码为utf8，否则会造成插入中文乱码的问题。
 例如:程序抛异常 java.sql.SQLException: Incorrect string value: '\xE8\xAF\xAD\xE6\x96\x87'
 说明 数据库创建的表的编码跟插入数据的编码不一致
 查看mysql编码：show variables like 'character_set_%';

2、设置编码在my.inf文件中加入：
[mysql]
default-character-set = utf8

[client]
default-character-set = utf8

[mysqld]
character_set_server = utf8

3、mysql的基础命令：
*启动
mysqld --console

*连接mysql
mysql -u 登录名 -p 密码

*停止mysql server
mysqladmin -u 登录名 shutdown
或者直接在当前窗口control+c

*windows下创建mysql服务
mysqld --install 服务名
如果出现 Install/Remove of the Service Denied! 提示，就先用管理员模式启动command
安装成功会提示 Service successfully installed.
默认服务名为MySQL

创建服务并指定配置文件
# mysqld --install MySQLXY --defaults-file="C:\Program Files\MySQL\MySQL Server X.Y\my.ini"

运行mysql服务
net start MySQL

删除MySQL服务
mysqld --remove 服务名

执行.sql文件
source xxx.sql

修改root用户密码
mysqladmin -uroot -p原密码 password 新密码
mysqladmin -uroot -p123456 password 123

创建数据库
create database demo

删除数据库
drop database demo

查看所有数据库
show databases;

查看所有表
use demo
show tables