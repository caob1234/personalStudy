1.利用having查询订单数量大于1的用户：
`
SELECT user_id,count(order_id) AS orderNum FROM `order` GROUP BY user_id HAVING orderNum>1
`