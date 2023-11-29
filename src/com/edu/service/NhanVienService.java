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
        sql = "SELECT [IDNV], MatKhau ,[HoTen] ,[GioiTinh] ,[ChucVu] ,[SDT]  ,[Email] FROM [dbo].[NhanVien]";
        List<NhanVien> listnv = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(7),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteNhanVien(String id) {
        sql = "DELETE FROM [dbo].[NhanVien] WHERE [IDNV] = ?";
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

    public int update(String id, NhanVien nv) {
        sql = "UPDATE [dbo].[NhanVien] SET [IDNV] = ?,[HoTen] = ?,[GioiTinh] = ?,[SDT] = ?,[Email] = ?,[ChucVu] = ? WHERE [ID] = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getIdNhanVien());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getChucVu());
            ps.setObject(7, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int addNhanVien(NhanVien nv) {
        sql = "INSERT INTO [dbo].[NhanVien]([ID],[HoTen],[GioiTinh],[SDT],[Email],[ChucVu]) VALUES (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getIdNhanVien());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getChucVu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean testTrung(String ma) {
        List<NhanVien> lst = this.getAll();
        boolean check = false;
        for (NhanVien nv : lst) {
            if (nv.getIdNhanVien().equals(ma)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean testTrungTen(String ten) {
        List<NhanVien> lst = this.getAll();
        boolean check = false;
        for (NhanVien nv : lst) {
            if (nv.getHoTen().equals(ten)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public List<NhanVien> selectHoTen(String ten) {
        try {
            String sql = "SELECT [IDNV] ,[HoTen] ,[GioiTinh] ,[SDT]  ,[Email] , [ChucVu] FROM NhanVien WHERE [HoTen] LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + ten + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<NhanVien> list = new ArrayList<>();
                    while (rs.next()) {
                        NhanVien nv = new NhanVien();
                        nv.setIdNhanVien(rs.getString("IDNV"));
                        nv.setHoTen(rs.getString("HoTen"));
                        nv.setGioiTinh(rs.getString("GioiTinh"));
                        nv.setSdt(rs.getInt("SDT"));
                        nv.setEmail(rs.getString("Email"));
                        nv.setChucVu(rs.getString("ChucVu"));
                        list.add(nv);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien getbyTen(String ten) {
        sql = "SELECT IDNV ,HoTen ,GioiTinh ,ChucVu ,SDT  ,Email FROM dbo.NhanVien Where HoTen like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1),
                        rs.getString(2),
                        rs.getString(6),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public NhanVien selectByID(String ten) {
        try {
            String sql = "SELECT [IDNV], MatKhau ,[HoTen] ,[GioiTinh] ,[SDT]  ,[Email] , [ChucVu] FROM NhanVien WHERE [IDNV] LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + ten + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {
                        NhanVien nv = new NhanVien();
                        nv.setIdNhanVien(rs.getString("IDNV"));
                        nv.setMatKhau(rs.getString("MatKhau"));
                        nv.setHoTen(rs.getString("HoTen"));
                        nv.setGioiTinh(rs.getString("GioiTinh"));
                        nv.setSdt(rs.getInt("SDT"));
                        nv.setEmail(rs.getString("Email"));
                        nv.setChucVu(rs.getString("ChucVu"));
                        return nv;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
