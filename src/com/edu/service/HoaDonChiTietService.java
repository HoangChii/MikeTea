/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.HoaDonChiTiet;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Hoàng Chi
 */
public class HoaDonChiTietService {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<HoaDonChiTiet> getAll() {
        sql = "SELECT [IDHoaDon] ,[TenSanPham] ,[DonGia] ,[SoLuong] ,[ThanhTien] ,[KhuyenMai] ,[TongTien], [ID] FROM [dbo].[HoaDonChiTiet]";
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hd = new HoaDonChiTiet(rs.getString(8),
                        rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getInt(4), 
                        rs.getFloat(5), 
                        rs.getFloat(6),
                        rs.getFloat(7));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
