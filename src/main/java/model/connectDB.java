package model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.*;

public class connectDB {
    private static DataSource datasource;

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/login",
                "root", "root"
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
        }
        return connection;
//        if (datasource==null){
//            PoolProperties p = new PoolProperties();
//            p.setUrl("jdbc:mysql://127.0.0.1:3306/login");
//            p.setUsername("root");
//            p.setPassword("root");
//            p.setMaxActive(100);
//            p.setMaxIdle(10);
//            p.setRemoveAbandonedTimeout(60);
//            p.setRemoveAbandoned(true);
//            datasource = new DataSource(p);
//            datasource.setPoolProperties(p);
//        }
//
//        return datasource.getConnection();
    }
}



//CONTROLLO CHE LA CONNESSIONE FUNZIONI CORRETTAMENTE TRAMITE QUESTO STATEMENT SUL DB
//    public static void main (Strings []args) throws SQLException {
//
//        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://127.0.0.1:3306/login",
//                "root", "root"
//        );
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from users");
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("username"));
//            System.out.println(resultSet.getString("password"));
//        }
//        return connection;
//    }


