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
public class Lecturer {

    private String id_lecturer;
    private String name_lecturer;
    private String birthday;
    private String email;
    private String phone;
    private String address;

    public Lecturer() {
    }

    public Lecturer(String id_lecturer, String name_lecturer, String birthday, String email, String phone, String address) {
        this.id_lecturer = id_lecturer;
        this.name_lecturer = name_lecturer;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId_lecturer() {
        return id_lecturer;
    }

    public void setId_lecturer(String id_lecturer) {
        this.id_lecturer = id_lecturer;
    }

    public String getName_lecturer() {
        return name_lecturer;
    }

    public void setName_lecturer(String name_lecturer) {
        this.name_lecturer = name_lecturer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "id_lecturer=" + id_lecturer + ", name_lecturer=" + name_lecturer + ", birthday=" + birthday + ", email=" + email + ", phone=" + phone + ", address=" + address + ", id_account=" + '}';
    }

}
