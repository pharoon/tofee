/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tofee.model;

/**
 *
 * a class used to define how a customer can pay in cash
 */
public class cash_pay extends payment {

    public cash_pay() {
        super(0, 0,0);
    }
    
    public @Override boolean pay(){
        return true;
    }
}
