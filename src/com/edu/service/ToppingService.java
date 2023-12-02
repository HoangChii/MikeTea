/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;
import com.edu.entity.Topping;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ToppingService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<Topping> getAllTP(){
        sql = "SELECT id, TenTopping FROM dbo.Topping";
        List<Topping> listtp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Topping tp = new Topping(rs.getString(1),
                        rs.getString(2));
                listtp.add(tp);
            }
            return listtp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
