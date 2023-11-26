/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.DangNhap;
import com.edu.utils.DBConnect;
import java.sql.*;

/**
 *
 * @author dotin
 */
public class DangNhapService {
    public DangNhap selectById(String id){
        try {
            String sql = "select * from dangnhap where tendangnhap=?";
             try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    if (rs.next()) {                        
                       DangNhap dn = new DangNhap();
                       dn.setId(rs.getString("ID"));
                       dn.setMatKhau(rs.getString("MatKhau"));
                       return dn;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
