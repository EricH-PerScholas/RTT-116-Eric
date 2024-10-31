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

--  ==================================================

select c.customer_name AS Customer, 
	SUM(od.quantity_ordered * od.price_each) AS Due, 
	COALESCE(SUM(p.amount), 0) AS Paid, -- could be accomplished with a subquery
	SUM(od.quantity_ordered * od.price_each) - COALESCE(SUM(p.amount), 0) AS Balance
FROM customers c
JOIN orders o on c.id = o.customer_id
JOIN orderdetails od ON o.id = od.order_id
LEFT JOIN payments p ON c.id = p.customer_id
GROUP BY c.id, c.customer_name
HAVING Balance > 0
ORDER BY Balance DESC;

-- any customer that has not made a payment ever will not appear in this query .. this is a high priority because it has a high probablility of happening.
-- any customer that has made a payment but never made an order would also never appear in this query ... low level problem because its not likely to exist
select c.id, c.contact_firstname, c.contact_lastname, 
	sum(quantity_ordered * price_each) as total_purchase, 
	( select sum(pm.amount) from payments pm where pm.customer_id = c.id) as total_payment, 
if(sum(quantity_ordered * price_each) > ( select sum(pm.amount) from payments pm where pm.customer_id = c.id), 
(sum(quantity_ordered * price_each) - ( select sum(pm.amount) from payments pm where pm.customer_id = c.id)), 'No outstanding' ) as outstanding_balance 
from customers c, orderdetails od, orders o
where  o.customer_id = c.id
    and od.order_id = o.id
group by c.id
order by c.id;


select c.id, c.contact_firstname, c.contact_lastname, 
sum(quantity_ordered * price_each) as total_purchase, total_payment, 
if(sum(quantity_ordered * price_each) > total_payment, (sum(quantity_ordered * price_each) - total_payment), 'No outstanding' ) as outstanding_balance 
from customers c, orderdetails od, orders o, 
-- this is done less but still is possible
	( select c.id, ( select sum(pm.amount) from payments pm where pm.customer_id = c.id) as total_payment
	from customers c ) pm
where pm.id = c.id
	and o.customer_id = c.id
    and od.order_id = o.id
group by c.id
order by c.id;

-- to use a query as a subtable
 select c.id, ( select sum(pm.amount) from payments pm where pm.customer_id = c.id) as total_payment
	from customers c;


select c.id, c.customer_name, sum(od.quantity_ordered * od.price_each) as amount_purchased, ( select sum(pm.amount) from payments pm where pm.customer_id = c.id) as amount_paid,
 sum(od.quantity_ordered * od.price_each) - ( select sum(pm.amount) from payments pm where pm.customer_id = c.id) as balance
from customers c, orders o, orderdetails od
where
o.customer_id = c.id
and od.order_id = o.id
group by o.customer_id;

select * from payments where customer_id = 131;
select * from orders where customer_id = 131;
select * from orderdetails where order_id in ( 10107, 10248, 10292, 10329);

--- 

select c.id as customer_id,c.customer_name ,
sum(od.quantity_ordered * od.price_each) as total_price,
(sum(od.quantity_ordered*od.price_each)-sum(pay.amount)) as amount_due
from customers c, payments pay, orders o, orderdetails od, products p
where c.id = pay.customer_id
and c.id = o.customer_id
and o.id = od.order_id
and od.product_id = p.id
group by c.id
order by amount_due desc;

-- 

SELECT c.id, 
    c.customer_name AS Customer, 
    od.total_due AS Due, 
    COALESCE(p.total_paid, 0) AS Paid, 
    od.total_due - COALESCE(p.total_paid, 0) AS Balance
FROM customers c
JOIN (
    -- subquery he create customer id, total amount spent 
    SELECT o.customer_id, 
           SUM(od.quantity_ordered * od.price_each) AS total_due
    FROM orders o
    JOIN orderdetails od ON o.id = od.order_id
    GROUP BY o.customer_id
) od ON c.id = od.customer_id
LEFT JOIN (
    SELECT customer_id, 
           SUM(amount) AS total_paid
    FROM payments
    GROUP BY customer_id
) p ON c.id = p.customer_id
ORDER BY Balance DESC;


--   


	SELECT EXTRACT(YEAR FROM o.order_date) AS Year, p.product_name, SUM(od.quantity_ordered * (od.price_each - p.buy_price)) AS Profit
	FROM orderdetails od
	JOIN orders o ON od.order_id = o.id
	JOIN products p ON od.product_id = p.id
	GROUP BY
		Year, p.product_name
	ORDER BY 
		Year DESC, Profit DESC;
       
       
select year(o.order_date), p.product_name, sum(od.quantity_ordered*(od.price_each - p.buy_price)) as profit
from orderdetails od, products p, orders o
where od.product_id = p.id
and od.order_id = o.id
group by year(o.order_date), od.product_id
order by year(o.order_date) desc, profit desc ;


SELECT YEAR(o.order_date) AS year, p.product_name, SUM((od.price_each * od.quantity_ordered) - (p.buy_price * od.quantity_ordered)) AS total_profit 
FROM orderdetails AS od, products AS p, orders AS o 
WHERE od.product_id = p.id AND od.order_id = o.id AND o.order_date IS NOT NULL 
GROUP BY year, p.product_name 
ORDER BY year DESC, total_profit DESC;

--  Lets see if there are any prdocut lines that have never had a product ordered
select * from products;

select *
from productlines pl
where pl.id not in ( select p.productline_id from products p, orderdetails od where p.id = od.product_id );


select distinct p.productline_id from products p, orderdetails od where p.id = od.product_id;

INSERT INTO `classic_models`.`productlines`
(
`product_line`,
`description`)
VALUES
(
'Test Line',
'Just for this class');


