/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

/**
 *
 * a class used to make accounts for admins because they have different features 
 * from the normal user
 * not available currently
 */
public class admin_acc extends account {
    
    public admin_acc(String name, int phone_num, int ID, String email,
            String password, String address, int loy_pts) {
        super(name, phone_num, email, password, address, loy_pts);
    }
}
