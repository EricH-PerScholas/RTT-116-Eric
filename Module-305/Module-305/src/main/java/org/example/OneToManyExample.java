package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;

public class OneToManyExample {

    public static void main( String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        CustomerDAO customerDAO = new CustomerDAO();


        // when this run .. hibernate runs an actual query
        Employee e = employeeDAO.findById(1501);

        System.out.println(e);

        // I am asking the database for the list of customers for this employee
        for (Customer c : e.getCustomers() ) {
            System.out.println(c);

            System.out.println(c.getEmployee());
        }

        // add a new custoemr to this employee using hibernate
        // first we create the new customer etity and fill it up with data
        Customer newCustomer = new Customer();

        newCustomer.setCustomerName("New Customer");
        newCustomer.setContactFirstname("Eric");
        newCustomer.setContactLastname("Eric");
        newCustomer.setPhone("5555551212");
        newCustomer.setAddressLine1("5555551212");
        newCustomer.setAddressLine1("222222");
        newCustomer.setCity("city");
        newCustomer.setState("asdfasdf");
        newCustomer.setPostalCode("023432");
        newCustomer.setCountry("USA");
        newCustomer.setCreditLimit(234.33);
        // one of the gotchas is that you have to set the employee on the new customer even tho you are adding the customer the list of customers in the next line of code
        newCustomer.setEmployee(e);
        //newCustomer.setSalesRepEmployeeId(1034); // this line of code will not work because we told the field to be read only in the configuration

        // this is the best way to do this but wanted to show other hibernate features
        //customerDAO.createCustomer(newCustomer);

        // then we can add the new custoemr to the list of existing customrs for this employee
        e.getCustomers().add(newCustomer);

        // THEN !!!!!  we save the employee!!!!!!!!!!!
        employeeDAO.update(e);

    }
}
