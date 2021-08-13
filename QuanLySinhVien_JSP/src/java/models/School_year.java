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
public class School_year {
    private String id_school_year;
    private String name_school_year;

    public School_year() {
    }

    public School_year(String id_school_year, String name_school_year) {
        this.id_school_year = id_school_year;
        this.name_school_year = name_school_year;
    }

    public String getId_school_year() {
        return id_school_year;
    }

    public void setId_school_year(String id_school_year) {
        this.id_school_year = id_school_year;
    }

    public String getName_school_year() {
        return name_school_year;
    }

    public void setName_school_year(String name_school_year) {
        this.name_school_year = name_school_year;
    }
    
    
}
