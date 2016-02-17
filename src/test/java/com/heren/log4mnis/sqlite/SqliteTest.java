package com.heren.log4mnis.sqlite;

import java.sql.*;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:test for sqlite3</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/5
 */
public class SqliteTest {
    public static void main(String[] args) {
        String sql = "SELECT emp.id emp_id," +
                "  emp.name emp_name," +
                "  dept.id dept_id," +
                "  dept.name dept_name " +
                "FROM emp, dept " +
                "WHERE emp.dept_no = dept.id;";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\sqlite3Db\\mnistest.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int emp_id = resultSet.getInt("emp_id");
                String emp_name = resultSet.getString("emp_name");
                int dept_id = resultSet.getInt("dept_id");
                String dept_name = resultSet.getString("dept_name");
                System.out.println(emp_id + ":" + emp_name + ":" + dept_id + ":" + dept_name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
