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
    private String id, hoTen,email, matKhau;
    private int tinhTrang, vaiTro;
    
    public NhanVien() {
    }

    public NhanVien(String id, String hoTen, String email, String matKhau, int tinhTrang, int vaiTro) {
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
        this.vaiTro = vaiTro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    public boolean isTinhTrang() {
        if (tinhTrang == 1) {
            return true;
        }
        return false;
    }
    
    public boolean isVaiTro() {
         if (vaiTro == 1) {
            return true;
        }
        return false;
    }
    
    public String showTT() {
        if (tinhTrang == 1) {
            return "Hoạt Động";
        }
        return "Không Hoạt Động";
    }
    
    public String showVT() {
        if (vaiTro == 1) {
            return "Quản Lý";
        }
        return "Nhân Viên";
    }
    
    public Object[] toData(){
        return new Object[] {id, hoTen, email, showTT(), showVT(),matKhau};
    }
}
