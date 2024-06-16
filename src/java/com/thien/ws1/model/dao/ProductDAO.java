/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ws1.model.dao;

import com.thien.ws1.utilities.ConnectDB;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 *
 * @author Thienlm30
 */
public class ProductDAO {
    
    Connection connection = null;
    
    public ProductDAO() {
       ConnectDB connectDB = new ConnectDB();
       this.connection = connectDB.getConnection();
    }
    
    public ProductDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        this.connection = connectDB.getConnection();        
    }
    
    
    
}
