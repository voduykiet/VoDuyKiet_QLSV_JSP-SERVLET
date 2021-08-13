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
import models.Lecturer;

/**
 *
 * @author DELL
 */
public class Lecturer_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Lecturer> loadLecturer() {
        ArrayList<Lecturer> list = new ArrayList<>();
        String query = "select * from lecturer ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecturer c = new Lecturer();
                c.setId_lecturer(rs.getString("id_lecturer"));
                c.setName_lecturer(rs.getString("name_lecturer"));
                c.setBirthday(rs.getString("birthday"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setAddress(rs.getString("address"));
                list.add(c);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Lecturer checkId(String id_lecturer) {
        String query = "select * from lecturer where id_lecturer = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_lecturer);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Lecturer(rs.getString("id_lecturer"), rs.getString("name_lecturer"),
                        rs.getString("birthday"), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addLecturer(Lecturer lec) {
        String query = "insert into lecturer(id_lecturer,name_lecturer,birthday,email,phone"
                + ",address) values(?,?,?,?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, lec.getId_lecturer());
            ps.setString(2, lec.getName_lecturer());
            ps.setString(3, lec.getBirthday());
            ps.setString(4, lec.getEmail());
            ps.setString(5, lec.getPhone());
            ps.setString(6, lec.getAddress());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean updateLecturer(String name_lecturer, String birthday, String email, String phone,
            String address, String id_lecturer) {
        String query = "update lecturer set name_lecturer=?,birthday=?,email=?,phone=?,"
                + "address=? WHERE id_lecturer=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_lecturer);
            ps.setString(2, birthday);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, id_lecturer);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteLecturer(String id_lecturer) {
        String query = "delete from lecturer where id_lecturer = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_lecturer);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
