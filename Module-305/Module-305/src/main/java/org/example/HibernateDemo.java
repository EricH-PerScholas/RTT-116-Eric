package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) {
        // business logic
        ProductDAO productDao = new ProductDAO();

        // find a specific product by id
        Product p = productDao.findById(1);
        System.out.println(p);

        // find all products with the name ford
        List<Product> fords = productDao.search("Ford");
        for ( Product ford : fords ) {
            System.out.println(ford);
        }
    }

}
