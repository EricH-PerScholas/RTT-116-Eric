package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

public class OneToManyExample {

    public static void main( String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee e = employeeDAO.findById(1501);

        System.out.println(e);

    }
}
