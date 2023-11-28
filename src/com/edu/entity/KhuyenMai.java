/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private Float giaTri;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, Float giaTri, Date thoiGianBatDau, Date thoiGianKetThuc) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.giaTri = giaTri;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(Float giaTri) {
        this.giaTri = giaTri;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    
    public Object[] toData(){
        return new Object[] {maKM, tenKM,giaTri,thoiGianBatDau, thoiGianKetThuc};
    }
}
