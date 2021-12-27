package NhanVien;
import java.util.Scanner;
import DuLieu.CheckLoi;

public class ConNguoi {
    Scanner sc=new Scanner(System.in);
    protected String Hoten;
    protected String Gioitinh;
    protected String Ngaysinh;
    protected String Dienthoai;
    protected String Diachi;
    CheckLoi check = new CheckLoi();

    //Constructor
    public ConNguoi() {
        Hoten=null;
        Gioitinh=null;
        Ngaysinh=null;
        Dienthoai=null;
        Diachi=null;
    }

    public ConNguoi(String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi) {
        this.Hoten = Hoten;
        this.Gioitinh = Gioitinh;
        this.Ngaysinh = Ngaysinh;
        this.Dienthoai = Dienthoai;
        this.Diachi = Diachi;
    }
//Get
    public String getHoten() {
        return Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public String getDienthoai() {
        return Dienthoai;
    }

    public String getDiachi() {
        return Diachi;
    }
//Set

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }
    
    public void setHoten() {
        this.Hoten = check.KiemTraNhapTen();
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public void setGioitinh() {
        this.Gioitinh = sc.nextLine();
    }
    
    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    
    public void setNgaysinh() {
        this.Ngaysinh = sc.nextLine();
    }

    public void setDienthoai(String Dienthoai) {
        this.Dienthoai = Dienthoai;
    }

    public void setDienthoai() {
        this.Dienthoai = sc.nextLine();
    }
    
    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }
    
    public void setDiachi() {
        this.Diachi = sc.nextLine();
    }
    public String Ghifile(){
        return getHoten()+";"+getGioitinh()+";"+getNgaysinh()+";"+getDienthoai()+";"+ getDiachi();
    }
}
