package model;

import java.util.Date;

public class NhanVien451 extends ThanhVien451 {
    private String viTri;

    public NhanVien451() {
        // Hàm khởi tạo mặc định của lớp con
    }

    public NhanVien451(int id, String tenDangNhap, String matKhau, String ten, Date ngaySinh, String email, String soDienThoai, String ghiChu, String viTri) {
        super(id, tenDangNhap, matKhau, ten, ngaySinh, email, soDienThoai, ghiChu);
        this.viTri = viTri;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}