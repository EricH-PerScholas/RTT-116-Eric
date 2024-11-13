package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailsDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class FridayHomework4TheEasyAndCorrectWay {

     public static void main ( String[] args) {
         ProductDAO productDAO = new ProductDAO();
         OrderDAO orderDao = new OrderDAO();
         OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();

         Order o = orderDao.findOrderById(10100);
         Product p = productDAO.findById(1);

         OrderDetail od = orderDetailsDAO.findByOrderIdAndProductId(o.getId(), p.getId());

         if (od == null) {
             // this is a create because the combination of orderid and productid was not found in the database so we can create it
             od.setOrderId(o.getId());
             od.setProductId(p.getId());
             od.setQuantityOrdered(100);
             od.setPriceEach(1.99);
             od.setOrderLineNumber(1);

             orderDetailsDAO.createOrderDetail(od);
         } else {
             // this is the case where the item already exists as part of the order
             od.setQuantityOrdered( od.getQuantityOrdered() + 100);
             orderDetailsDAO.updateOrderDetail(od);
         }

     }
}
