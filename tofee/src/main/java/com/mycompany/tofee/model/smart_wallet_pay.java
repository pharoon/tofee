/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

/**
 *
 * @author mostafa
 */
public class smart_wallet_pay extends payment {

    public smart_wallet_pay(double amount, int voucher_id, double loy_pts_used) {
        super(amount, voucher_id, loy_pts_used);
    }

    @Override
    public boolean pay() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
