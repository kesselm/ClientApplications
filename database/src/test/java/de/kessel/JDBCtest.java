package de.kessel;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCtest {

    public static void main(String[] args){

        String jdbcUrl = "jdbc:mysql://localhost:3306/finance?useSSL=false";
        String user = "finance";
        String pass = "finance";

        try {
            System.out.println("Connection to databse" + jdbcUrl);
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successfull!!!");


        } catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
