package model;

import java.util.Date;

public class KhachHang451 extends ThanhVien451 {
    private String maKhachHang;
    private TheThanhVien451 theThanhVien;
    public KhachHang451() {
        // Hàm khởi tạo mặc định của lớp con
    }

    public KhachHang451(int id, String tenDangNhap, String matKhau, String ten, Date ngaySinh, String email, String soDienThoai, String ghiChu, String maKhachHang,TheThanhVien451 theThanhVien) {
        super(id, tenDangNhap, matKhau, ten, ngaySinh, email, soDienThoai, ghiChu);
        this.maKhachHang = maKhachHang;
        this.theThanhVien = theThanhVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public TheThanhVien451 getTheThanhVien(){
        return theThanhVien;
    }
    public void setTheThanhVien(TheThanhVien451 theThanhVien){
        this.theThanhVien = theThanhVien;
    }
}
