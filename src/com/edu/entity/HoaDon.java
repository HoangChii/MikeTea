/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

import com.edu.utils.Auth;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Hoàng Chi
 */
public class HoaDon {
    private int id;
    private int trangThai;
    private String ngayLap;
    private int idDonHang;
    private long tongTien;

    public HoaDon() {
    }

    public HoaDon(int id, int trangThai, String ngayLap, int idDonHang, long tongTien) {
        this.id = id;
        this.trangThai = trangThai;
        this.ngayLap = ngayLap;
        this.idDonHang = idDonHang;
        this.tongTien = tongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(int idDonHang) {
        this.idDonHang = idDonHang;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
    
    public Object[] toDatataHD(){
        NumberFormat x = new DecimalFormat("###.###");
        return new Object[]{id, x.format(tongTien), ngayLap, Auth.user.getId()};
    }
    
    public Object[] toDatata1(){
        return new Object[]{ id, ngayLap,idDonHang, tongTien};
    }
}
