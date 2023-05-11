/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

import java.util.Date;

/**
 *
 * @author mostafa
 */
public class order {
    private shopping_cart cart;
    private Date order_date;
    private String email;
    private String password;
    private enum state{
        placed, accepted, shipped, done
    }
    private payment pay;
}
