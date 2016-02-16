package com.heren.log4mnis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/12
 */
public class DbUtils {

    static Connection connection = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection openDb() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:resources/mnistest.db");
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
