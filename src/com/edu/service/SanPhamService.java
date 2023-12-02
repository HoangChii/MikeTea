/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.SanPham;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Chi
 */
public class SanPhamService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SanPham> getAll() {
        sql = "SELECT SanPham.IDSP, SanPham.TenSP, SanPham.GiaTien, SanPham.SoLuong, SanPham.HinhAnh, Topping.TenTopping, Size.TenSize\n"
                + " FROM     SanPham INNER JOIN\n"
                + "                  Size ON SanPham.IDSize = Size.ID INNER JOIN\n"
                + "                  Topping ON SanPham.IDTopping = Topping.ID";
        List<SanPham> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham(rs.getString(1), 
                        rs.getString(2),
                        rs.getString(5), 
                        rs.getDouble(3), 
                        rs.getInt(4),
                        rs.getString(6),
                        rs.getString(7));
                listsp.add(x);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SanPham getByID(String id) {
        sql = "SELECT SanPham.IDSP, SanPham.TenSP, SanPham.GiaTien, SanPham.SoLuong, SanPham.HinhAnh, Topping.TenTopping, Size.TenSize\n"
                + " FROM     SanPham INNER JOIN\n"
                + "                  Size ON SanPham.IDSize = Size.ID INNER JOIN\n"
                + "                  Topping ON SanPham.IDTopping = Topping.ID where (idSP = ?)";
        List<SanPham> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham(rs.getString(1), 
                        rs.getString(2),
                        rs.getString(5), 
                        rs.getDouble(3), 
                        rs.getInt(4),
                        rs.getString(6), 
                        rs.getString(7));
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public SanPham getSoLuong(String id) {
        sql = "SELECT IDSP ,TenSP,SoLuong,GiaTien FROM dbo.SANPHAM where idSP = ?";
        List<SanPham> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setIdSanPham(rs.getString("idSP"));
                x.setTenSP(rs.getString("TENSP"));
                x.setGiaBan(rs.getFloat("GiaTien"));
                x.setSoLuong(rs.getInt("SoLuong"));

                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public int delete(String ma) {
        sql = "DELETE FROM dbo.SanPham WHERE IDSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int add(SanPham sp) {
        sql = "INSERT INTO [dbo].[SanPham] ([IDSP],[TenSP],[GiaTien],[SoLuong],[HinhAnh],[IDTopping],[IDSize]) values (?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getIdSanPham());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getHinh());
            ps.setObject(6, sp.getTopping());
            ps.setObject(7, sp.getSize());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(SanPham sp, String ma) {
        sql = "UPDATE [dbo].[SanPham] SET IDSP = ?, [TenSP] = ?,[GiaTien] = ?,[SoLuong] = ?,[HinhAnh] = ?,[IDTopping] = ?,[IDSize] = ? WHERE IDSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(8, ma);
            ps.setObject(1, sp.getIdSanPham());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getHinh());
            ps.setObject(6, sp.getTopping());
            ps.setObject(7, sp.getSize());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean testTrung(String ma) {
        List<SanPham> lst = this.getAll();
        boolean check = false;
        for (SanPham sanPham : lst) {
            if (sanPham.getIdSanPham().equals(ma)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean testTrungTen(String ten) {
        List<SanPham> lst = this.getAll();
        boolean check = false;
        for (SanPham sanPham : lst) {
            if (sanPham.getTenSP().equals(ten)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public List<SanPham> selectTen(String ten) {
        try {
            String sql = "SELECT IDSP ,TenSP ,GiaTien ,SoLuong ,HinhAnh, IDTopping, IDSize FROM SanPham WHERE TenSP LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + ten + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    while (rs.next()) {
                        SanPham nv = new SanPham();
                        nv.setIdSanPham(rs.getString("IDSP"));
                        nv.setTenSP(rs.getString("TenSP"));
                        nv.setSoLuong(rs.getInt("GiaTien"));
                        nv.setGiaBan(rs.getInt("SoLuong"));
                        nv.setHinh(rs.getString("HinhAnh"));
                        nv.setTopping(rs.getString("IDTopping"));
                        nv.setSize(rs.getString("IDSize"));
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
}
