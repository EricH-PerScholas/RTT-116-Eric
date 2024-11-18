package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Customer;

public class EqualsExample {

    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();

        String s1 = "abc";
        String s2 = "xyz";

        boolean e1 = s1.equals(s2);

        Customer c1 = customerDAO.findCustomerById(114);
        Customer c2 = customerDAO.findCustomerById(114);

        System.out.println("c1 == c2 " + c1.equals(c2));
    }

}
