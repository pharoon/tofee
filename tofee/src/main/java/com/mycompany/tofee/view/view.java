/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.view;

import com.mycompany.tofee.controller.controller;

/**
 *
 * A class responsible for viewing items and anything to the user
 * 
 */
public class view {
    public void view_items(int id, String name, String des, String brand, double p, double discount, int quantity) {
        System.out.println("-------- [ " + id + " ] " + name + " --------");
        System.out.println("quantity: " + quantity);
        System.out.println("Descritpion: " + des);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + p);
        System.out.println("Discount precent: " + discount);
    }

    public void main_menu() {
        System.out.println("\n1-register");
        System.out.println("2-login");
        System.out.println("3-display items");
        System.out.println("4-Exit");
    }

    public void user_menu() {
        System.out.println("\n1-Make Order");
        System.out.println("2-save order");
        System.out.println("3-display items");
        System.out.println("4-log out");
    }

    public void makeOrder_menu() {
        System.out.println("1.choose item:");
        System.out.println("2.close order:");
        System.out.print("choose from menu: ");
    }

    public void reciet_header(int o_id, String name, String add) {
        System.out.println("============== Receipt ==============");
        System.out.println("Coustmer Name: " + name);
        System.out.println("Coustmer Address: " + add);
        System.out.println("Order-ID: " + o_id);
    }

    public void reciet_body(String name, int quantity, float price) {

        System.out.println("-------------------");
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }

    public void reciet_footer(float amount) {
        System.out.println("=====================================");
        System.out.println("Total Amount: " + amount);

    }

    public void viewcat_name(String n) {
        System.out.println("==============" + n + "==============");
    }

}
