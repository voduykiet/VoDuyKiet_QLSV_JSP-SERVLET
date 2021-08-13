/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Connect_DAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/quanlysinhvien_jsp?useUnicode=yes&characterEncoding=UTF-8";
    Connection conn = null;

    public  Connect_DAO() throws SQLException {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.getMessage();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }
}
