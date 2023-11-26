/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author Hoàng Chi
 */
public class SanPham {
    private String idSanPham;
    private String tenSP;
    private String hinh;
    private float giaBan;
    private int soLuong;

    public SanPham() {
    }

    public SanPham(String idSanPham, String tenSP, String hinh, float giaBan, int soLuong) {
        this.idSanPham = idSanPham;
        this.tenSP = tenSP;
        this.hinh = hinh;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    

    
    public Object[] toData(){
        return new Object[] {idSanPham, tenSP, giaBan, soLuong, hinh};
    }
}
