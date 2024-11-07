package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

public class UpdatePriceDemo {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        Product p = productDAO.findById(1);

        p.setProductCode("AAAAAAAAA");

        productDAO.update(p);
        // we assume that the update has happened at this point
    }

}
