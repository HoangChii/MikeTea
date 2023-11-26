/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author Cong Binh
 */
public class HoaDon {

    private String idHoaDon;
    private float tongTien;
    private String ngayTao;
    private String nguoiTao;
    private String khuyenMai;
    private int soLuong;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, float tongTien, String ngayTao, String nguoiTao, String khuyenMai, int soLuong) {
        this.idHoaDon = idHoaDon;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.khuyenMai = khuyenMai;
        this.soLuong = soLuong;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

   
   

    public Object[] toData() {
        return new Object[]{idHoaDon, tongTien, ngayTao, nguoiTao, khuyenMai, soLuong};
    }

}
