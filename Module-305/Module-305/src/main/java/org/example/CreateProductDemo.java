package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

public class CreateProductDemo {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product p = new Product();

        // when creating a new product we do not set the id.   The id must be null
        // after the insert is done, hibernate will populate the entity with the new id
        p.setBuyPrice(5.99);
        p.setMsrp(1.99);
        p.setProductName("New Product");
        p.setProductCode("NPC");
        p.setProductlineId(1);
        p.setProductDescription("Product Description");
        p.setQuantityInStock(50);
        p.setProductScale("scale");
        p.setProductVendor("vendor");

        // id will be null
        System.out.println("before = "  + p);
        productDAO.create(p);
        // id will be not null number that was generated
        System.out.println("after = " + p);

    }
}
