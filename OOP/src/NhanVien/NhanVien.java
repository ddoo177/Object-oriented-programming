package NhanVien;
import java.util.Scanner;
import DuLieu.CheckLoi;

public abstract class NhanVien extends ConNguoi {
    Scanner sc=new Scanner(System.in);
    protected String MaNV;
    protected String Chucvu;
    protected long Luongcoban;
    CheckLoi check = new CheckLoi();
//Constructor
    public NhanVien() {
        super();
        MaNV="Null";
        Chucvu="Null";
        Luongcoban=0;
    }

    public NhanVien(String MaNV, String Chucvu, long Luongcoban, String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi) {
        super(Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi);
        this.MaNV = MaNV;
        this.Chucvu = Chucvu;
        this.Luongcoban= Luongcoban;
    }
//Get
    public String getMaNV() {
        return MaNV;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public long getLuongcoban() {
        return Luongcoban;
    }
    
//Set
    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMaNV() {
        this.MaNV = check.KiemTraNhapMaNV();
    }
    
    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public void setChucvu() {
        this.Chucvu = sc.nextLine();
    }

    public void setLuongcoban(long Luongcoban) {
        this.Luongcoban = Luongcoban;
    }
    
    public void setLuongcoban() {
        this.Luongcoban = sc.nextLong();
    }

    public void Nhap(){
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
        System.out.print("Nhập mã nhân viên: ");
        this.setMaNV();
    }

    public abstract long Tinhluong();

    @Override
    public String toString() {
        return String.format("|%-20s|%-15s|%-18s|%-20s|%-20s|%-20s|%-15s|%-20s|%-20s|\n", Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi, MaNV, Chucvu, Luongcoban,Tinhluong());
    }
    @Override
    public String Ghifile(){
        return super.Ghifile()+";"+getMaNV()+";"+getChucvu()+";"+getLuongcoban()+";";
    }

    public static void main(String[] args)
    {

    }
}
