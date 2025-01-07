package com.example.module309.database.dao;

import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.contactFirstname = :firstName")
    List<Customer> findByFirstName(String firstName);

    Customer findById(Integer id);

    List<Customer> findByContactLastname(String lastName);

    // this query is the equivalent of the following Spring Data Function
    // select * from customer where contact_firstname = :firstName and contact_lastname = :lastName order by id desc
    List<Customer> findByContactFirstnameAndContactLastnameOrderByIdDesc(String firstName, String lastName);

    // used for reporting the data from multiple tables
    // this kind of query is also called ad hoc query
    // if you need to do any kind of aggeregate queries this is the best way to do it
    // the key to remember is .. when I need columns from more than one table .. then I need to use a List<Map<String,ObjecT>>
    // each item in the list is 1 row of data
    // the key to the map is the column name and the value is the value of that column
    @Query(value = "select c.customer_name, c.contact_lastname, c.contact_firstname, " +
            "e.firstname as employee_firstname, e.lastname as employee_lastname " +
            "from customers c, employees e " +
            "where c.sales_rep_employee_id = e.id ", nativeQuery = true)
    List<Map<String,Object>> findCustomersWithEmployeeNames();
}
