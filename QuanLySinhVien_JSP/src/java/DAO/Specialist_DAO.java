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
import models.Specialist;

/**
 *
 * @author DELL
 */
public class Specialist_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Specialist> loadSpecialist() {
        ArrayList<Specialist> list = new ArrayList<>();
        String query = "select * from specialist ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Specialist s = new Specialist();
                s.setId_specialist(rs.getString("id_specialist"));
                s.setName_specialist(rs.getString("name_specialist"));
                s.setContact_specialist(rs.getString("contact_specialist"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Specialist checkId(String id_specialist) {
        String query = "select * from specialist where id_specialist = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_specialist);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Specialist(rs.getString("id_specialist"), rs.getString("name_specialist"), rs.getString("contact_specialist"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addSpecialist(Specialist s) {
        String query = "insert into specialist(id_specialist,name_specialist,contact_specialist) values(?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_specialist());
            ps.setString(2, s.getName_specialist());
            ps.setString(3, s.getContact_specialist());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSpecialist(String id_specialist, String name_specialist, String contact_specialist) {
        String query = "update specialist set name_specialist=?,contact_specialist=? where id_specialist=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_specialist);
            ps.setString(2, contact_specialist);
            ps.setString(3, id_specialist);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSpecialist(String id_specialists) {
        String query = "delete from specialist where id_specialist = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_specialists);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
