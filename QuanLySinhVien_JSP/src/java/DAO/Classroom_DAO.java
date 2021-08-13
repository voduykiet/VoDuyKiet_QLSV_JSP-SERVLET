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
import models.Classroom;

/**
 *
 * @author DELL
 */
public class Classroom_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Classroom> loadClassroom() {
        ArrayList<Classroom> list = new ArrayList<>();
        String query = "select *,name_specialist from class natural join specialist ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Classroom c = new Classroom();
                c.setId_class(rs.getString("id_class"));
                c.setName_class(rs.getString("name_class"));
                c.setId_specialist(rs.getString("name_specialist"));
                list.add(c);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Classroom checkId(String id_class) {
        String query = "select * from class where id_class = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_class);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Classroom(rs.getString("id_class"), rs.getString("name_class"), rs.getString("id_specialist"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addClassroom(Classroom c) {
        String query = "insert into class(id_class,name_class,id_specialist) values(?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, c.getId_class());
            ps.setString(2, c.getName_class());
            ps.setString(3, c.getId_specialist());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateClassroom(String id_class, String name_class, String id_specialist) {
        String query = "update class set name_class=?,id_specialist=? where id_class=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_class);
            ps.setString(2, id_specialist);
            ps.setString(3, id_class);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteClassroom(String id_class) {
        String query = "delete from class where id_class = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_class);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
