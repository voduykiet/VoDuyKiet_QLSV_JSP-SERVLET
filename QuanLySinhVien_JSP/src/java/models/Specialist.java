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
public class Specialist {
    private String id_specialist;
    private String name_specialist;
    private String contact_specialist;

    public Specialist() {
    }

    public Specialist(String id_specialist, String name_specialist, String contact_specialist) {
        this.id_specialist = id_specialist;
        this.name_specialist = name_specialist;
        this.contact_specialist = contact_specialist;
    }

    public String getId_specialist() {
        return id_specialist;
    }

    public void setId_specialist(String id_specialist) {
        this.id_specialist = id_specialist;
    }

    public String getName_specialist() {
        return name_specialist;
    }

    public void setName_specialist(String name_specialist) {
        this.name_specialist = name_specialist;
    }

    public String getContact_specialist() {
        return contact_specialist;
    }

    public void setContact_specialist(String contact_specialist) {
        this.contact_specialist = contact_specialist;
    }
    
    
}
