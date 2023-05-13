/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

import java.util.Map;

/**
 *
 * @author mostafa
 */
abstract class payment {
    protected double amount;
    protected int voucher_id;
    protected static Map<Integer, Double> items;
    protected double loy_pts_used;
    public abstract boolean pay();

    public payment(double amount, int voucher_id, double loy_pts_used) {
        this.amount = amount;
        this.voucher_id = voucher_id;
        this.loy_pts_used = loy_pts_used;
    }
    
}
