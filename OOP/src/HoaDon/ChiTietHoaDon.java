package HoaDon;

import java.util.Scanner;
import DuLieu.CheckLoi;

public class ChiTietHoaDon
{
    protected String MaHD;
    protected String MaPhong;
    protected int SoNgayO;
    protected String MaDV;
    protected int SoLuong;

    CheckLoi check = new CheckLoi();

    Scanner scanner = new Scanner(System.in);
    public ChiTietHoaDon()
    {
        this.MaHD = null;
        this.MaPhong = null;
        this.SoNgayO = 0;
        this.MaDV = null;
        this.SoLuong = 0;
    }
    public ChiTietHoaDon(String maHD, String maPhong, int soNgayO, String maDV, int soLuong) {
        MaHD = maHD;
        MaPhong = maPhong;
        SoNgayO = soNgayO;
        MaDV = maDV;
        SoLuong = soLuong;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public void setSoNgayO(int soNgayO) {
        SoNgayO = soNgayO;
    }

    public void setMaDV(String maDV) {
        MaDV = maDV;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public void setMaHD() {
        MaHD = check.KiemTraMaHD();
    }

    public void setMaPhong() {
        MaPhong = check.KiemTraMaPhong();
    }

    public void setSoNgayO() {
        SoNgayO = check.KiemTraKieuInt();
    }

    public void setMaDV() {
        MaDV = check.KiemTraMaDV();
    }

    public void setSoLuong() {
        SoLuong = check.KiemTraKieuInt();
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public int getSoNgayO() {
        return SoNgayO;
    }

    public String getMaDV() {
        return MaDV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void Nhap()
    {
        System.out.print("Nhập mã hóa đơn: ");
        this.setMaHD();
        System.out.print("Nhập mã phòng: ");
        this.setMaPhong();
        System.out.print("Nhập số ngày ở: ");
        this.setSoNgayO();
        System.out.print("Nhập mã dịch vụ: ");
        this.setMaDV();
        System.out.print("Nhập số lượng dịch vụ: ");
        this.setSoLuong();
    }
    @Override
    public String toString() {
        return String.format("|%-20s|%-20s|%-15s|%-20s|%-15s|\n", MaHD, MaPhong, SoNgayO, MaDV, SoLuong);
    }

    public String Ghifile(){
        return getMaHD()+";"+getMaPhong()+";"+getSoNgayO()+";"+getMaDV()+";"+getSoLuong();
    }
}
