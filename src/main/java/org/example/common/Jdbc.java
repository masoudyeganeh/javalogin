package org.example.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Jdbc {
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    private Jdbc() {
    }

    static {
        DATA_SOURCE.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
        DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        DATA_SOURCE.setUsername("masoud");
        DATA_SOURCE.setPassword("1234");
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
