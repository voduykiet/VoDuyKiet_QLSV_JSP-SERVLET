/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Account;

/**
 *
 * @author DELL
 */
public class Account_DAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Account> loadAccountStudent() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "select * from account where role_sv = 1";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setId_account(rs.getString("id_account"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setRole_sv(rs.getInt("role_sv"));
                a.setRole_lecturer(rs.getInt("role_lecturer"));
                a.setRole_admin(rs.getInt("role_admin"));
                list.add(a);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Account> loadAccountLecturer() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "select * from account where role_lecturer = 1";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setId_account(rs.getString("id_account"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setRole_sv(rs.getInt("role_sv"));
                a.setRole_lecturer(rs.getInt("role_lecturer"));
                a.setRole_admin(rs.getInt("role_admin"));
                list.add(a);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Account> loadAccountAdmin() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "select * from account where role_admin = 1";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setId_account(rs.getString("id_account"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setRole_sv(rs.getInt("role_sv"));
                a.setRole_lecturer(rs.getInt("role_lecturer"));
                a.setRole_admin(rs.getInt("role_admin"));
                list.add(a);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Account login(String username, String password) {
        String query = "select * from account where username = ? and password = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString("id_account"), rs.getString("username"), rs.getString("password"),
                        rs.getInt("role_sv"), rs.getInt("role_lecturer"), rs.getInt("role_admin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account checkUsername(String username) {
        String query = "select * from account where username = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString("id_account"), rs.getString("username"), rs.getString("password"),
                        rs.getInt("role_sv"), rs.getInt("role_lecturer"), rs.getInt("role_admin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account checkIdAccount(String id_account) {
        String query = "select * from account where id_account = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_account);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString("id_account"), rs.getString("username"), rs.getString("password"),
                        rs.getInt("role_sv"), rs.getInt("role_lecturer"), rs.getInt("role_admin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addAccount(Account a) {
        String query = "insert into account(id_account,username,password"
                + ",role_sv,role_lecturer,role_admin) values(?,?,?,?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, a.getId_account());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getPassword());
            ps.setInt(4, a.getRole_sv());
            ps.setInt(5, a.getRole_lecturer());
            ps.setInt(6, a.getRole_admin());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateAccount(String username, String password, String id_account) {
        String query = "update account set username =?, password = ? WHERE id_account=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, id_account);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAccount(String id_account) {
        String query = "delete from account where id_account = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_account);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
