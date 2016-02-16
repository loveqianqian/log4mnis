package com.heren.log4mnis.sqlite;

import com.heren.log4mnis.util.DbUtils;

import java.sql.*;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:test for sqlite3</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/5
 */
public class SqliteAddTest {
    public static void main(String[] args) {
        String sql = "INSERT INTO emp(id,name,dept_no) VALUES (?,?,?)";
        try {
            Connection connection = DbUtils.openDb();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,"Mrs.Shi");
            preparedStatement.setInt(3,1);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            DbUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
