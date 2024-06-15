# Bank Console

A native Java implementation of a GUI program that simulates a bank control panel.

This is a lab assignment from my Java class. The original requirements are as follows:

```text
编写一个程序，采用图形用户界面，模拟银行自动取款机的工作流程。

基本功能如下所述：
1)	当输入给定的卡号和密码（初始卡号为 888888 和密码为 123456 ）时，系统能登录 ATM 柜员机系统，用户可以按照以下规则进行：
2)	查询余额：初始余额为 50000 元。
3)	ATM取款：每次取款金额为 100 的倍数，总额不超过 5000 元，支取金额不允许透支。
4)	ATM存款：不能出现负存款。
5)	修改密码：只有旧密码正确，新密码符合要求，且两次输入相同的情况下才可以成功修改密码。

扩展功能如下所述：
1)	美化界面；
2)	增加菜单；
3)	增加银行员工管理模块；
4)	增加数据存储功能；
5)	可自行设计合理扩展功能等。
```

SQL to create an example database:

```sql
CREATE DATABASE IF NOT EXISTS bank_console;
USE bank_console;
CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    balance INT NOT NULL
);
INSERT INTO people (username, password, role, balance) VALUES ('admin', 'admin', 'administrator', 0), ('888888', '123456', 'customer', 50000);
```
