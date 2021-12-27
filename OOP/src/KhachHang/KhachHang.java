package KhachHang;

import java.util.Scanner;
import NhanVien.ConNguoi;
import DuLieu.CheckLoi;

public class KhachHang extends ConNguoi {

    Scanner sc = new Scanner(System.in);
    private String MaCC;
    private String Quoctich;
    CheckLoi check = new CheckLoi();

//Constructor

    public KhachHang() {
        super();
        MaCC = "Null";
        Quoctich = "Null";
    }

    public KhachHang(String MaCC, String Quoctich) {
        this.MaCC = MaCC;
        this.Quoctich = Quoctich;
    }

    public KhachHang(String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi, String MaCC, String Quoctich) {
        super(Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi);
        this.MaCC = MaCC;
        this.Quoctich = Quoctich;
    }
//Get

    public String getMaCC() {
        return MaCC;
    }

    public String getQuoctich() {
        return Quoctich;
    }
//Set

    public void setMaCC(String MaCC) {
        this.MaCC = MaCC;
    }

    public void setMaCC() {
        this.MaCC = check.KiemTraNhapMaCC();
    }

    public void setQuoctich(String Quoctich) {
        this.Quoctich = Quoctich;
    }

    public void setQuoctich() {
        this.Quoctich = sc.nextLine();
    }

    public void Nhap() {
        //super.Nhap();
        System.out.print("Nhập họ tên: ");
        this.setHoten();
        System.out.print("Nhập giới tính: ");
        this.setGioitinh();
        System.out.print("Nhập ngày sinh: ");
        this.setNgaysinh();
        System.out.print("Nhập số điện thoại: ");
        this.setDienthoai();
        System.out.print("Nhập địa chỉ: ");
        this.setDiachi();
        System.out.print("Nhập mã căn cước: ");
        this.setMaCC();
        System.out.print("Nhập quốc tịch: ");
        this.setQuoctich();
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-15s|%-18s|%-20s|%-20s|%-20s|%-15s|\n", Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi, MaCC, Quoctich);
    }
    @Override
    public String Ghifile(){
        return super.Ghifile()+";"+getMaCC()+";"+getQuoctich();
    }

}
