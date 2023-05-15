/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * a class to define the user account that has the basic features
 */
public class user_acc extends account {

    public user_acc(String name, int phone_num, String email,
            String password, String address, int loy_pts) {
        super(name, phone_num, email, password, address, loy_pts);
    }
        
    public void save_user(){
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
            Connection con = DriverManager.getConnection(url, "sa","123");
            JOptionPane.showMessageDialog(null, "connection Established");
            Statement smt = con.createStatement();
            smt.executeUpdate("insert into user_acc values('"+ this.email +"','"+
                this.name +"','"+ this.phone_num +"','"+ this.password
                    +"','"+ this.address +"','"+ this.loy_pts +"')");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public String get_email() {
        return email;
    }
}
