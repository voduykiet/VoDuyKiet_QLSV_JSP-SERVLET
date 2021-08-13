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
import models.Subject;

/**
 *
 * @author DELL
 */
public class Subject_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Subject> loadSubject() {
        ArrayList<Subject> list = new ArrayList<>();
        String query = "select id_subject,name_subject,number_credit,name_category "
                + "from subject s "
                + "join credit c on (s.id_credit = c.id_credit) "
                + "join category ca on (s.id_category = ca.id_category)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId_subject(rs.getString("id_subject"));
                s.setName_subject(rs.getString("name_subject"));
                s.setId_credit(rs.getString("number_credit"));
                s.setId_category(rs.getString("name_category"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Subject checkId(String id_subject) {
        String query = "select * from subject where id_subject = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_subject);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Subject(rs.getString("id_subject"), rs.getString("name_subject"),
                        rs.getString("id_credit"), rs.getString("id_category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addSubject(Subject s) {
        String query = "insert into subject(id_subject,name_subject,id_credit,id_category) values(?,?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_subject());
            ps.setString(2, s.getName_subject());
            ps.setString(3, s.getId_credit());
            ps.setString(4, s.getId_category());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSubject(String id_subject, String name_subject, String id_credit, String id_category) {
        String query = "update subject set name_subject=?,id_credit=?,id_category=? where id_subject=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_subject);
            ps.setString(2, id_credit);
            ps.setString(3, id_category);
            ps.setString(4, id_subject);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSubject(String id_subject) {
        String query = "delete from subject where id_subject = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_subject);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
