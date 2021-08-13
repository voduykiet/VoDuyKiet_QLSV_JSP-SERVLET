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
public class Classroom {

    private String id_class;
    private String name_class;
    private String id_specialist;

    public Classroom() {
    }

    public Classroom(String id_class, String name_class, String id_specialist) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.id_specialist = id_specialist;
    }

    public String getId_class() {
        return id_class;
    }

    public void setId_class(String id_class) {
        this.id_class = id_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public String getId_specialist() {
        return id_specialist;
    }

    public void setId_specialist(String id_specialist) {
        this.id_specialist = id_specialist;
    }

}
