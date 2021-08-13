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
public class Semester {
    private String id_semester;
    private String name_semester;

    public Semester() {
    }

    public Semester(String id_semester, String name_semester) {
        this.id_semester = id_semester;
        this.name_semester = name_semester;
    }

    public String getId_semester() {
        return id_semester;
    }

    public void setId_semester(String id_semester) {
        this.id_semester = id_semester;
    }

    public String getName_semester() {
        return name_semester;
    }

    public void setName_semester(String name_semester) {
        this.name_semester = name_semester;
    }
    
    
}
