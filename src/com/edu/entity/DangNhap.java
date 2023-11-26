/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author dotin
 */
public class DangNhap {
    private String id;
    private String tenDN;
    private String matKhau;

    public DangNhap() {
    }

    public DangNhap(String id, String tenDN, String matKhau) {
        this.id = id;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    
}
