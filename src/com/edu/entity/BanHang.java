/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author admin
 */
public class BanHang {
    private String tenSanPham;
    private float giaBan;
    private String anh;

    public BanHang() {
    }

    public BanHang(String tenSanPham, float giaBan, String anh) {
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.anh = anh;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    
     public Object[] toData(){
        return new Object[] {tenSanPham, giaBan, anh};
    }
}
