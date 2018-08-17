package de.kessel.hibernate;

import de.kessel.entities.Transaction;
import de.kessel.services.TransactionService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        TransactionService transactionService = new TransactionService();
        Date date = new Date();
        Transaction trans1 = new Transaction(date,"b","c",
                "d", new BigDecimal(-10000.01),new BigDecimal(-30.05), "g");
        Transaction trans2 = new Transaction(date,"b","c",
                "d", new BigDecimal(-10000.01),new BigDecimal(-30.05), "g");
        Transaction trans3 = new Transaction(date,"b","c",
                "d", new BigDecimal(-10000.01),new BigDecimal(-30.05), "g");
        System.out.println("*** Persist - start ***");
        transactionService.persist(trans1);
        transactionService.persist(trans2);
        transactionService.persist(trans3);
        System.out.println("*** Before findAll() ***");
        List<Transaction> trans = transactionService.findAll();
        System.out.println("Books Persisted are :");
        for (Transaction b : trans) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");
        transactionService.update(trans1);
        System.out.println("*** Update - end ***");

        System.out.println("*** FindAll - end ***");
        System.out.println("*** DeleteAll - start ***");
        transactionService.deleteAll();
        System.out.println("Books found are now " + transactionService.findAll().size());
        System.out.println("*** DeleteAll - end ***");
        System.exit(0);
    }
}
