package NhanVien;
import java.util.Scanner;

public class BaoVe extends NhanVien {
    Scanner sc = new Scanner(System.in);

    public BaoVe() {
        super();
    }

    public BaoVe(String MaNV, String Chucvu, long Luongcoban, String Hoten, String Gioitinh, String Ngaysinh, String Dienthoai, String Diachi) {
        super(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi);
    }

    public void Nhap() {
        super.Nhap();
        this.setChucvu("Bảo vệ");
        this.setLuongcoban(200000);
    }
    @Override
    public long Tinhluong() {
        return (long) (getLuongcoban() * 1.5 * 30);
    }

    public static void main(String[] args) {
        BaoVe ql = new BaoVe();
        ql.Nhap();
        System.out.println(ql);
    }
}
