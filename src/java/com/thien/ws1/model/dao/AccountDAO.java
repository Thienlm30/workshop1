/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ws1.model.dao;

import com.thien.ws1.model.dto.Account;
import com.thien.ws1.utilities.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 * 
 * @author Thienlm30
 */
public class AccountDAO implements Accessible<Account>{
    
    
    private Connection connection = null;

    public AccountDAO() {
        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.getConnection();
    }

    public AccountDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        connection = connectDB.getConnection();
    }
    
    public Map<String, Account> getAccount() {
        Map<String, Account> map = new HashMap<>();
        //connection = null;
        try {
            
//            connection = connectDB.getConnection();
            if (connection != null) {
                String sql = "select account, pass, lastName, firstName, \n"
                    + "birthday, gender, phone, isUse, roleInSystem \n"
                    + "from accounts";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while(rs.next()) {
                        String account = rs.getString("account");
                        String pass = rs.getString("pass");
                        String lastName = rs.getString("lastName");
                        String firstName = rs.getString("firstName");
                        Date birthday = rs.getDate("birthday");
                        boolean gender = rs.getBoolean("gender");
                        String phone = rs.getString("phone");
                        boolean isUse = rs.getBoolean("isUse");
                        int roleInSystem = rs.getInt("roleInSystem");
                        Account acc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
                        map.put(account, acc);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public int insertRec(Account obj) {
        
        return 0;
    }

    @Override
    public int updateRec(Account obj) {
        
        return 0;
    }

    @Override
    public int deleteRec(Account obj) {
        
        return 0;
    }

    @Override
    public Account getObjectById(String id) {
        
        return null;
    }

    @Override
    public Map<?, Account> listAll() {
        
        return null;
    }

    
    
}
