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
        sql = "SELECT [ID]  ,[TongTien],[NgayTao],[NguoiTao], [KhuyenMai], [SoLuong] FROM [dbo].[HoaDon]";
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
}
