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
public class Account {
    private String id_account;
    private String username;
    private String password;
    private int role_sv;
    private int role_lecturer;
    private int role_admin;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public Account(String id_account, String username, String password, int role_sv, int role_lecturer, int role_admin) {
        this.id_account = id_account;
        this.username = username;
        this.password = password;
        this.role_sv = role_sv;
        this.role_lecturer = role_lecturer;
        this.role_admin = role_admin;
    }

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_sv() {
        return role_sv;
    }

    public void setRole_sv(int role_sv) {
        this.role_sv = role_sv;
    }

    public int getRole_lecturer() {
        return role_lecturer;
    }

    public void setRole_lecturer(int role_lecturer) {
        this.role_lecturer = role_lecturer;
    }

    public int getRole_admin() {
        return role_admin;
    }

    public void setRole_admin(int role_admin) {
        this.role_admin = role_admin;
    }
    
    
    
}
