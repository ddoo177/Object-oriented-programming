package NhanVien;
import java.util.Scanner;

public class LeTan extends NhanVien {
    Scanner sc = new Scanner(System.in);

    public LeTan() {
        super();
    }

    public LeTan(String MaNV, String Chucvu, long Luongcoban, String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi) {
        super(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi);
    }
    @Override
    public void Nhap() {
        super.Nhap();
        this.setChucvu("Lễ tân");
        this.setLuongcoban(200000);
    }

    @Override
    public long Tinhluong() {
        return (long) (getLuongcoban() * 2.5 * 30);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public static void main(String[] args) {
        LeTan ql = new LeTan();
        ql.Nhap();
        System.out.println(ql);
    }
    
}
