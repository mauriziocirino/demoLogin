package model;

import java.sql.*;

public class connectDB {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login",
                    "root", "root"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public static Connection getConnection() throws SQLException {
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
}

