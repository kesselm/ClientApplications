package de.kessel.services;

import de.kessel.dao.TransactionDAO;
import de.kessel.entities.Transaction;

import java.util.List;

public class TransactionService {

    private static TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAO();
    }

    public void persist(Transaction entity) {
        System.out.println("TransactionService.persist() - OpenCurrentSessionWithTransaction()");
        transactionDAO.openCurrentSessionwithTransaction();
        System.out.println("TransactionService.persist() - persistent");
        transactionDAO.persist(entity);
        System.out.println("TransactionService.persist() - CloseCurrentSessionWithTransaction");
        transactionDAO.closeCurrentSessionwithTransaction();
    }

    public void update(Transaction entity) {
        transactionDAO.openCurrentSessionwithTransaction();
        transactionDAO.update(entity);
        transactionDAO.closeCurrentSessionwithTransaction();
    }

    public Transaction findById(String id) {
        transactionDAO.openCurrentSession();
        Transaction book = transactionDAO.findById(id);
        transactionDAO.closeCurrentSession();
        return book;
    }

    public void delete(String id) {
        transactionDAO.openCurrentSessionwithTransaction();
        Transaction book = transactionDAO.findById(id);
        transactionDAO.delete(book);
        transactionDAO.closeCurrentSessionwithTransaction();
    }

    public List<Transaction> findAll() {
        System.out.println("TransactionService.findAll() - openCurrentSession()");
        transactionDAO.openCurrentSession();
        System.out.println("TransactionService.findAll() - List<Transaction>");
        List<Transaction> books = transactionDAO.findAll();
        System.out.println("TransactionService.findAll() - closeCurrentSession()");
        transactionDAO.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        transactionDAO.openCurrentSessionwithTransaction();
        transactionDAO.deleteAll();
        transactionDAO.closeCurrentSessionwithTransaction();
    }

    public TransactionDAO bookDao() {
        return transactionDAO;
    }
}
