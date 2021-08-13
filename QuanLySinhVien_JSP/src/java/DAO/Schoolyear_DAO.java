/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.School_year;

/**
 *
 * @author DELL
 */
public class Schoolyear_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<School_year> loadSchoolYear() {
        ArrayList<School_year> list = new ArrayList<>();
        String query = "select * from school_year ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                School_year s = new School_year();
                s.setId_school_year(rs.getString("id_school_year"));
                s.setName_school_year(rs.getString("name_school_year"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public School_year checkId(String id_school_year){
        String query = "select * from school_year where id_school_year = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_school_year);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new School_year(rs.getString("id_school_year"), rs.getString("name_school_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    

    

    public boolean addSchoolYear(School_year s) {
        String query = "insert into school_year(id_school_year,name_school_year) values(?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_school_year());
            ps.setString(2, s.getName_school_year());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSchoolYear(String id_school_year, String name_school_year) {
        String query = "update school_year set name_school_year=? where id_school_year=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_school_year);
            ps.setString(2, id_school_year);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSchoolYear(String id_school_year) {
        String query = "delete from school_year where id_school_year = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_school_year);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
