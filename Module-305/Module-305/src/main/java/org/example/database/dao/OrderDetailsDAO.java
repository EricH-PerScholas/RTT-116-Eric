package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void createOrderDetail(OrderDetail odObject) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(odObject);
        session.getTransaction().commit();

    }

    public void deleteOrderDetail(OrderDetail odObject) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.detach(odObject);
        session.getTransaction().commit();
    }

    public void updateOrderDetail(OrderDetail odObject) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(odObject);
        session.getTransaction().commit();
    }

    public OrderDetail findByOrderIdAndProductId(int orderId, int productId) {
        Session session = factory.openSession();


        String hql = "SELECT od from OrderDetail od where od.orderId = :orderId and od.productId = :productId";

        // Advanced HQL query allows us to use the annotations to allow hibernate to do the joins for us
        //String hql = "SELECT od from OrderDetail od where od.order.id = :orderId and od.product.id = :productId";

        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);

        try{
            OrderDetail orderDetail = query.getSingleResult();
            return orderDetail;
        }catch(Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    public OrderDetail findOrderDetailById(Integer id) {
        Session session = factory.openSession();

        String hql = "SELECT od from OrderDetail od where od.id = :orderdetailId";

        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("orderdetailId", id);

        try{
            OrderDetail orderDetail = query.getSingleResult();
            return orderDetail;
        }catch(Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    public List<Integer> findByOrderId(Integer orderId) {
        Session session = factory.openSession();

        String hql = "SELECT od from OrderDetail od where od.orderId = :orderId";

        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("orderId", orderId);

        try{
            List<OrderDetail> orderDetail = query.getResultList();

            List<Integer> list = new ArrayList<>();
            for(OrderDetail od : orderDetail) {
                list.add(od.getProductId());
            }
            return list;
        }catch(Exception e) {
            return null;
        }finally {
            session.close();
        }
    }
}
