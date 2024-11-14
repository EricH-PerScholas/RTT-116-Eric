package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Customer createCustomer(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(customer);
        session.getTransaction().commit();
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.detach(customer);
        session.getTransaction().commit();
    }

    public void updateCustomer(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
    }

    public Customer findCustomerById(Integer id){

        String sql = "select * from product where id = ?";
        Session session = factory.openSession();

        String hqlQuery = "SELECT c FROM Customer c WHERE c.id = :customerId";        //Hibernate Query Language

        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);
        query.setParameter("customerId", id);

        try {
            Customer result = query.getSingleResult();
            return result;
        }catch (Exception e) {
            return null;

        }finally {
            session.close();
        }
    }

    public List<Customer> findCustomerWithName(String name) {
        Session session = factory.openSession();

        String hqlName = "SELECT c FROM Customer c WHERE c.contactFirstname = :cName " +
                "                                   OR c.customerName = :cName" +
                "                                   OR c.contactLastname = :cName" +
                "                                   ORDER BY c.contactFirstname";

        TypedQuery<Customer> query = session.createQuery(hqlName, Customer.class);
        query.setParameter("cName", name);

        try{
            List<Customer> resultNameList = query.getResultList();
            return resultNameList;
        }catch(Exception e) {
            return new ArrayList<>();

        }finally {
            session.close();
        }

    }
}
