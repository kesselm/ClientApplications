package de.kessel;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Properties;

/**
 * @project ClientApplication

 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Properties prop= new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/finance?useSSL=false&amp;serverTimezone=UTC");
            prop.setProperty("hibernate.connection.username", "finance");
            prop.setProperty("hibernate.connection.password", "finance");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            sessionFactory = new AnnotationConfiguration()
                    .addPackage("com.concretepage.persistence")
                    .addProperties(prop)
                    .addAnnotatedClass(Transaction.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
