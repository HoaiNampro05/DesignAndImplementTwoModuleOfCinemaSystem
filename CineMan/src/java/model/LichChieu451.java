package model;

import java.util.Date;

public class LichChieu451 {
    private int id;
    private Date gioBatDau;
    private Date gioKetThuc;
    private PhongChieu451 phongChieu;
    private Phim451 phim;
    
    public LichChieu451() {
        // Hàm khởi tạo mặc định
    }
    
    public LichChieu451(int id, Date gioBatDau, Date gioKetThuc, PhongChieu451 phongChieu, Phim451 phim) {
        this.id = id;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.phongChieu = phongChieu;
        this.phim = phim;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getGioBatDau() {
        return gioBatDau;
    }
    
    public void setGioBatDau(Date gioBatDau) {
        this.gioBatDau = gioBatDau;
    }
    
    public Date getGioKetThuc() {
        return gioKetThuc;
    }
    
    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
    
    public PhongChieu451 getPhongChieu() {
        return phongChieu;
    }
    
    public void setPhongChieu(PhongChieu451 phongChieu) {
        this.phongChieu = phongChieu;
    }
    
    public Phim451 getPhim() {
        return phim;
    }
    
    public void setPhim(Phim451 phim) {
        this.phim = phim;
    }
}