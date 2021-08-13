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
public class Credit {

    private String id_credit;
    private int number_credit;

    public Credit() {
    }

    public Credit(String id_credit, int number_credit) {
        this.id_credit = id_credit;
        this.number_credit = number_credit;
    }

    public String getId_credit() {
        return id_credit;
    }

    public void setId_credit(String id_credit) {
        this.id_credit = id_credit;
    }

    public int getNumber_credit() {
        return number_credit;
    }

    public void setNumber_credit(int number_credit) {
        this.number_credit = number_credit;
    }

    @Override
    public String toString() {
        return "Credit{" + "id_credit=" + id_credit + ", number_credit=" + number_credit + '}';
    }
    
    

}
