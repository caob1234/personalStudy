准备：在服务器上按以下链接建立mysql。
[docker安装mysql](https://www.cnblogs.com/zhi-leaf/p/10561766.html)

#1.利用having查询订单数量大于1的用户：
`
SELECT user_id,count(order_id) AS orderNum FROM order GROUP BY user_id HAVING orderNum>1
`

相关资料：https://blog.csdn.net/weixin_44133711/article/details/90756909

#2.常用sql优化：
##2.1 索引

在InnoDB中索引是B+Tree结构的，在该结构中，叶子节点包含了非叶子节点的所有数据，并且叶子节点之间通过指针连接。即>,<,between...and
这类查询语句，直接扫描叶子节点即可。

#3.InnoDB引擎
从MySQL5.5.X开始，默认的存储引擎变更为InnoDB Plugin引擎。InnoDB给MySQL提供了具有提交、回滚和崩溃恢复能力的事务安全（ACID兼容）
存储引擎。InnoDB锁定在行级。

