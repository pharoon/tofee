/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

/**
 *
 * @author mostafa
 */
abstract class account {
    protected String name;
    protected int phone_num;
    protected String email;
    protected String password;
    protected String address;
    protected int loy_pts;

    public account(String name, int phone_num, String email, String password, String address, int loy_pts) {
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.password = password;
        this.address = address;
        this.loy_pts = loy_pts;
    }
}
