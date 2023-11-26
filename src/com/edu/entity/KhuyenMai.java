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
    private String IDLoaiKM;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, String IDLoaiKM, Date thoiGianBatDau, Date thoiGianKetThuc) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.IDLoaiKM = IDLoaiKM;
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

    public String getIDLoaiKM() {
        return IDLoaiKM;
    }

    public void setIDLoaiKM(String IDLoaiKM) {
        this.IDLoaiKM = IDLoaiKM;
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
        return new Object[] {maKM, tenKM,IDLoaiKM,thoiGianBatDau, thoiGianKetThuc};
    }
}
