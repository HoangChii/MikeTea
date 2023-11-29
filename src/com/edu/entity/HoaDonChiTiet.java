/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

import java.util.Date;

/**
 *
 * @author Hoàng Chi
 */
public class HoaDonChiTiet {
    private String IDHDCT;
    private String IDHoaDon;
    private String TenSanPham;
    private Float DonGia;
    private int SoLuong;
    private Float ThanhTien;
    private Float KhuyenMai;
    private Float TongTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String IDHDCT, String IDHoaDon, String TenSanPham, Float DonGia, int SoLuong, Float ThanhTien, Float KhuyenMai, Float TongTien) {
        this.IDHDCT = IDHDCT;
        this.IDHoaDon = IDHoaDon;
        this.TenSanPham = TenSanPham;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.KhuyenMai = KhuyenMai;
        this.TongTien = TongTien;
    }

    public String getIDHDCT() {
        return IDHDCT;
    }

    public void setIDHDCT(String IDHDCT) {
        this.IDHDCT = IDHDCT;
    }

    public String getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(String IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public Float getKhuyenMai() {
        return KhuyenMai;
    }

    public void setKhuyenMai(Float KhuyenMai) {
        this.KhuyenMai = KhuyenMai;
    }

    public Float getTongTien() {
        return TongTien;
    }

    public void setTongTien(Float TongTien) {
        this.TongTien = TongTien;
    }

    
    public Object[] toData(){
        return new Object[] {IDHoaDon, TenSanPham, DonGia, SoLuong, ThanhTien, KhuyenMai, TongTien, IDHDCT};
    }
    
}


