/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import models.Category;

/**
 *
 * @author DELL
 */
public class Category_DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Category> loadCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String query = "select * from category ";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId_category(rs.getString("id_category"));
                c.setName_category(rs.getString("name_category"));
                list.add(c);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Category checkId(String id_category) {
        String query = "select * from category where id_category = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_category);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getString("id_category"), rs.getString("name_category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCategory(Category c) {
        String query = "insert into category(id_category,name_category) values(?,?)";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, c.getId_category());
            ps.setString(2, c.getName_category());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCategory(String id_category, String name_category) {
        String query = "update category set name_category=? where id_category=?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, name_category);
            ps.setString(2, id_category);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCategory(String id_category) {
        String query = "delete from category where id_category = ?";
        try {
            ps = new Connect_DAO().conn.prepareStatement(query);
            ps.setString(1, id_category);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
