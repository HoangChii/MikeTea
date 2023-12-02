/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.CTDonHang;
import com.edu.ui.BanHangJDialog;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Chi
 */
public class CTDonHangService {

    
    public boolean DeleteDHCT(int id) {
        String sql = "delete  from CHITIETDONHANG where id =? ";
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AddDHCT(CTDonHang x) {
        BanHangJDialog b = new BanHangJDialog();
        String sql = "INSERT INTO CHITIETDONHANG (IDDonHang, SoLuong, GiaBan, ThanhTien, IDSanPham)\n"
                + " VALUES ( ?,?,?,?,?)";
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, b.idDonHang);
                ps.setObject(2, x.getSoluongct());
                ps.setObject(3, x.getGiabanct());
                ps.setObject(4, x.getThanhtienct());
                ps.setObject(5, x.getIdsanphamdhct());
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            return false;
        }
    }
//

    public boolean UpdateDHCT(int id) {
        String sql = "update CHITIETDONHANG set IDDonHang = ? where IDDonHang is null";
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public List<CTDonHang> getDHCTisNull() {
//        String sql = "select CHITIETDONHANG.*, SanPham.TenSP from CHITIETDONHANG \n" +
//" join SanPham on CHITIETDONHANG.IDSanPham = SanPham.IDSP\n" +
//" where CHITIETDONHANG.IDDonHang is null";
//        try {
//            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
//                List<CTDonHang> list = new ArrayList<>();
//                try(ResultSet rs = ps.executeQuery();) {
//                    CTDonHang x = new CTDonHang();
//                    x.setIdCTDonHang(rs.getInt("id"));
//                    x.setIdDonHang(rs.getInt("IDDonHang"));
//                    x.setSoluongct(rs.getInt("soluong"));
//                    x.setGiabanct(rs.getInt("Giaban"));
//                    x.setThanhtienct(rs.getInt("ThanhTien"));
//                    x.setIdsanphamdhct(rs.getString("IdSanPham"));
//                    
//                    list.add(x);
//                }
//                return list;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    
    public List<CTDonHang> getDHCTisNull() {
        String sql = "select ctDH.*, sp.TenSP from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.IDSP where ctDH.IDDonHang is null ";
        List<CTDonHang> lst = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTDonHang dhct = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    public boolean DeleteDHCTisNull() {
        String sql = "delete from CHITIETDONHANG where iddonhang is null ";
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateSoLuongDHCT(int soLuong, int idDHCT) {
        String sql = "update CHITIETDONHANG set soLuong = ? where id = ?";
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, soLuong);
                ps.setObject(2, idDHCT);
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CTDonHang> checkSPhaminHDCT(String maSP) {
        String sql = "select CHITIETDONHANG.*, SanPham.TenSP from CHITIETDONHANG join SanPham on CHITIETDONHANG.IDSanPham = SanPham.IDSP\n"
                + "                where CHITIETDONHANG.IDDonHang is null and CHITIETDONHANG.idsanpham = ?";
        List<CTDonHang> list = new ArrayList<>();
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, maSP);
                try(ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {                        
                        CTDonHang x = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                        
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

    public boolean deleteSP() {
        String sql = "delete from CHITIETDONHANG where id = (select  top 1 ctDH.ID from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.IDSP\n"
                + "                where ctDH.IDDonHang is null\n"
                + "				order by ctDH.ID desc)";
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }        

}
