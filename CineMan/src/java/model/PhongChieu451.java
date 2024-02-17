package model;

public class PhongChieu451 implements Comparable<PhongChieu451> {
    private int id;
    private String ten;
    private String viTri;
    private int sucChua;
    private String moTa;
    
    public PhongChieu451() {
        // Hàm khởi tạo mặc định
    }
    
    public PhongChieu451(int id, String ten, String viTri, int sucChua, String moTa) {
        this.id = id;
        this.ten = ten;
        this.viTri = viTri;
        this.sucChua = sucChua;
        this.moTa = moTa;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTen() {
        return ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public String getViTri() {
        return viTri;
    }
    
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    
    public int getSucChua() {
        return sucChua;
    }
    
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public int compareTo(PhongChieu451 o) {
        return this.id - o.id;
    }
}