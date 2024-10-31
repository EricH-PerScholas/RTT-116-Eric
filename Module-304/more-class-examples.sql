-- lets calculate the total profit for an order 10100
select p.product_name, p.buy_price, od.quantity_ordered, od.price_each as sale_price, (price_each - buy_price) as product_margin, 
	quantity_ordered * (price_each - buy_price) as line_item_margin
from products p, orderdetails od
where p.id = od.product_id AND od.order_id = 10100;


-- lets calculate the total profit for all orders
select od.order_id, sum(quantity_ordered * (price_each - buy_price)) as total_profit
from products p, orderdetails od
where p.id = od.product_id 
group by od.order_id;

-- total profit for a month
select year(o.order_date), month(o.order_date), sum(quantity_ordered * (price_each - buy_price)) as total_profit
from products p, orderdetails od, orders o
where p.id = od.product_id and od.order_id = o.id
group by year(o.order_date), month(o.order_date);


select * from orders 
where order_date < current_date();


select ifnull(comments, 'Replace comment')
from orders;

-- this is a wrong qury ***********
select * from orders where comments = null;
-- this the the way to check if something is null
select * from orders where comments is not null;

-- this is not equals
select * from orders where id != 10107;



-- SBA Question
-- behaves the same as a switch statement in java
SELECT product_name, buy_price, 
CASE
	WHEN buy_price > 80 AND buy_price <=  50 THEN "LOW PRICE"
	WHEN buy_price >= 50 AND buy_price <= 100 THEN "Medium Price"
	WHEN buy_price > 100 AND buy_price <= 200 THEN "high Price"
ELSE "Out of our rang" END AS price_status 
FROM products 
where buy_price > 9
ORDER BY buy_price DESC;

-- in operates like an OR in this case will return any row matching any of the 3 cities
select * from customers;
select * from customers where city IN ('Las Vegas', 'Nantes', 'Frankfurt');
select * from customers where city = 'Las Vegas' or city = 'Nantes' or city = 'Frankfurt';


-- show all of the orders for customers that have a name starting with A
select id from customers where customer_name like 'A%';
-- this is a common technique to use an "in" statement to filter by a subquery
-- the subquery must return a single column or it wont work
-- you could totally rewrite this to join 
select * from orders where customer_id in ( select id from customers where customer_name like 'A%');

-- subquery - by using subquery in the from clause it creates a small table in memory from the query
-- then you can join to the table as if it were a real table
select *
from orders o, 
	( select id from customers where customer_name like 'A%' ) as c
where o.customer_id = c.id;

-- ================== LEFT JOIN =======================

select * from customers where id = 125;
select * from orders where customer_id = 125;

-- this is the left join syntax for 2 tables
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id;

-- this is a regular query (this is an inner join)
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c, orders o
where c.id = o.customer_id
order by c.id;

-- this is the same regular query accept using the MySQL syntax 
-- this is the same as above accept using the inner join syntax from mysql
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
INNER JOIN orders o ON c.id = o.customer_id
order by c.id;


-- ===================== SELF JOIN =====================

select * from customers;
select * from employees;

-- when doing a self join you use the same table in the from 2 times
-- self referencing table 
select e.id, e.lastname, e.firstname, e.job_title, m.id as manager_id, m.lastname as manager_lastname, m.firstname as manager_firstname, m.job_title
from employees e, employees m
where e.reports_to = m.id;

-- ======================= UNION =========================
-- does get used from time to time
-- main use is in reports or very complex queryies 
-- union does not include duplicates - meaning after mering the result sets there are no duplicates
-- union all inludes duplicates

select * from customers where customer_name like 'A%'
union
select * from customers where customer_name like 'A%';

select phone from customers where customer_name like 'A%'
union
select firstname from employees;