package de.kessel.dao;

import de.kessel.HibernateUtil;
import de.kessel.entities.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class TransactionDAO implements ITransactionDAO<Transaction, String> {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private Session currentSession;

    private org.hibernate.Transaction currentTransaction;

    public TransactionDAO(){
    }

    private static SessionFactory buildSessionFactory() {
        try
        {
            if (sessionFactory == null)
            {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transaction.class);
                StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
                serviceRegistryBuilder.applySettings(configuration.getProperties());
                ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            return sessionFactory;
        } catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.getCurrentSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().getCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public org.hibernate.Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(org.hibernate.Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Transaction entity) {
        getCurrentSession().save(entity);
    }

    public void update(Transaction entity) {
        getCurrentSession().update(entity);
    }

    public Transaction findById(String id) {
        Transaction transaction = getCurrentSession().get(Transaction.class, id);
        return transaction;
    }

    public void delete(Transaction entity) {
        getCurrentSession().delete(entity);
    }


    public List<Transaction> findAll() {
        System.out.println("TransactionDAO.findAll() - List<Transaction>");
        List<Transaction> transactions = (List<Transaction>) getCurrentSession().createQuery("from Transaction").list();
        return transactions;
    }

    public void deleteAll() {
        List<Transaction> entityList = findAll();
        for (Transaction entity : entityList) {
            delete(entity);
        }
    }
}
