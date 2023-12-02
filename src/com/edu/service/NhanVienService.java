/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.NhanVien;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Hoàng Chi
 */
public class NhanVienService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<NhanVien> getAll() {
        sql = "SELECT [ID] ,[HoTen],[Email],[TinhTrang],[VaiTro],[MatKhau] FROM [NhanVien]";
        List<NhanVien> listnv = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(6), 
                        rs.getInt(4), 
                        rs.getInt(5));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public NhanVien getByID(String id) {
        try {
            String sql = "SELECT [ID] ,[HoTen],[Email],[TinhTrang],[VaiTro],[MatKhau] FROM [NhanVien] where id like ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {                        
                        NhanVien x = new NhanVien();
                        x.setId(rs.getString("ID"));
                        x.setHoTen(rs.getString("hoTen"));
                        x.setEmail(rs.getString("Email"));
                        x.setTinhTrang(rs.getInt("tinhTrang"));
                        x.setVaiTro(rs.getInt("VaiTro"));
                        x.setMatKhau(rs.getString("MatKhau"));
                        return x;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<NhanVien> getByTen(String ten) {
        try {
            String sql = "SELECT [ID] ,[HoTen],[Email],[MatKhau],[TinhTrang],[VaiTro] FROM [NhanVien] where HoTen like ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + ten + "%");
                try(ResultSet rs = ps.executeQuery();) {
                    List<NhanVien> list = new ArrayList<>();
                    while (rs.next()) {                        
                        NhanVien x = new NhanVien();
                        x.setId(rs.getString("ID"));
                        x.setHoTen(rs.getString("hoTen"));
                        x.setEmail(rs.getString("Email"));
                        x.setTinhTrang(rs.getInt("tinhTrang"));
                        x.setVaiTro(rs.getInt("VaiTro"));
                        
                        list.add(x);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean insert(NhanVien x) {
        try {
            String sql = "INSERT INTO [dbo].[NhanVien] ([ID],[HoTen],[Email],[MatKhau],[TinhTrang],[VaiTro]) values (?,?,?,?,?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getId());
                ps.setObject(2, x.getHoTen());
                ps.setObject(3, x.getEmail());
                ps.setObject(4, x.getMatKhau());
                ps.setObject(5, x.getTinhTrang());
                ps.setObject(6, x.getVaiTro());
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(NhanVien x) {
        try {
            String sql = "UPDATE [dbo].[NhanVien] SET [HoTen] = ?,[Email] = ?,[MatKhau] = ?,[TinhTrang] = ?,[VaiTro] = ? where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(6, x.getId());
                ps.setObject(1, x.getHoTen());
                ps.setObject(2, x.getEmail());
                ps.setObject(3, x.getMatKhau());
                ps.setObject(4, x.getTinhTrang());
                ps.setObject(5, x.getVaiTro());
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String id) {
        try {
            String sql = "delete from nhanVien where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
