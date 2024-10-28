-- JOIN and GROUP BY
-- how many employees are in each office ... I want to see the office name and the count of the employees in that office
-- group by is called an aggregate function because we can make things into groups and then find information about that group
select * from employees;
select * from offices;

-- step 1 ... just get the count of the office ids
select office_id, count(*) 
from employees
group by office_id;

-- step 2 ...  we added on the name of the office which foced us to add another table to the from
-- and to add the where clause to link the 2 tables to gether
select o.city, e.office_id, count(*) 
from employees e, offices o
where e.office_id = o.id
group by office_id;

-- just an example of finding the count of all the same first name
select firstname, count(*) 
from employees
group by firstname;

-- ############# Find the employee with the most customers
-- step 1
select sales_rep_employee_id, count(*) 
from customers
group by sales_rep_employee_id
order by count(*) desc;

-- step 2 -- adding on the employee table to get the employee name
-- note that we lost the nulls ... from the customer table ... which is okay in this case because we are looking for the employee with the most customers
-- we did not ask for all the custoemrs that have no sales rep
select * from customers;
select e.firstname, e.lastname, sales_rep_employee_id, count(*) 
from customers c, employees e
where c.sales_rep_employee_id = e.id
group by sales_rep_employee_id
order by count(*) desc;

-- ########  I want to see a list of all customers for the San Fansico office
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname
from offices o, employees e, customers c
where o.id = 1
	and e.office_id = o.id
    and c.sales_rep_employee_id = e.id;
    
-- ########  I want to see of all customers, the sales rep, and the office name
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname
from offices o, employees e, customers c
where e.office_id = o.id
    and c.sales_rep_employee_id = e.id;
    
-- ####### I want to see all of the customer that have made an order, and I want to see the customer name, the office, the employee name, and the order id and the order date
select * from orders;
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id, ord.order_date
from offices o, employees e, customers c, orders ord
where e.office_id = o.id
    and c.sales_rep_employee_id = e.id
    and ord.customer_id = c.id
order by e.id, customer_name;

-- ### I want to see the list of all products purchased - I want to see the customer name, the office, the employee name, the order id and date, AND the product id and quantity ordered
select * from orders;
select * from orderdetails;
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id, ord.order_date, od.product_id, od.quantity_ordered
from offices o, employees e, customers c, orders ord, orderdetails od
where e.office_id = o.id
    and c.sales_rep_employee_id = e.id
    and ord.customer_id = c.id
    and od.order_id = ord.id
order by e.id, customer_name, order_id;