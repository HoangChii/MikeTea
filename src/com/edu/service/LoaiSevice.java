/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;
import com.edu.entity.Loai;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Hoàng Chi
 */
public class LoaiSevice {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<Loai> getAllL(){
        sql = "SELECT  LoaiSize ,Gia FROM dbo.Loai";
        List<Loai> listl = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Loai l = new Loai(rs.getString(1),
                        rs.getFloat(2));
                listl.add(l);
            }
            return listl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
