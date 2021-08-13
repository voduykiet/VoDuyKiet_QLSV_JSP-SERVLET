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
import models.Subject_Lecturer;

/**
 *
 * @author DELL
 */
public class Lecturer_Subject_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Subject_Lecturer> loadSubject_Lecturer() {
        ArrayList<Subject_Lecturer> list = new ArrayList<>();
        String query = "Select * "
                + "from subject s "
                + "join subject_lecturer s1 on s.id_subject=s1.id_subject "
                + "join lecturer l on s1.id_lecturer = l.id_lecturer ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject_Lecturer s = new Subject_Lecturer();
                s.setId_subject(rs.getString("id_subject"));
                s.setName_subject(rs.getString("name_subject"));
                s.setId_lecturer(rs.getString("id_lecturer"));
                s.setName_lecturer(rs.getString("name_lecturer"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Subject_Lecturer checkId(String id_lecturer, String id_subject) {
        String query = "select * from subject s"
                + " join subject_lecturer s1 on s.id_subject=s1.id_subject"
                + " join lecturer l on s1.id_lecturer = l.id_lecturer  where id_lecturer =? and id_subject=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_lecturer);
            ps.setString(2, id_subject);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Subject_Lecturer(rs.getString("id_subject"), rs.getString("name_subject"),
                        rs.getString("id_lecturer"), rs.getString("name_lecturer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addSubject_Lecturer(Subject_Lecturer s) {
        String query = "insert into subject_lecturer(id_subject,id_lecturer) values(?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_subject());
            ps.setString(2, s.getId_lecturer());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSubject_Lecturer(String id_subject, String id_lecturer) {
        String query = "update subject_lecturer set id_subject=? WHERE id_lecturer=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_subject);
            ps.setString(2, id_lecturer);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSubject_Lecturer(String id_lecturer, String id_subject) {
        String query = "delete from subject_lecturer where id_subject=? and id_lecturer = ? ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(2, id_lecturer);
            ps.setString(1, id_subject);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
