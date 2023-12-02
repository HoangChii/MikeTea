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
    private double giaBan;
    private int soLuong;
    private String topping, size;

    public SanPham() {
    }

    public SanPham(String idSanPham, String tenSP, String hinh, double giaBan, int soLuong, String topping, String size) {
        this.idSanPham = idSanPham;
        this.tenSP = tenSP;
        this.hinh = hinh;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.topping = topping;
        this.size = size;
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

    public double getGiaBan() {
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

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    public Object[] toData(){
        return new Object[] {idSanPham, tenSP, giaBan, soLuong,topping, size};
    }
    
    public Object[] toDoUong(){
        return new Object[] {idSanPham, tenSP, giaBan,topping, size, soLuong};
    }
}
