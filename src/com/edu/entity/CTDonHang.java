/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author Hoàng Chi
 */
public class CTDonHang {
    private int idCTDonHang, idDonHang;
    private int soluongct;
    private int giabanct;
    private int thanhtienct;
    private String idsanphamdhct;
    private String tenSanPham;

    public CTDonHang() {
    }

    public CTDonHang(int idCTDonHang, int idDonHang, int soluongct, int giabanct, int thanhtienct, String idsanphamdhct, String tenSanPham) {
        this.idCTDonHang = idCTDonHang;
        this.idDonHang = idDonHang;
        this.soluongct = soluongct;
        this.giabanct = giabanct;
        this.thanhtienct = thanhtienct;
        this.idsanphamdhct = idsanphamdhct;
        this.tenSanPham = tenSanPham;
    }

    public int getIdCTDonHang() {
        return idCTDonHang;
    }

    public void setIdCTDonHang(int idCTDonHang) {
        this.idCTDonHang = idCTDonHang;
    }

    public int getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(int idDonHang) {
        this.idDonHang = idDonHang;
    }

    public int getSoluongct() {
        return soluongct;
    }

    public void setSoluongct(int soluongct) {
        this.soluongct = soluongct;
    }

    public int getGiabanct() {
        return giabanct;
    }

    public void setGiabanct(int giabanct) {
        this.giabanct = giabanct;
    }

    public int getThanhtienct() {
        return thanhtienct;
    }

    public void setThanhtienct(int thanhtienct) {
        this.thanhtienct = thanhtienct;
    }

    public String getIdsanphamdhct() {
        return idsanphamdhct;
    }

    public void setIdsanphamdhct(String idsanphamdhct) {
        this.idsanphamdhct = idsanphamdhct;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    
    
    public Object[] toData(){
        return new Object[]{idsanphamdhct,tenSanPham,soluongct,giabanct,thanhtienct};
    }
}
