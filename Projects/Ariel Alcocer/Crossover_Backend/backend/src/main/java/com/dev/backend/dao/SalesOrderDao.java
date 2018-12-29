package com.dev.backend.dao;

import com.dev.backend.model.SalesOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(SalesOrder salesOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(salesOrder);
    }

    public void update(SalesOrder salesOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.update(salesOrder);
    }

    public SalesOrder findOne(Long salesOrderId) {
        Session session = sessionFactory.getCurrentSession();
        return (SalesOrder)session.load(SalesOrder.class, salesOrderId);

    }

    @SuppressWarnings("unchecked")
    public List<SalesOrder> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<SalesOrder>)session.createQuery("from SalesOrder").list();
    }

    public SalesOrder findByOrderNumber(String orderNumber) {
        Session session = sessionFactory.getCurrentSession();
        return (SalesOrder)session.createQuery("from SalesOrder where orderNumber = :orderNumber")
                .setParameter("orderNumber", orderNumber)
                .uniqueResult();
    }

    public void delete(SalesOrder salesOrder)   {
        Session session = sessionFactory.getCurrentSession();
        session.delete(salesOrder);
    }
}
