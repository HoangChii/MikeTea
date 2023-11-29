/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.BanHang;
import com.edu.entity.HoaDonChiTiet;
import com.edu.utils.DBConnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class BanHangService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<BanHang> getAll(){
        sql = "SELECT TenSanPham ,GiaBan, MoTa FROM dbo.SanPham";
        List<BanHang> listbh = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                BanHang bh = new BanHang(rs.getString(1),
                        rs.getFloat(2),
                        rs.getString(3));
                listbh.add(bh);
            }
            return listbh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int add(HoaDonChiTiet x){
        sql = "INSERT INTO [dbo].[HoaDonChiTiet] ([IDHoaDon] ,[TenSanPham] ,[DonGia] ,[SoLuong] ,[ThanhTien] ,[KhuyenMai] ,[TongTien] ) VALUES (?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, x.getIDHoaDon());
            ps.setObject(2, x.getTenSanPham());
            ps.setObject(3, x.getDonGia());
            ps.setObject(4, x.getSoLuong());
            ps.setObject(5, x.getThanhTien());
            ps.setObject(6, x.getKhuyenMai());
            ps.setObject(7, x.getTongTien());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
