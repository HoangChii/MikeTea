/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.HoaDon;
import com.edu.utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cong Binh
 */
public class HoaDonService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<HoaDon> getAll() {
        sql = "SELECT [ID]  ,[TongTien],[NgayTao],[IDNV], [KhuyenMai], [SoLuong] FROM [dbo].[HoaDon]";
        List<HoaDon> listhd = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                listhd.add(hd);
            }
            return listhd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteHoaDon(String id) {
        sql = "DELETE FROM [dbo].[HoaDon] WHERE [ID] = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int xoaMem(String id) {
        sql = "DELETE FROM [dbo].[HoaDon] WHERE ID = false";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public List<HoaDon> selectHoTen(String Id) {
        try {
            String sql = "SELECT [ID] ,[KhuyenMai] ,[IDNV] ,[NguoiTao]  ,[SoLuong] , [TongTien] FROM HoaDon WHERE [ID] LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + Id + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<HoaDon> list = new ArrayList<>();
                    while (rs.next()) {
                        HoaDon hd = new HoaDon();
                        hd.setIdHoaDon(rs.getString("ID"));
                        hd.setKhuyenMai(rs.getString("KhuyenMai"));
                        hd.setNgayTao(rs.getString("NgayTao"));
                        hd.setIDNV(rs.getString("IDNV"));
                        hd.setSoLuong(rs.getInt("SoLuong"));
                        hd.setTongTien(rs.getFloat("TongTien"));

                        list.add(hd);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public HoaDon getBtTen(String ma) {
        sql = "SELECT [ID]  ,[TongTien],[NgayTao],[IDNV], [KhuyenMai], [SoLuong] FROM [dbo].[HoaDon] WHERE ID LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                return hd;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
