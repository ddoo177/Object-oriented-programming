package NhanVien;
import java.util.Scanner;

public class PhucVu extends NhanVien {
    Scanner sc = new Scanner(System.in);

    public PhucVu() {
        super();
    }

    public PhucVu(String MaNV, String Chucvu, long Luongcoban, String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi) {
        super(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi);
    }

    public void Nhap() {
        super.Nhap();
        this.setChucvu("Phục vụ");
        this.setLuongcoban(200000);
    }
    @Override
    public long Tinhluong() {
        return (long) (getLuongcoban() * 2 * 30);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public static void main(String[] args) {
        PhucVu pv = new PhucVu();
        pv.Nhap();
        System.out.println(pv);
    }
    
}
