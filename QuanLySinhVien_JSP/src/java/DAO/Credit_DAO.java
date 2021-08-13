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
import models.Credit;

/**
 *
 * @author DELL
 */
public class Credit_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Credit> loadCredit() {
        ArrayList<Credit> list = new ArrayList<>();
        String query = "select * from credit ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Credit c = new Credit();
                c.setId_credit(rs.getString("id_credit"));
                c.setNumber_credit(rs.getInt("number_credit"));
                list.add(c);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }


    public Credit checkId(String id_credit) {
        String query = "select * from credit where id_credit = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_credit);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Credit(rs.getString("id_credit"), rs.getInt("number_credit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCredit(Credit c) {
        String query = "insert into credit(id_credit,number_credit) values(?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, c.getId_credit());
            ps.setInt(2, c.getNumber_credit());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCredit(String id_credit, int number_credit) {
        String query = "update credit set number_credit=? where id_credit=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setInt(1, number_credit);
            ps.setString(2, id_credit);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCredit(String id_credit) {
        String query = "delete from credit where id_credit = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_credit);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
