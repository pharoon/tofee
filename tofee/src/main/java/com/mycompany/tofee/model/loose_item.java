/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

/**
 *
 * a class specialized in loose items
 */

public class loose_item extends item{
    
    public loose_item(String name, category categoryy, String description, String brand, double price, double discount_percent) {
        super(name, categoryy, description, brand, price, discount_percent);
    }
}