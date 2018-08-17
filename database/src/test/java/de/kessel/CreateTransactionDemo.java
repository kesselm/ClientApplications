package de.kessel;

import de.kessel.entities.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;


public class CreateTransactionDemo {

    public static void main(String[] args) throws ParseException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Transaction.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            Date date = new Date();
            Transaction tmpTransaction = new Transaction(date,"b","c",
                    "d", new BigDecimal(-10000.01),new BigDecimal(-30.05), "g");
            session.beginTransaction();
            System.out.println("Saving the student...");
            session.save(tmpTransaction);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
