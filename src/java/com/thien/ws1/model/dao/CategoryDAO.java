/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ws1.model.dao;

import com.thien.ws1.model.dto.Category;
import com.thien.ws1.utilities.ConnectDB;
import java.sql.Connection;
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
        connection = connectDB.getConnection();
    }

    public CategoryDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        connection = connectDB.getConnection();
    }
    
    public Map<Integer, Category> getCategory() {
        
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
        
    }

    @Override
    public Map<?, Category> listAll() {
        
    }
    
    
    
    
    
}
