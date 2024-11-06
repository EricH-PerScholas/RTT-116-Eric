package org.example;

import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";

        // this is called a secret
        String user = "dev";
        String password = "ultra30dev";

        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            // these 3 lines of code are using a regular Statement to execute the query
            //String SelectSQL = "Select * FROM employees where id = 1056";
            ///Statement stmt = connection.createStatement();
           /// ResultSet result =  stmt.executeQuery(SelectSQL);

            // when we have variables we want to use a PreparedStatement
            // in general we want to use a preparedStatement for everything !!!!! as a best practice
            // primary for security reason around SQL Injection attacks
            String selectSQL = "Select * FROM employees where id = ?";
            PreparedStatement stmt = connection.prepareStatement(selectSQL);
            stmt.setInt(1, 1076 );

            // using the sample from the slides
            //String selectSQL1 = "Select * FROM employees where salary > ? and id = ?";
            //PreparedStatement stmt1 = connection.prepareStatement(selectSQL);
            ///stmt.setInt(1, salary);
            //stmt.setString(2, 1076 );

            ResultSet result = null;
            try {
                 result = stmt.executeQuery();

                while (result.next()) {
                    String EmployeeID = result.getString("id");
                    String fname = result.getString("firstname");
                    String lname = result.getString("lastname");
                    String email = result.getString("email");
                    System.out.println(EmployeeID + " | " + fname + "|" + lname  + "|" + email);
                }

            } catch  ( Exception e ) {
                if ( result != null ) {
                    result.close();
                }
            }
            stmt.close();
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }




}
