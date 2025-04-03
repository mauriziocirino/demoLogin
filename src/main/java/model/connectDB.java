package model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {
    private static DataSource dataSource;
    static {
        // Configurazione del pool di connessioni
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl("jdbc:mysql://127.0.0.1:3306/crochetique");
        poolProperties.setUsername("root");
        poolProperties.setPassword("root");
        poolProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        poolProperties.setMaxActive(10); // Numero massimo di connessioni attive
        poolProperties.setInitialSize(5); // Numero iniziale di connessioni
        poolProperties.setMaxIdle(5);
        poolProperties.setMinIdle(2);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");

        dataSource = new DataSource();
        dataSource.setPoolProperties(poolProperties);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void printUsers() {
        String query = "SELECT * FROM users";
        System.out.println("ciao come");
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
