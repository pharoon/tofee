/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tofee;
import com.mycompany.tofee.model.*;
import java.sql.*;
import javax.swing.JOptionPane;



/**
 *the main class where we can test and run the code
 * 
 */
public class Tofee {
    
     public static void main(String[] args) {
        String str = new String("jimmy");
        user_acc acc1 = new user_acc("mostafa", 01111525151, "mostafa@gmail.com",
            "zzz88", "home", 10);
        acc1.save_user();
        
    }
}
