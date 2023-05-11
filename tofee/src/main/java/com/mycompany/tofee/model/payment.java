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
   
}
