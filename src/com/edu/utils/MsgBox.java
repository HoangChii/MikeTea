/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.utils;

import java.awt.Component;
import javax.swing.JOptionPane;
/**
 *
 * @author Hoàng Chi
 */
public class MsgBox {
    // HIển thị thông báo cho người dùng
    // parent là cửa sổ chứa thông báo
    
    public static void alert(Component parent, String message)  {
        JOptionPane.showMessageDialog(parent, message,
                "PHẦN MỀM QUẢN LÝ BÁN TRÀ SỮA MIKETEA", JOptionPane.INFORMATION_MESSAGE
                );
    }
    
    //HIển thị thông báo và yêu cầu người dùng xác nhận
    
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "PHẦN MỀM QUẢN LÝ BÁN TRÀ SỮA MIKETEA",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
                );
        return result == JOptionPane.YES_OPTION;
    }
    //hiển thị thông báo yêu cầu nhập dữ liệu
    public static String prompt(Component parent,String message){
        return JOptionPane.showInputDialog(parent, message,
            "PHẦN MỀM QUẢN LÝ BÁN TRÀ SỮA MIKETEA", JOptionPane.INFORMATION_MESSAGE);
           
    }
}
