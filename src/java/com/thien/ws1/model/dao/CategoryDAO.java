/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ws1.model.dao;

import com.thien.ws1.model.dto.Category;
import com.thien.ws1.utilities.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 *
 * @author Thienlm30
 */
public class CategoryDAO implements Accessible<Category> {
    private Connection connection = null;

    public CategoryDAO() {
        ConnectDB connectDB = new ConnectDB();
        this.connection = connectDB.getConnection();
    }

    public CategoryDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        this.connection = connectDB.getConnection();
    }

    @Override
    public int insertRec(Category obj) {
        
    }

    @Override
    public int updateRec(Category obj) {
        
    }

    @Override
    public int deleteRec(Category obj) {
        
    }

    @Override
    public Category getObjectById(String id) {
        int typeId = Integer.parseInt(id);
        Category c = null;
        try {
            if (connection != null) {
                String sql = "SELECT [typeId], [categoryName], [memo]\n"
                        + "FROM [dbo].[categories] WHERE [typeId] = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, typeId);
                ResultSet rs = pst.executeQuery();
                if (rs != null & rs.next()) {
                    String name = rs.getString("categoryName");
                    String memo = rs.getString("memo");
                    c = new Category(typeId, name, memo);
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    @Override
    public Map<Integer, Category> listAll() {
        Map<Integer, Category> map = new HashMap<>();
        try {
            if (connection != null) {
                String sql = "SELECT [typeId], [categoryName], [memo]\n"
                        + "FROM [dbo].[categories]";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        Integer id = rs.getInt("typeId");
                        String name = rs.getString("categoryName");
                        String memo = rs.getString("memo");
                        Category c = new Category(id, name, memo);
                        map.put(id, c);
                    }
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    
    
    
    
    
}
