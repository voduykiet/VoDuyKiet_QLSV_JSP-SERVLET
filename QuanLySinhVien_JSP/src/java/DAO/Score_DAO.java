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
import models.Score;

/**
 *
 * @author DELL
 */
public class Score_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Score> loadScore() {
        ArrayList<Score> list = new ArrayList<>();
        String query = "select *,name_lecturer,fullname,name_subject,number_credit,name_category,name_semester,name_school_year "
                + "from score s join lecturer lec on (s.id_lecturer = lec.id_lecturer) join student st on (s.id_student = st.id_student) join subject su on (s.id_subject = su.id_subject) join credit c on "
                + "(s.id_credit = c.id_credit) join category ca on (s.id_category = ca.id_category) join semester se "
                + "on (s.id_semester = se.id_semester) join school_year sc on (s.id_school_year = sc.id_school_year)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Score s = new Score();
                s.setId_score(rs.getString("id_score"));
                s.setScore_1(rs.getFloat("score_1"));
                s.setScore_4(rs.getFloat("score_4"));
                s.setScore_test(rs.getFloat("score_test"));
                s.setAvg_score(rs.getFloat("avg_score"));
                s.setId_lecturer(rs.getString("name_lecturer"));
                s.setId_student(rs.getString("fullname"));
                s.setId_subject(rs.getString("name_subject"));
                s.setId_credit(rs.getString("number_credit"));
                s.setId_category(rs.getString("name_category"));
                s.setId_semester(rs.getString("name_semester"));
                s.setId_school_year(rs.getString("name_school_year"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Score> loadScoreByIdStudent(String id_student) {
        ArrayList<Score> list = new ArrayList<>();
        String query = "select id_score,score_1,score_4,score_test,avg_score,name_lecturer,name_subject,number_credit,name_category,name_semester,"
                + "name_school_year from score s join lecturer lec on (s.id_lecturer = lec.id_lecturer) "
                + "join subject su on (s.id_subject = su.id_subject) join credit c on (s.id_credit = c.id_credit) "
                + "join category ca on (s.id_category = ca.id_category) join semester se on (s.id_semester = se.id_semester)"
                + " join school_year sc on (s.id_school_year = sc.id_school_year) where id_student = ? ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_student);
            rs = ps.executeQuery();
            while (rs.next()) {
                Score s = new Score();
                s.setId_score(rs.getString("id_score"));
                s.setScore_1(rs.getFloat("score_1"));
                s.setScore_4(rs.getFloat("score_4"));
                s.setScore_test(rs.getFloat("score_test"));
                s.setAvg_score(rs.getFloat("avg_score"));
                s.setId_lecturer(rs.getString("name_lecturer"));
                s.setId_subject(rs.getString("name_subject"));
                s.setId_credit(rs.getString("number_credit"));
                s.setId_category(rs.getString("name_category"));
                s.setId_semester(rs.getString("name_semester"));
                s.setId_school_year(rs.getString("name_school_year"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Score> loadScoreByIdLecturer(String id_lecturer) {
        ArrayList<Score> list = new ArrayList<>();
        String query = "select id_score,score_1,score_4,score_test,avg_score,fullname,name_subject,number_credit,name_category,name_semester,"
                + "name_school_year from score s join student st on (s.id_student = st.id_student) "
                + "join subject su on (s.id_subject = su.id_subject) join credit c on (s.id_credit = c.id_credit) "
                + "join category ca on (s.id_category = ca.id_category) join semester se on (s.id_semester = se.id_semester)"
                + " join school_year sc on (s.id_school_year = sc.id_school_year) where id_lecturer = ? ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_lecturer);
            rs = ps.executeQuery();
            while (rs.next()) {
                Score s = new Score();
                s.setId_score(rs.getString("id_score"));
                s.setScore_1(rs.getFloat("score_1"));
                s.setScore_4(rs.getFloat("score_4"));
                s.setScore_test(rs.getFloat("score_test"));
                s.setAvg_score(rs.getFloat("avg_score"));
                s.setId_student(rs.getString("fullname"));
                s.setId_subject(rs.getString("name_subject"));
                s.setId_credit(rs.getString("number_credit"));
                s.setId_category(rs.getString("name_category"));
                s.setId_semester(rs.getString("name_semester"));
                s.setId_school_year(rs.getString("name_school_year"));
                list.add(s);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Score checkId(String id_score) {
        String query = "select * from score where id_score = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_score);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Score(rs.getString("id_score"), rs.getFloat("score_1"),
                        rs.getFloat("score_4"), rs.getFloat("score_test"), rs.getFloat("avg_score"),
                        rs.getString("id_lecturer"), rs.getString("id_student"), rs.getString("id_subject"),
                        rs.getString("id_credit"), rs.getString("id_category"), rs.getString("id_semester"),
                        rs.getString("id_school_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addScore(Score s) {
        String query = "insert into score(id_score,score_1,score_4,score_test,avg_score,"
                + "id_lecturer,id_student,id_subject,id_credit,id_category,id_semester,id_school_year) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, s.getId_score());
            ps.setFloat(2, s.getScore_1());
            ps.setFloat(3, s.getScore_4());
            ps.setFloat(4, s.getScore_test());
            ps.setFloat(5, s.getAvg_score());
            ps.setString(6, s.getId_lecturer());
            ps.setString(7, s.getId_student());
            ps.setString(8, s.getId_subject());
            ps.setString(9, s.getId_credit());
            ps.setString(10, s.getId_category());
            ps.setString(11, s.getId_semester());
            ps.setString(12, s.getId_school_year());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSchoolYear(String id_score, Float score_1, Float score_4, Float score_test,
            Float avg_score, String id_lecturer, String id_student, String id_subject,
            String id_credit, String id_category, String id_semester, String id_school_year) {

        String query = "update score set score_1=?,score_4=?,score_test=?,avg_score=?"
                + ",id_lecturer=?,id_student=?,id_subject=?,id_credit=?"
                + ",id_category=?,id_semester=?,id_school_year=? where id_score=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setFloat(1, score_1);
            ps.setFloat(2, score_4);
            ps.setFloat(3, score_test);
            ps.setFloat(4, avg_score);
            ps.setString(5, id_lecturer);
            ps.setString(6, id_student);
            ps.setString(7, id_subject);
            ps.setString(8, id_credit);
            ps.setString(9, id_category);
            ps.setString(10, id_semester);
            ps.setString(11, id_school_year);
            ps.setString(12, id_score);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteScore(String id_score) {
        String query = "delete from score where id_score = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_score);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
