-- 1) I want to see the name of the product line and all product names in that product line
select pl.product_line, p.product_name 
from productlines pl, products p
where p.productline_id = pl.id
order by pl.product_line, p.product_name;

-- 2) I want to see the order number, the product name, and the quantity ordered
select o.id, p.product_name, od.quantity_ordered
from orders o, orderdetails od, products p
where od.order_id = o.id and p.id = od.product_id
order by o.id desc, quantity_ordered asc;


-- 3) I want to see all payments made by customers.  The result should show the customer name, the check number, payment date, and the amount.   
-- I want the result set ordered by the customer name (ascending), the payment date ( descending  newest first)
select c.customer_name, p.check_number, p.payment_date, p.amount 
from payments p, customers c
where p.customer_id = c.id
order by c.customer_name asc, payment_date desc;

-- 4) I want to see the orders and all products in that order - order number and product name 
-- order by the order number ascending and the product name descending.
select od.order_id as order_number, p.product_name
from orderdetails od, products p
where od.product_id = p.id
order by od.order_id asc, p.product_name desc;

-- 5) I want to see the number of products in each order - 
-- I want to see the order id and the total number of products in each order ... order by count(*) desc
-- we are grouping by a foreign key so we can not get indivdual column data
select * from orderdetails;
select sum(quantity_ordered) from orderdetails;

select order_id, count(quantity_ordered) as cnt, sum(quantity_ordered) as total_quanity, max(quantity_ordered) as max, min(quantity_ordered), 
	avg(price_each), max(price_each)
from orderdetails
group by order_id
order by order_id;

-- 6) I want to see the customer that has made most payments (group by customer_id)
select customer_id, count(*) as cnt
from payments p
group by customer_id
order by 2 desc;

-- 7) I want to see the office that has has the most orders (group by office_id)
-- when grouping by the primary key .. we can get individual colums about the primary key along with the aggregate data
select * from offices;

-- when the database executes the query .. internally first it gathers all the data without the group by and using the where clause
-- then it does the group by and figures out the aggregate functions
-- then it applys the having
select o.id, o.city, year(ord.order_date), count(distinct e.id) as employees, count(distinct c.id) as customer_count, count(*) as order_count
from offices o, employees e, customers c, orders ord
where o.id = e.office_id
	and e.id = c.sales_rep_employee_id
    and c.id = ord.customer_id
    -- we can not use aggregate functions in the where clause - this is a good rule of thumb
    -- however we can use the raw data to limit the query before it does the aggregate function
    -- and year(ord.order_date) = 2003 and month(ord.order_date) = 6
   -- and c.customer_name LIKE 'A%'
group by o.id, year(ord.order_date)
-- having is very much like a where clause accept that it only works on the aggrgate functions
-- can only be used with group by statements
-- having count(distinct e.id) > 1
order by o.id asc, year(ord.order_date) desc;

-- 8) I want to see the order that has the most products ( group by order_id)
select order_id, count(*)  
from orderdetails
group by order_id
order by count(*) desc;

-- --------------------------------

select order_date, year(order_date), month(order_date) from orders;

select lcase(city) from offices;

select concat(firstname, lastname) from employees;

-- ------------------------------
select  o.city,count(*), count(distinct e.id), count(distinct c.id)
from orders od, customers c, employees e, offices o 
where od.customer_id = c.id 
and c.sales_rep_employee_id = e.id
and e.office_id = o.id
and year(od.order_date) = 2003
group by o.id
order by count(*)desc;


SELECT customer_number, customer_name, credit_limit
FROM customers
ORDER BY credit_limit DESC
LIMIT 5,2;

-- ===================

  SELECT SUM(quantity_ordered * price_each) as orderTotal 
  FROM orderdetails 
  WHERE order_id = 10100; 



