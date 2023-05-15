/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * 
 */
package com.mycompany.tofee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * a class responsible for making and storing orders
 */
public class order {
    private int order_id;
    private Statement smt;
    private String email;
    private state state1;

    public enum state {
        cancelled, placed, accepted, shipped, done
    };

    private payment pay = new cash_pay();
    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    private HashMap<Integer, Integer> cart;

    public order(String email, state s1, HashMap<Integer, Integer> cart, Statement smt)
            throws ClassNotFoundException, SQLException {
        this.smt = smt;
        String sql = "SELECT MAX(order_id) as res from orders";
        ResultSet rs = this.smt.executeQuery(sql);
        if (rs.next()) {
            this.order_id = rs.getInt("res") + 1;
        } else {
            this.order_id = 1;
        }
        this.email = email;
        this.state1 = s1;
        this.cart = cart;
    }

    public void save_order() {
        try {
            this.smt.executeUpdate("insert into orders(order_id, e_mail, s_tate) values('" + this.order_id + "','" +
                    this.email + "','" + this.state1.ordinal() + "')");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void save_m_order() {
        try {
            for (Map.Entry<Integer, Integer> i : this.cart.entrySet()) {
                this.smt.executeUpdate("insert into m_order values('" + i.getKey() + "','" + this.order_id + "','" +
                        i.getValue() + "')");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
