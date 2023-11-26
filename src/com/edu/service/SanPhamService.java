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
    
    public List<SanPham> getAll(){
        sql = "SELECT ID ,TenSanPham ,GiaBan ,SoLuong ,MoTa FROM dbo.SanPham";
        List<SanPham> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getString(5),
                        rs.getFloat(3),
                        rs.getInt(4));
                listsp.add(sp);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int delete(String ma){
        sql = "DELETE FROM dbo.SanPham  WHERE ID = ?";
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
    
    public int add(SanPham sp){
        sql = "INSERT INTO dbo.SanPham (ID ,TenSanPham ,SoLuong , GiaBan ,MoTa) VALUES (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getIdSanPham());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getSoLuong());
            ps.setObject(4, sp.getGiaBan());
            ps.setObject(5, sp.getHinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update(String ma, SanPham sp){
        sql = "UPDATE dbo.SanPham SET ID = ?,TenSanPham = ?,SoLuong = ?,GiaBan = ?,MoTa = ? WHERE ID = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getIdSanPham());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getSoLuong());
            ps.setObject(4, sp.getGiaBan());
            ps.setObject(5, sp.getHinh());
            ps.setObject(6, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public boolean testTrung(String ma){
        List<SanPham> lst = this.getAll();
        boolean check = false;
        for (SanPham sanPham : lst) {
            if(sanPham.getIdSanPham().equals(ma)){
                check = true;
                break;
            }
        }
        return check;
    }
    
    public boolean testTrungTen(String ten){
       List<SanPham> lst = this.getAll();
        boolean check = false;
        for (SanPham sanPham : lst) {
            if(sanPham.getTenSP().equals(ten)){
                check = true;
                break;
            }
        }
        return check;
    }
    
    
    public List<SanPham> selectTen(String ten) {
        try {
            String sql = "SELECT ID ,TenSanPham ,SoLuong ,GiaBan ,MoTa FROM SanPham WHERE TenSanPham LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + ten + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    while (rs.next()) {
                        SanPham nv = new SanPham();
                        nv.setIdSanPham(rs.getString("ID"));
                        nv.setTenSP(rs.getString("TenSanPham"));
                        nv.setSoLuong(rs.getInt("SoLuong"));
                        nv.setGiaBan(rs.getInt("GiaBan"));
                        nv.setHinh(rs.getString("MoTa"));

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
