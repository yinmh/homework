package org.ymh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public int regist(String username,String password,String sex,String nickName) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "insert into user(username,password,sex,nickname) values(?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,username);
        pstm.setString(2,password);
        pstm.setString(3,sex);
        pstm.setString(4,nickName);
        int rows = pstm.executeUpdate();
        return rows;
    }
}
