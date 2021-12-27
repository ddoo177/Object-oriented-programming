package NhanVien;
import java.util.Scanner;

public class QuanLy extends NhanVien {
    Scanner sc = new Scanner(System.in);

    public QuanLy() {
        super();
    }

    public QuanLy(String MaNV, String Chucvu, long Luongcoban, String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi) {
        super(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi);
    }

    public void Nhap() {
        super.Nhap();
        this.setChucvu("Quản lý");
        this.setLuongcoban(200000);
    }
    @Override
    public long Tinhluong() {
        return (long) (getLuongcoban() * 3 * 30);
    }
    public static void main(String[] args) {
        QuanLy ql = new QuanLy();
        ql.Nhap();
        System.out.println(ql);
    }
    
}
