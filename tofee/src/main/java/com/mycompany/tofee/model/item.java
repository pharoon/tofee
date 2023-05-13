/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

/**
 *
 * @author mostafa
 */
abstract class item {
    protected String name;
    protected category categoryy;
    protected String description;
    protected String brand;
    protected double price;
    protected double discount_percent;
    public item(String name, category categoryy, String description,
            String brand, double price, double discount_percent){
        this.name = name;
        this.categoryy = categoryy;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.discount_percent = discount_percent;
    }
}
