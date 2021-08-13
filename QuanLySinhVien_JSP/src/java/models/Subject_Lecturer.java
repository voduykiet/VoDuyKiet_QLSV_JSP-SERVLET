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
public class Subject_Lecturer {
    private String id_subject;
    private String name_subject;
    private String id_lecturer;
    private String name_lecturer;

    public Subject_Lecturer() {
    }

    public Subject_Lecturer(String id_subject, String id_lecturer) {
        this.id_subject = id_subject;
        this.id_lecturer = id_lecturer;
    }

    
    
    public Subject_Lecturer(String id_subject, String name_subject, String id_lecturer, String name_lecturer) {
        this.id_subject = id_subject;
        this.name_subject = name_subject;
        this.id_lecturer = id_lecturer;
        this.name_lecturer = name_lecturer;
    }

    

    public String getId_subject() {
        return id_subject;
    }

    public void setId_subject(String id_subject) {
        this.id_subject = id_subject;
    }

    public String getId_lecturer() {
        return id_lecturer;
    }

    public void setId_lecturer(String id_lecturer) {
        this.id_lecturer = id_lecturer;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public String getName_lecturer() {
        return name_lecturer;
    }

    public void setName_lecturer(String name_lecturer) {
        this.name_lecturer = name_lecturer;
    }

    @Override
    public String toString() {
        return "Subject_Lecturer{" + "id_subject=" + id_subject + ", id_lecturer=" + id_lecturer + '}';
    }
    
    
}
