/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.service;

import com.edu.entity.DonHang;
import com.edu.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Chi
 */
public class DonHangService {

    public List<DonHang> getIDDonHang() {
        try {
            String sql = "select top 1* from DONHANG order by id desc ";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try (ResultSet rs = ps.executeQuery();) {
                    List<DonHang> list = new ArrayList<>();
                    while (rs.next()) {
                        DonHang x = new DonHang();
                        x.setIddonhang(rs.getInt("ID"));
                        x.setSoluongdh(rs.getInt("soLuong"));
                        x.setTonggiatri(rs.getInt("TongGiaTri"));
                        x.setIdkhuyenmai(rs.getString("IDKhuyenMai"));
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

    public boolean insert(DonHang x) {
        try {
            String sql = "INSERT INTO DONHANG (SoLuong, TongGiaTri,IDKhuyenMai) VALUES (?,?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getSoluongdh());
                ps.setObject(2, x.getTonggiatri());
                ps.setObject(3, x.getIdkhuyenmai());
                
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql = "exec SP_deleteDonHang ?";
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
