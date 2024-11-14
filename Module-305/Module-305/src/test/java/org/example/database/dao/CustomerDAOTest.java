package org.example.database.dao;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

    private CustomerDAO customerDAO = new CustomerDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Test
    public void findCustomerByIdTest() {
        // given
        int givenCustomerId = 125;

        // when
        Customer actual = customerDAO.findCustomerById(givenCustomerId);

        // then
        Assertions.assertEquals("Havel & Zbyszek Co", actual.getCustomerName());
        Assertions.assertEquals(givenCustomerId, actual.getId());
        Assertions.assertEquals(0.00, actual.getCreditLimit());
    }

    @Test
    public void createCustomer() {
        // given
        Customer given = new Customer();

        given.setCustomerName("New Customer");
        given.setContactFirstname("Eric");
        given.setContactLastname("Eric");
        given.setPhone("5555551212");
        given.setAddressLine1("5555551212");
        given.setAddressLine1("222222");
        given.setCity("city");
        given.setState("asdfasdf");
        given.setPostalCode("023432");
        given.setCountry("USA");
        given.setCreditLimit(234.33);

        // we are not testing the employee so it is okay to just query one from the database and set it
        Employee employee = employeeDAO.findById(1216);
        given.setEmployee(employee);

        // when
        // we want to make sure taht the given .getid is null before we insert to the database
        Assertions.assertNull(given.getId());
        Customer actual = customerDAO.createCustomer(given);
        // also totally acceptable to requery the item that you just created
        // Customer actual = custoemrDAO.findByCustomerName("New Custoemr");

        // then
        // we want to make sure taht the object now has an id
        Assertions.assertNotNull(actual.getId());
        Assertions.assertNull(actual.getSalesRepEmployeeId());

        Assertions.assertEquals(given.getContactFirstname(), actual.getContactFirstname());
        Assertions.assertEquals(given.getContactLastname(), actual.getContactLastname());

        // create an additional assertion to check the employee id is correct
        Assertions.assertEquals(employee.getId(), actual.getEmployee().getId());


    }



}
