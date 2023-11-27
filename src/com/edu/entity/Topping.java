/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author admin
 */
public class Topping {
    private String tenTopping;
    private float giaTopping;

    public Topping() {
    }

    public Topping(String tenTopping, float giaTopping) {
        this.tenTopping = tenTopping;
        this.giaTopping = giaTopping;
    }

    public String getTenTopping() {
        return tenTopping;
    }

    public void setTenTopping(String tenTopping) {
        this.tenTopping = tenTopping;
    }

    public float getGiaTopping() {
        return giaTopping;
    }

    public void setGiaTopping(float giaTopping) {
        this.giaTopping = giaTopping;
    }
    public Object[] toData(){
        return new Object[] {tenTopping, giaTopping};
    }
}
