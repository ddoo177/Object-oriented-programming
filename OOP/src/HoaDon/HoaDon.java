package HoaDon;

import DuLieu.CheckLoi;

public class HoaDon {

    CheckLoi check = new CheckLoi();

    private String MaHD;
    private String NgayLapHD;
    private String MaPT;
    private String MaNV;
    private long TongTien;
    public HoaDon()
    {
        this.MaHD = null;
        this.NgayLapHD = null;
        this.MaPT = null;
        this.MaNV = null;
    }
    public HoaDon(String maHD, String ngayLapHD, String maPT, String maNV, long TongTien) {
        this.MaHD = maHD;
        this.NgayLapHD = ngayLapHD;
        this.MaPT = maPT;
        this.MaNV = maNV;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getNgayLapHD() {
        return NgayLapHD;
    }

    public String getMaPT() {
        return MaPT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        NgayLapHD = ngayLapHD;
    }

    public void setMaPT(String maPT) {
        MaPT = maPT;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }
    public void setMaHD() {
        MaHD = check.KiemTraMaHD();
    }

    public void setNgayLapHD() {
        NgayLapHD = check.KiemTraNgayThang();
    }

    public void setMaPT() {
        MaPT = check.KiemTraMaPT();
    }

    public void setMaNV() {
        MaNV = check.KiemTraNhapMaNV();
    }

    public void Nhap() {
        System.out.println("Nhập mã hóa đơn:");
        this.setMaHD();
        System.out.println("Nhập ngày lập hóa đơn:");
        this.setNgayLapHD();
        System.out.println("Nhập mã phiếu thuê:");
        this.setMaPT();
        System.out.println("Nhập mã nhân viên:");
        this.setMaNV();
    }
    @Override
    public String toString() {
        return String.format("|%-20s|%-15s|%-20s|%-20s|%-20s|\n", MaHD, NgayLapHD, MaPT, MaNV,TongTien);
    }

    public String Ghifile(){
        return getMaHD()+";"+getNgayLapHD()+";"+getMaPT()+";"+getMaNV();
    }
}