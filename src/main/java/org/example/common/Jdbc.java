package org.example.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Jdbc {
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    private Jdbc() {
    }

    static {
        DATA_SOURCE.setUrl("jdbc:oracle:thin:@//avdf01.rh:2019/rayannav21c.rh");
        DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        DATA_SOURCE.setUsername("n12krp209");
        DATA_SOURCE.setPassword("n");
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
