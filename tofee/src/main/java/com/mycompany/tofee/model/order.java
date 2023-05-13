/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * a class responsible for making and storing orders
 */
public class order {
    private int order_id;
    static int counterID;
    private String email;
    public enum state{
        cancelled, placed, accepted, shipped, done
    }
    private payment pay = new cash_pay();
    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    private HashMap<Integer, Integer> cart;

    public order(String email, enum state, HashMap<Integer, Integer> cart) {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(url, "sa","123");
        Statement smt = con.createStatement();
        String sql = "SELECT MAX(order_id) from tofee";
        ResultSet rs = smt.executeQuery(sql);
        if (rs.next()) {
            this.order_id = rs.getInt() + 1;
            ++counterID;
        }else{
            this.order_id = ++counterID;
        }
        this.email = email;
        this.state = state;
        this.cart = cart;
    }

    public void save_order(){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(url, "sa","123");
        JOptionPane.showMessageDialog(null, "connection Established");
        Statement smt = con.createStatement();
        smt.executeUpdate("insert into orders values('"+ this.order_id +"','"+
            this.email +"','"+ this.state.ordinal() + "')");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
        
    public void save_m_order(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
            Connection con = DriverManager.getConnection(url, "sa","123");
            JOptionPane.showMessageDialog(null, "connection Established");
            Statement smt = con.createStatement();
            for (Map.Entry<Integer, Integer> i : this.cart.entrySet()) {
                smt.executeUpdate("insert into m_order values('"+ i.getKey() +"','"+
                i.getValue() + "')");
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}


