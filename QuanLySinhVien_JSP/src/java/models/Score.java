/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL
 */
public class Score {
    private String id_score;
    private float score_1;
    private float score_4;
    private float score_test;
    private float avg_score;
    private String id_lecturer;
    private String id_student;
    private String id_subject;
    private String id_credit;
    private String id_category;
    private String id_semester;
    private String id_school_year;

    public Score() {
    }

    public Score(String id_score, float score_1, float score_4, float score_test, float avg_score, String id_lecturer, String id_student, String id_subject, String id_credit, String id_category, String id_semester, String id_school_year) {
        this.id_score = id_score;
        this.score_1 = score_1;
        this.score_4 = score_4;
        this.score_test = score_test;
        this.avg_score = avg_score;
        this.id_lecturer = id_lecturer;
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.id_credit = id_credit;
        this.id_category = id_category;
        this.id_semester = id_semester;
        this.id_school_year = id_school_year;
    }

    public String getId_score() {
        return id_score;
    }

    public void setId_score(String id_score) {
        this.id_score = id_score;
    }

    public float getScore_1() {
        return score_1;
    }

    public void setScore_1(float score_1) {
        this.score_1 = score_1;
    }

    public float getScore_4() {
        return score_4;
    }

    public void setScore_4(float score_4) {
        this.score_4 = score_4;
    }

    public float getScore_test() {
        return score_test;
    }

    public void setScore_test(float score_test) {
        this.score_test = score_test;
    }

    public float getAvg_score() {
        return avg_score;
    }

    public void setAvg_score(float avg_score) {
        this.avg_score = avg_score;
    }

    public String getId_lecturer() {
        return id_lecturer;
    }

    public void setId_lecturer(String id_lecturer) {
        this.id_lecturer = id_lecturer;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getId_subject() {
        return id_subject;
    }

    public void setId_subject(String id_subject) {
        this.id_subject = id_subject;
    }

    public String getId_credit() {
        return id_credit;
    }

    public void setId_credit(String id_credit) {
        this.id_credit = id_credit;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getId_semester() {
        return id_semester;
    }

    public void setId_semester(String id_semester) {
        this.id_semester = id_semester;
    }

    public String getId_school_year() {
        return id_school_year;
    }

    public void setId_school_year(String id_school_year) {
        this.id_school_year = id_school_year;
    }

    @Override
    public String toString() {
        return "Score{" + "id_score=" + id_score + ", score_1=" + score_1 + ", score_4=" + score_4 + ", score_test=" + score_test + ", avg_score=" + avg_score + ", id_lecturer=" + id_lecturer + ", id_student=" + id_student + ", id_subject=" + id_subject + ", id_credit=" + id_credit + ", id_category=" + id_category + ", id_semester=" + id_semester + ", id_school_year=" + id_school_year + '}';
    }
    
    
}
