/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author Hoàng Chi
 */
public class NhanVien {
    private String idNhanVien, matKhau, hoTen, email, gioiTinh, ChucVu;
    private int sdt;
    
    public NhanVien() {
    }
    
    public boolean isChucVu() {
        if (ChucVu.equals("Quản Lý")) {
            return true;
        }
        return false;
    }

    public NhanVien(String idNhanVien, String matKhau, String hoTen, String email, String gioiTinh, String ChucVu, int sdt) {
        this.idNhanVien = idNhanVien;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ChucVu = ChucVu;
        this.sdt = sdt;
    }

    public NhanVien(String idNhanVien, String hoTen, String email, String gioiTinh, String ChucVu, int sdt) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ChucVu = ChucVu;
        this.sdt = sdt;
    }
    
    

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
    
    public boolean isGioiTinh() {
        if (gioiTinh.equals("Nam")) {
            return true;
        }
        return false;
    }
    
    public Object[] toData(){
        return new Object[] {idNhanVien, hoTen, gioiTinh, ChucVu, sdt, email};
    }
}
