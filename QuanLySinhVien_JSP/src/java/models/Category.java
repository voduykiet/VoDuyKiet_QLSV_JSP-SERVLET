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
public class Category {
    private String id_category;
    private String name_category;

    public Category() {
    }

    public Category(String id_category, String name_category) {
        this.id_category = id_category;
        this.name_category = name_category;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    @Override
    public String toString() {
        return "Category{" + "id_category=" + id_category + ", name_category=" + name_category + '}';
    }
    
    
}
