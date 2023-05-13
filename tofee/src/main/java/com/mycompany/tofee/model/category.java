/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;
import java.sql.*;

import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * a class used to define the category and what it can holds
 */
public class category {
    
    private String name;
    private int c_id;
    static int counter_id;

    public category(String nam) {
        this.name = name;
        this.c_id = ++counter_id;
    }
    
    public void save_category(){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(url, "sa","123");
        JOptionPane.showMessageDialog(null, "connection Established");
        Statement smt = con.createStatement();
        smt.executeUpdate("insert into orders values('"+ this.name +"','"+
            this.c_id +"')");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }    
}
