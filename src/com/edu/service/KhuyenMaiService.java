/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.KhuyenMai;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiService {
    
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<KhuyenMai> getAll(){
        sql = "SELECT * FROM dbo.KhuyenMai";
        List<KhuyenMai> listkm = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai(rs.getString(1),
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getString(4),
                        rs.getString(5));  
                listkm.add(km);
            }
            return listkm;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public int deleteKhuyenMai(String maKM){
        sql = "DELETE FROM KhuyenMai WHERE ID = ?";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKM);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }  
    }
    
    public int updateKhuyenMai(String maKM, KhuyenMai km){
        sql = "UPDATE KhuyenMai SET ID = ?, TenKM = ?, GiaTri =?, TGBatDau = ?, TGKetThuc = ? WHERE ID = ?";
       try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getMaKM());
            ps.setObject(2, km.getTenKM());
            ps.setObject(3, km.getGiaTri());
            ps.setObject(4, km.getThoiGianBatDau());
            ps.setObject(5, km.getThoiGianKetThuc());
            ps.setObject(6, maKM);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int addKhuyenMai(KhuyenMai km ){
        sql = "INSERT INTO KhuyenMai (ID ,TenKM ,GiaTri ,TGBatDau ,TGKetThuc) values (?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getMaKM());
            ps.setObject(2, km.getTenKM());
            ps.setObject(3, km.getGiaTri());
            ps.setObject(4, km.getThoiGianBatDau());
            ps.setObject(5, km.getThoiGianKetThuc());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public boolean testTrung(String ma){
        List<KhuyenMai> lst = this.getAll();
        boolean check = false;
        for (KhuyenMai km : lst) {
            if(km.getMaKM().equals(ma)){
                check = true;
                break;
            }
        }
        return check;
    }
    
    public boolean testTrungTen(String ten){
       List<KhuyenMai> lst = this.getAll();
        boolean check = false;
        for (KhuyenMai km : lst) {
            if(km.getTenKM().equals(ten)){
                check = true;
                break;
            }
        }
        return check;
    }
    public List<KhuyenMai> selectKhuyenMai(String maKM){
        try{
            String sql = "SELECT ID ,TenKM ,GiaTri ,TGBatDau ,TGKetThuc FROM KhuyenMai WHERE ID LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + maKM + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<KhuyenMai> list = new ArrayList<>();
                    while (rs.next()) {
                        KhuyenMai km = new KhuyenMai();
                        km.setMaKM(rs.getString("ID"));
                        km.setTenKM(rs.getString("tenKM"));
                        km.setGiaTri(rs.getInt("GiaTri"));
                        km.setThoiGianBatDau(rs.getString("TGBatDau"));
                        km.setThoiGianKetThuc(rs.getString("TGKetThuc"));
                        list.add(km);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public KhuyenMai getByma(String ma){
        sql = "SELECT ID ,TenKM ,GiaTri ,TGBatDau ,TGKetThuc FROM KhuyenMai WHERE ID LIKE ?";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));  
                return km;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
