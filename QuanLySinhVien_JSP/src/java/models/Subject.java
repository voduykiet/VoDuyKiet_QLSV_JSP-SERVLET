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
public class Subject {

    private String id_subject;
    private String name_subject;
    private String id_credit;
    private String id_category;

    public Subject() {
    }

    public Subject(String id_subject, String name_subject, String id_credit, String id_category) {
        this.id_subject = id_subject;
        this.name_subject = name_subject;
        this.id_credit = id_credit;
        this.id_category = id_category;
    }

    public String getId_subject() {
        return id_subject;
    }

    public void setId_subject(String id_subject) {
        this.id_subject = id_subject;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
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

    @Override
    public String toString() {
        return "Subject{" + "id_subject=" + id_subject + ", name_subject=" + name_subject + ", id_credit=" + id_credit + ", id_category=" + id_category + '}';
    }

}
