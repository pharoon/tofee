/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.tofee;
import com.mycompany.tofee.view.view;
import com.mycompany.tofee.controller.controller;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/**
 *the main class where we can test and run the code
 * 
 */
public class Tofee {
    
    public static void main(String[] args) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(url, "sa","123");
        JOptionPane.showMessageDialog(null, "connection Established");
        Statement smt = con.createStatement();
        Scanner sc = new Scanner(System.in);
//        System.out.print("enter email: ");
//        int mail = sc.nextInt();
//        sc.close();
//        ResultSet rs = smt.executeQuery("select phone_num from user_acc where phone_num= " +"'" +mail+"'");
//        if (rs.next()) {
//            System.out.print("this ID is Used befor");
//        }else{
//            System.out.print("this ID is not Used befor");}
//
//        
//        
        try {
            view v= new view();
            controller cont = new controller(v, smt, sc);
            cont.flow();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tofee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tofee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}