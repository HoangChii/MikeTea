/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author Hoàng Chi
 */
public class Loai {
    private String tenLoai;
    private Float giaLoai;

    public Loai() {
    }

    public Loai(String tenLoai, Float giaLoai) {
        this.tenLoai = tenLoai;
        this.giaLoai = giaLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Float getGiaLoai() {
        return giaLoai;
    }

    public void setGiaLoai(Float giaLoai) {
        this.giaLoai = giaLoai;
    }
    
    public Object[] toData(){
        return new Object[] {tenLoai, giaLoai};
    }
}
