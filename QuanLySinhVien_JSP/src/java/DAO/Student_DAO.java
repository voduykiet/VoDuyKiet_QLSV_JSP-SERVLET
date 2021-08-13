/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Student;

/**
 *
 * @author DELL
 */
public class Student_DAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Student> loadStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String query = "select * from student";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId_student(rs.getString("id_student"));
                s.setFullname(rs.getString("fullname"));
                s.setBirthday(rs.getString("birthday"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("address"));
                s.setId_class(rs.getString("id_class"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Student checkId(String id_student) {
        String query = "select * from student where id_student = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_student);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getString("id_student"), rs.getString("fullname"),
                        rs.getString("birthday"), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("id_class"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addStudent(Student s) {
        String query = "insert into student(id_student,fullname,birthday,email,phone"
                + ",address,id_class) values(?,?,?,?,?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_student());
            ps.setString(2, s.getFullname());
            ps.setString(3, s.getBirthday());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getAddress());
            ps.setString(7, s.getId_class());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(String fullname, String birthday, String email, String phone,
            String address, String id_class, String id_student) {
        String query = "update student set fullname=?,birthday=?,email=?,phone=?,"
                + "address=?,id_class=? WHERE id_student=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, birthday);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, id_class);
            ps.setString(7, id_student);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(String id_student) {
        String query = "delete from student where id_student = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_student);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
