package model;

public class Phim451 {
    private int id;
    private String tenPhim;
    private String anhMinhHoa;
    private String theLoai;
    private String moTa;
    private int namPhatHanh;
    private boolean trangThai;
    
    // Hàm khởi tạo mặc định
    public Phim451() {
    }
    
    // Hàm khởi tạo đầy đủ tham số
    public Phim451(int id, String tenPhim, String anhMinhHoa, String theLoai, String moTa, int namPhatHanh, boolean trangThai) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.anhMinhHoa = anhMinhHoa;
        this.theLoai = theLoai;
        this.moTa = moTa;
        this.namPhatHanh = namPhatHanh;
        this.trangThai = trangThai;
    }
    
    // Getter và setter cho các thuộc tính
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTenPhim() {
        return tenPhim;
    }
    
    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
    
    public String getAnhMinhHoa() {
        return anhMinhHoa;
    }
    
    public void setAnhMinhHoa(String anhMinhHoa) {
        this.anhMinhHoa = anhMinhHoa;
    }
    
    public String getTheLoai() {
        return theLoai;
    }
    
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public int getNamPhatHanh() {
        return namPhatHanh;
    }
    
    public void setNamPhatHanh(int namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }
    
    public boolean getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}