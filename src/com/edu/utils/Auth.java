/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.utils;

import com.edu.entity.DangNhap;

/**
 *
 * @author Hoàng Chi
 */
public class Auth {
    public static DangNhap user = null;
    
    public static void clear() {
        Auth.user = null;
    }
    
    public static boolean isLogin() {
        return Auth.user != null;
    }
    
    
}
