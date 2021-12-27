package PhieuThue;

import DuLieu.CheckLoi;

import java.util.Scanner;
import DuLieu.CheckLoi;

public class PhieuThue {
    protected String MaPT;
    protected String NgayLap;
    protected String MaCC;
    protected String HoTenKH;
    protected String MaPhong;
    protected int SoNgayO;
    CheckLoi check = new CheckLoi();

    Scanner scanner = new Scanner(System.in);
    public PhieuThue()
    {
        this.MaPT = null;
        this.NgayLap = null;
        this.MaCC = null;
        this.HoTenKH = null;
        this.MaPhong = null;
        this.SoNgayO = 0;
    }
    public PhieuThue(String maPT, String ngayLap, String maCC, String hoTenKH, String MaPhong, int SoNgayO) {
        this.MaPT = maPT;
        this.NgayLap = ngayLap;
        this.MaCC = maCC;
        this.HoTenKH = hoTenKH;
        this.MaPhong = MaPhong;
        this.SoNgayO = SoNgayO;
    }

    public String getMaPT() {return MaPT;}
    public String getNgayLap() {return NgayLap;}
    public String getMaCC() {return MaCC;}
    public String getHoTenKH() {return HoTenKH;}
    public String getMaPhong() {return MaPhong;}
    public int getSoNgayO() {
        return SoNgayO;
    }

    public void setMaPT(String maPT) {
        MaPT = maPT;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public void setMaCC(String maCC) {
        MaCC = maCC;
    }

    public void setHoTenKH(String hoTenKH) {
        HoTenKH = hoTenKH;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public void setSoNgayO(int SoNgayO) {
        SoNgayO = SoNgayO;
    }
    public void setMaPT() {
        MaPT = check.KiemTraMaPT();
    }

    public void setNgayLap() {
        NgayLap = check.KiemTraNgayThang();
    }

    public void setMaCC() {
        MaCC = check.KiemTraNhapMaCC();
    }

    public void setHoTenKH() {
        HoTenKH = check.KiemTraNhapTen();
    }

    public void setMaPhong() {
        MaPhong = check.KiemTraMaPhong();
    }

    public void setSoNgayO() {
        SoNgayO = scanner.nextInt();
    }
    public void Nhap()
    {
        System.out.print("Nhập mã phiếu thuê: ");
        this.setMaPT();
        System.out.print("Nhập ngày thuê: ");
        this.setNgayLap();
        System.out.print("Nhập mã căn cước khách hàng: ");
        this.setMaCC();
        System.out.print("Nhập họ tên khách hàng: ");
        this.setHoTenKH();
        System.out.print("Nhập mã phòng: ");
        this.setMaPhong();
        System.out.print("Nhập số ngày ở: ");
        this.setSoNgayO();
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-15s|%-20s|%-25s|%-20s|%-15s|\n", MaPT, NgayLap, MaCC, HoTenKH, MaPhong, SoNgayO);
    }
    public String Ghifile() {
        return getMaPT()+";"+getNgayLap()+";"+getMaCC()+";"+getHoTenKH()+";"+getMaPhong()+";"+getSoNgayO();
    }}
