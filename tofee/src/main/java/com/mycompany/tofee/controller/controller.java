/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.controller;
import com.mycompany.tofee.view.view;

/**
 * A class responsible for controlling the flow of the program and responds user's input and send data
 *  to model layer to save or modify it or send it to view layer to view it
 * 
 */
import com.mycompany.tofee.model.*;
import com.mycompany.tofee.model.order.state;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import com.mycompany.tofee.view.*;
import javax.swing.JOptionPane;


public class controller {
    user_acc current_user;
    private view v;
    private Statement smt;
    Scanner scan;

    public controller(view v, Statement smt, Scanner scan) throws ClassNotFoundException, SQLException {
        this.v = v;
        this.smt = smt;
        this.scan = scan;

    }

    private void view_categories() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tofee;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(url, "sa","123");
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery("select * from items");
        while (rs.next()) {
            v.view_items(rs.getInt("it_id"), rs.getString("n_ame"), rs.getString("d_escription"), rs.getString("brand"),
                    rs.getFloat("price"), rs.getFloat("d_iscount_percent"), rs.getInt("quantity"));
        }
    }

    private void register() throws Exception {

        System.out.print("enter email: ");
        this.scan.nextLine();
        String mail = this.scan.nextLine();
        // check database if ID exists before
        ResultSet rs = this.smt.executeQuery("select email from user_acc where email= " +"'" + mail +"'");
        if (rs.next()) {
            System.out.print("this email is Used befor");
            return;
        }

        // if not continue registeration
        System.out.print("enter password:");
        String pass = this.scan.nextLine();
        System.out.print("enter phone number:");
        int phone = this.scan.nextInt();
        this.scan.nextLine();
        System.out.print("enter Name: ");
        String Name = this.scan.nextLine();
        System.out.print("enter Address: ");
        String add = this.scan.nextLine();
        user_acc account = new user_acc(Name, phone, mail, pass, add, 0);
        account.save_user();
        System.out.println("Register completed");
    }

    private user_acc login() throws Exception {

        // take ID and pass from the user
        System.out.print("enter email: ");
        this.scan.nextLine();
        String mail = this.scan.nextLine();
        System.out.print("enter password:");
        String pass = this.scan.nextLine();

        // check database for valid ID and pass and if yes

        ResultSet rs = this.smt
                .executeQuery("select * from user_acc where email= " + "'" + mail + "'" + " and password= " + "'" + pass +"'");
        if (rs.next()) {
            System.out.println("login succsseful");
            user_acc a = new user_acc(rs.getString("name"), rs.getInt("phone_num"),
                    rs.getString("email"), rs.getString("password"), rs.getString("address"), rs.getInt("loy_pts"));
            return a;

        } else {
            System.out.print("Invalid ID or password");
            return null;
        }
    }

    private HashMap<Integer, Integer> make_order(HashMap<Integer, Integer> cart) throws Exception {
        view_categories();
        int input;

        while (true) {
            v.makeOrder_menu();
            input = this.scan.nextInt();

            switch (input) {
                case 1:
                    System.out.print("item: ");
                    
                    int choice = this.scan.nextInt();
                    this.scan.nextLine();
                    System.out.print("Enter Quantity: ");
                    int q = this.scan.nextInt();
                    ResultSet rs = this.smt.executeQuery("select quantity as q from items where it_id= " +"'" + choice +"'");
                    rs.next();
                    int result = rs.getInt(1);
                    if (q <= result) {
                        cart.put(choice, q);
                    } else {
                        System.out.println("there is not enough quantity.. ");
                    }
                    break;
                case 2:
                    return cart;

                default:
                    return cart;

            }
        }
    }

    private void save_order(HashMap<Integer, Integer> C) throws ClassNotFoundException, SQLException {

        order o = new order(current_user.get_email(), state.placed, C, smt);
        o.save_order();
        o.save_m_order();
    }

    private void user_menu() throws Exception {
        int in;
        HashMap<Integer, Integer> shopp_cart = new HashMap<Integer, Integer>();
        while (true) {
            v.user_menu();
            in = this.scan.nextInt();
            if (in == 1) {
                shopp_cart = make_order(shopp_cart);
            } else if (in == 2) {
                save_order(shopp_cart);
            } else if (in == 3) {
                view_categories();
            } else {
                return;
            }
        }
    }

    public void flow() throws Exception {
        System.out.println("welcome");
        int input;
        while (true) {
            v.main_menu();
            input = this.scan.nextInt();

            switch (input) {
                case 1:
                    register();
                    break;
                case 2:
                    current_user = login();
                    if(current_user != null){
                        user_menu();}
                    break;
                case 3:
                    view_categories();
                    break;
                case 4:
                    scan.close();
                    return;
            }

        }

    }
}
