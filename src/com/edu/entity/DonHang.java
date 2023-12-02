/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.entity;

/**
 *
 * @author Hoàng Chi
 */
public class DonHang {
    private int iddonhang;
    private int soluongdh;
    private int tonggiatri;
    private String idkhuyenmai;

    public DonHang() {
    }

    public DonHang(int iddonhang, int soluongdh, int tonggiatri, String idkhuyenmai) {
        this.iddonhang = iddonhang;
        this.soluongdh = soluongdh;
        this.tonggiatri = tonggiatri;
        this.idkhuyenmai = idkhuyenmai;
    }

    public int getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(int iddonhang) {
        this.iddonhang = iddonhang;
    }

    public int getSoluongdh() {
        return soluongdh;
    }

    public void setSoluongdh(int soluongdh) {
        this.soluongdh = soluongdh;
    }

    public int getTonggiatri() {
        return tonggiatri;
    }

    public void setTonggiatri(int tonggiatri) {
        this.tonggiatri = tonggiatri;
    }

    public String getIdkhuyenmai() {
        return idkhuyenmai;
    }

    public void setIdkhuyenmai(String idkhuyenmai) {
        this.idkhuyenmai = idkhuyenmai;
    }

    
    
    
}
