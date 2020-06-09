package Model;

public class KhoanChi {
    private String khoanChi;
    private String loaiChi;

    private int soTien;
    private String ngayThang;

    public KhoanChi(String khoanChi, String loaiChi,  int soTien ,String ngayThang) {
        this.khoanChi = khoanChi;
        this.loaiChi = loaiChi;
        this.ngayThang = ngayThang;
        this.soTien = soTien;
    }

    public String getKhoanChi() {
        return khoanChi;
    }

    public void setKhoanChi(String khoanChi) {
        this.khoanChi = khoanChi;
    }

    public String getLoaiChi() {
        return loaiChi;
    }

    public void setLoaiChi(String loaiChi) {
        this.loaiChi = loaiChi;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }
}
