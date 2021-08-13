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
import models.Semester;
import models.Specialist;

/**
 *
 * @author DELL
 */
public class Semester_DAO {
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Semester> loadSemester() {
        ArrayList<Semester> list = new ArrayList<>();
        String query = "select * from semester ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Semester s = new Semester();
                s.setId_semester(rs.getString("id_semester"));
                s.setName_semester(rs.getString("name_semester"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Semester checkId(String id_semester) {
        String query = "select * from semester where id_semester = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_semester);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Semester(rs.getString("id_semester"), rs.getString("name_semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addSemester(Semester s) {
        String query = "insert into semester(id_semester,name_semester) values(?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_semester());
            ps.setString(2, s.getName_semester());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSemester(String id_semester, String name_semester) {
        String query = "update semester set name_semester=?where id_semester=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_semester);
            ps.setString(2, id_semester);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSemester(String id_semester) {
        String query = "delete from semester where id_semester = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_semester);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
