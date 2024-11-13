package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void createOrder(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(order);
        session.getTransaction().commit();
    }

    public void deleteOrder(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.detach(order);
        session.getTransaction().commit();
    }

    public void updateOrder(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(order);
        session.getTransaction().commit();
    }

    public Order findOrderById(Integer id) {
        Session session = factory.openSession();

        String hql = "SELECT o from Order o where o.id = :orderid";

        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("orderid", id);

        try{
            Order order = query.getSingleResult();
            return order;
        }catch(Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

}
