import DichVu.DanhSachDichVu;
import HoaDon.DanhSachChiTietHD;
import HoaDon.DanhSachHoaDon;
import KhachHang.DanhSachKhachHang;
import NhanVien.DanhSachNhanVien;
import PhieuThue.DanhSachPhieuThue;
import Phong.DanhSachChiTietPhong;
import Phong.DanhSachPhong;
import Phong.DanhSachTienNghi;
import TaiKhoan.DanhSachTaiKhoan;
import TaiKhoan.TaiKhoan;
import DuLieu.CheckLoi;

import java.util.Scanner;

public class Menu
{
    static Scanner scanner = new Scanner(System.in);

    private final DanhSachTaiKhoan dstk = new DanhSachTaiKhoan();
    private final DanhSachNhanVien dsnv = new DanhSachNhanVien();
    private final DanhSachKhachHang dskh = new DanhSachKhachHang();
    private final DanhSachPhong dsp = new DanhSachPhong();
    private final DanhSachDichVu dsdv = new DanhSachDichVu();
    private final DanhSachChiTietPhong dsctp = new DanhSachChiTietPhong();
    private final DanhSachTienNghi dstn = new DanhSachTienNghi();
    private final DanhSachPhieuThue dspt = new DanhSachPhieuThue();
    private final DanhSachHoaDon dshd = new DanhSachHoaDon();
    private final DanhSachChiTietHD dscthd = new DanhSachChiTietHD();
    private final CheckLoi check = new CheckLoi();

    public void Menu()
    {
        int chon;
        do {
            dstk.DocfileTK();
            System.out.println("\n============================================");
            System.out.println("||             MENU ĐĂNG NHẬP             ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Quản lý || Nhân viên                ||");
            System.out.println("|| 2. Khách hàng                          ||");
            System.out.println("|| 0. Thoát                               ||");
            System.out.println("============================================");
            System.out.print("Bạn muốn đăng nhập với tư cách: ");
            chon = check.KiemTraKieuInt();
            switch (chon) {
                case 1 -> MenuStaff();
                case 2 -> MenuKhachHang();
            }
        }
        while(chon!=0);
    }
    public void MenuStaff()
    {
        int staff;
        do {
            System.out.println("\n============================================");
            System.out.println("||          QUẢN LÝ || NHÂN VIÊN          ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Quản lý                             ||");
            System.out.println("|| 2. Nhân viên                           ||");
            System.out.println("|| 0. Thoát                               ||");
            System.out.println("============================================");
            System.out.print("Bạn muốn đăng nhập với tư cách: ");
            staff = check.KiemTraKieuInt();
            switch (staff) {
                case 1 -> {
                    System.out.println("\n============================================");
                    System.out.println("||       ĐĂNG NHẬP TÀI KHOẢN QUẢN LÝ      ||");
                    System.out.println("============================================");
                    DangNhapStaff();
                }
                case 2 -> MenuNhanVien();
            }
        }while(staff!=0);
    }
    public void MenuNhanVien()
    {
        int nvien;
        System.out.println("\n============================================");
        System.out.println("||                NHÂN VIÊN               ||");
        System.out.println("||________________________________________||");
        System.out.println("|| 1. Đăng ký                             ||");
        System.out.println("|| 2. Đăng nhập                           ||");
        System.out.println("|| 0. Thoát                               ||");
        System.out.println("============================================");
        System.out.print("Ban muốn: ");
        nvien = check.KiemTraKieuInt();
        switch (nvien) {
            case 1 -> {
                System.out.println("\n============================================");
                System.out.println("||       ĐĂNG KÝ TÀI KHOẢN NHÂN VIÊN      ||");
                System.out.println("============================================");
                DangKy();
            }
            case 2 -> {
                System.out.println("\n============================================");
                System.out.println("||      ĐĂNG NHẬP TÀI KHOẢN NHÂN VIÊN     ||");
                System.out.println("============================================");
                DangNhapStaff();
            }
            default ->
                System.out.println("Hãy chọn lại: ");
        }
    }
    public void MenuKhachHang()
    {
        int  customer;
        do {
            System.out.println("\n============================================");
            System.out.println("||               KHÁCH HÀNG               ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Đăng ký                             ||");
            System.out.println("|| 2. Đăng nhập                           ||");
            System.out.println("|| 0. Thoát                               ||");
            System.out.println("============================================");
            System.out.print("Ban muốn: ");
            customer = check.KiemTraKieuInt();
            switch (customer) {
                case 1 -> {
                    System.out.println("\n============================================");
                    System.out.println("||      ĐĂNG KÝ TÀI KHOẢN KHÁCH HÀNG      ||");
                    System.out.println("============================================");
                    DangKy();
                }
                case 2 -> {
                    System.out.println("\n============================================");
                    System.out.println("||     ĐĂNG NHẬP TÀI KHOẢN KHÁCH HÀNG     ||");
                    System.out.println("============================================");
                    DangNhapKhachHang();
                }
                default ->  System.out.println("Hãy chọn lại: ");
            }
        }
        while(customer!=0);
    }
    public void DangNhapStaff()
    {
        String TaiKhoan, MatKhau;
        System.out.print("Nhập tài khoản: ");
        TaiKhoan = scanner.next();
        System.out.print("Nhập mật khẩu: ");
        MatKhau = scanner.next();
        TaiKhoan temp = new TaiKhoan(TaiKhoan, MatKhau);
        if(dstk.DangNhapAdmin(temp))
            Admin();
        else if(dstk.DangNhap(temp))
            NhanVien();
        else
            System.out.println("Tài khoản hoặc mật khẩu không đúng");
    }
    public void DangNhapKhachHang()
    {
        String TaiKhoan, MatKhau;
        System.out.print("Nhập tài khoản: ");
        TaiKhoan = scanner.next();
        System.out.print("Nhập mật khẩu: ");
        MatKhau = scanner.next();
        TaiKhoan temp = new TaiKhoan(TaiKhoan, MatKhau);
        if(dstk.DangNhap(temp))
            KhachHang();
        else
            System.out.println("Tài khoản hoặc mật khẩu không đúng...");
    }
    public void DangKy()
    {
        String TaiKhoan, MatKhau, MatKhau2;
        System.out.print("Nhập tài khoản: ");
        TaiKhoan = scanner.next();
        System.out.print("Nhập mật khẩu: ");
        MatKhau = scanner.next();
        System.out.print("Nhắc lại mật khẩu: ");
        MatKhau2 = scanner.next();
        while(!MatKhau2.equals(MatKhau))
        {
            System.out.println("Nhắc lại mật khẩu không đúng...");
            System.out.print("Nhắc lại mật khẩu: ");
            MatKhau2 = scanner.next();
        }
        TaiKhoan tk = new TaiKhoan(TaiKhoan,MatKhau);
        dstk.DangKy(tk);
        System.out.println("Đăng ký tài khoản thành công !");
    }
    public void Admin()
    {
        int chon;
        System.out.println("\nĐăng nhập với tư cách Admin thành công");
        do
        {
            System.out.println("\n============================================");
            System.out.println("||                 QUẢN LÝ                ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Quản lý nhân viên                   ||");
            System.out.println("|| 2. Quản lý phòng                       ||");
            System.out.println("|| 3. Quản lý dịch vụ                     ||");
            System.out.println("|| 4. Quản lý tiện nghi                   ||");
            System.out.println("|| 5. Quản lý phiếu thuê                  ||");
            System.out.println("|| 6. Quản lý hóa đơn                     ||");
            System.out.println("|| 7. Quản lý khách hàng                  ||");
            System.out.println("|| 8. Quản lý tài khoản                   ||");
            System.out.println("|| 0. Thoát                               ||");
            System.out.println("============================================");
            System.out.print("Bạn muốn: ");
            chon = check.KiemTraKieuInt();
            switch (chon)
            {
                case 1:
                {
                    dsnv.DocfileNV();
                    int chon1;
                    do
                    {
                        System.out.println("\n=============QUẢN LÝ NHÂN VIÊN=============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon1 = check.KiemTraKieuInt();
                        switch (chon1)
                        {
                            case 1:
                                dsnv.XuatNhanVien();
                                break;
                            case 2:
                                dsnv.Them();
                                break;
                            case 3:
                                dsnv.Sua();
                                break;
                            case 4:
                                dsnv.Xoa();
                                break;
                            case 5:
                                dsnv.TimKiemNhanVien();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon1 != 0);
                    dsnv.GhifileNV();
                    break;
                }
                case 2:
                {
                    dsp.DocfileP();
                    int chon2;
                    do
                    {
                        System.out.println("\n================QUẢN LÝ PHÒNG==============");
                        System.out.println("|| 1. Hiển thị danh sách phòng           ||");
                        System.out.println("|| 2. Hiển thị chi tiết phòng            ||");
                        System.out.println("|| 3. Thêm                               ||");
                        System.out.println("|| 4. Sửa                                ||");
                        System.out.println("|| 5. Xóa                                ||");
                        System.out.println("|| 6. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon2 = check.KiemTraKieuInt();
                        switch (chon2)
                        {
                            case 1:
                                dsp.XuatPhong();
                                break;
                            case 2:
                                dsctp.DocfileCTP();
                                dsctp.Xuat();
                                break;
                            case 3:
                                dsp.Them();
                                break;
                            case 4:
                                dsp.Sua();
                                break;
                            case 5:
                                dsp.Xoa();
                                break;
                            case 6:
                                dsp.TimKiemPhong();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon2 != 0);
                    dsp.GhifileP();
                    break;
                }
                case 3:
                {
                    dsdv.DocFileDV();
                    int chon3;
                    do
                    {
                        System.out.println("\n=============QUẢN LÝ DỊCH VỤ===============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon3 = check.KiemTraKieuInt();
                        switch (chon3)
                        {
                            case 1:
                                dsdv.Xuat();
                                break;
                            case 2:
                                dsdv.Them();
                                break;
                            case 3:
                                dsdv.Sua();
                                break;
                            case 4:
                                dsdv.Xoa();
                                break;
                            case 5:
                                dsdv.Timkiem();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon3 != 0);
                    dsdv.GhiFileDV();
                    break;
                }
                case 4:
                {
                    dstn.DocfileTN();
                    int chon4;
                    do
                    {
                        System.out.println("\n=============QUẢN LÝ TIỆN NGHI=============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon4 = check.KiemTraKieuInt();
                        switch (chon4)
                        {
                            case 1:
                                dstn.XuatTienNghi();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon4 != 0);
                    break;
                }
                case 5:
                {
                    dspt.DocfilePT();
                    int chon5;
                    do
                    {
                        System.out.println("\n============QUẢN LÝ PHIẾU THUÊ=============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon5 = check.KiemTraKieuInt();
                        switch (chon5)
                        {
                            case 1:
                                dspt.Xuat();
                                break;
                            case 2:
                                dspt.Them();
                                break;
                            case 3:
                                dspt.Sua();
                                break;
                            case 4:
                                dspt.Xoa();
                                break;
                            case 5:
                                dspt.Timkiem();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon5 != 0);
                    dspt.GhifilePT();
                    break;
                }
                case 6:
                {
                    dshd.DocfileHD();
                    int chon6;
                    do
                    {
                        System.out.println("\n==============QUẢN LÝ HÓA ĐƠN==============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 6. Quản lý chi tiết hóa đơn           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon6 = check.KiemTraKieuInt();
                        switch (chon6)
                        {
                            case 1:
                                dshd.Xuat();
                                break;
                            case 2:
                                dshd.Them();
                                break;
                            case 3:
                                dshd.Sua();
                                break;
                            case 4:
                                dshd.Xoa();
                                break;
                            case 5:
                                dshd.Timkiem();
                                break;
                            case 6:
                            {
                                dscthd.DocfileCTHD();
                                int cthd;
                                do {
                                    System.out.println("\n==========QUẢN LÝ CHI TIẾT HĐ==========");
                                    System.out.println("|| 1. Hiển thị                       ||");
                                    System.out.println("|| 2. Thêm                           ||");
                                    System.out.println("|| 0. Thoát                          ||");
                                    System.out.println("=======================================");
                                    System.out.print("Bạn muốn: ");
                                    cthd = check.KiemTraKieuInt();
                                    switch (cthd)
                                    {
                                        case 1:
                                            dscthd.Xuat();
                                            break;
                                        case 2:
                                            dscthd.Them();
                                            break;
                                        default:
                                                System.out.println("Hãy chọn lại: ");
                                    }
                                }while(cthd != 0);
                                dscthd.GhifileCTHD();
                                break;
                            }
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon6 != 0);
                    dshd.GhifileHD();
                    break;
                }
                case 7:
                {
                    dskh.DocfileKH();
                    int chon7;
                    do
                    {
                        System.out.println("\n============QUẢN LÝ KHÁCH HÀNG=============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon7 = check.KiemTraKieuInt();
                        switch (chon7)
                        {
                            case 1:
                                dskh.Xuat();
                                break;
                            case 2:
                                dskh.Them();
                                break;
                            case 3:
                                dskh.Sua();
                                break;
                            case 4:
                                dskh.Xoa();
                                break;
                            case 5:
                                dskh.Timkiem();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon7 != 0);
                    dskh.GhifileKH();
                    break;
                }
                case 8:
                {
                    dstk.DocfileTK();
                    int chon8;
                    do
                    {
                        System.out.println("\n============QUẢN LÝ TÀI KHOẢN==============");
                        System.out.println("|| 1. Hiển thị danh sách tài khoản       ||");
                        System.out.println("|| 2. Thêm tài khoản                     ||");
                        System.out.println("|| 3. Đổi mật khẩu                       ||");
                        System.out.println("|| 4. Xóa tài khoản                      ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon8 = check.KiemTraKieuInt();
                        switch (chon8)
                        {
                            case 1:
                                dstk.Xuat();
                                break;
                            case 2:
                                dstk.Them();
                                break;
                            case 3:
                                dstk.Sua();
                                break;
                            case 4:
                                dstk.Xoa();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon8 != 0);
                    dstk.GhifileTK();
                    break;
                }
                case 0:
                {
                    MenuStaff();
                }
            }
        }while(chon != 0);
    }
    public void NhanVien()
    {
        System.out.println("\nĐăng nhập với tư cách Nhân viên thành công");
        int chon;
        do
        {
            System.out.println("\n============================================");
            System.out.println("||                NHÂN VIÊN               ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Quản lý phòng                       ||");
            System.out.println("|| 2. Quản lý dịch vụ                     ||");
            System.out.println("|| 3. Quản lý tiện nghi                   ||");
            System.out.println("|| 4. Quản lý phiếu thuê                  ||");
            System.out.println("|| 5. Quản lý hóa đơn                     ||");
            System.out.println("|| 6. Quản lý khách hàng                  ||");
            System.out.println("|| 0. Thoát                               ||");
            System.out.println("============================================");
            System.out.print("Bạn muốn: ");
            chon = check.KiemTraKieuInt();
            switch (chon)
            {
                case 1:
                {
                    dsp.DocfileP();
                    int chon1;
                    do
                    {
                        System.out.println("\n================QUẢN LÝ PHÒNG==============");
                        System.out.println("|| 1. Hiển thị danh sách phòng           ||");
                        System.out.println("|| 2. Hiển thị chi tiết phòng            ||");
                        System.out.println("|| 3. Thêm                               ||");
                        System.out.println("|| 4. Sửa                                ||");
                        System.out.println("|| 5. Xóa                                ||");
                        System.out.println("|| 6. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon1 = check.KiemTraKieuInt();
                        switch (chon1)
                        {
                            case 1:
                                dsp.XuatPhong();
                                break;
                            case 2:
                                dsctp.Xuat();
                                break;
                            case 3:
                                dsp.Them();
                                break;
                            case 4:
                                dsp.Sua();
                                break;
                            case 5:
                                dsp.Xoa();
                                break;
                            case 6:
                                dsp.TimKiemPhong();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon1 != 0);
                    dsp.GhifileP();
                    break;
                }
                case 2:
                {
                    dsdv.DocFileDV();
                    int chon2;
                    do
                    {
                        System.out.println("\n===========QUẢN LÝ DỊCH VỤ=============");
                        System.out.println("|| 1. Hiển thị                       ||");
                        System.out.println("|| 2. Thêm                           ||");
                        System.out.println("|| 3. Sửa                            ||");
                        System.out.println("|| 4. Xóa                            ||");
                        System.out.println("|| 5. Tìm kiếm                       ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.print("Bạn muốn: ");
                        chon2 = check.KiemTraKieuInt();
                        switch (chon2)
                        {
                            case 1:
                                dsdv.Xuat();
                                break;
                            case 2:
                                dsdv.Them();
                                break;
                            case 3:
                                dsdv.Sua();
                                break;
                            case 4:
                                dsdv.Xoa();
                                break;
                            case 5:
                                dsdv.Timkiem();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon2 != 0);
                    dsdv.GhiFileDV();
                    break;
                }
                case 3:
                {
                    dstn.DocfileTN();
                    int chon3;
                    do
                    {
                        System.out.println("\n===========QUẢN LÝ TIỆN NGHI===========");
                        System.out.println("|| 1. Hiển thị                       ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.print("Bạn muốn: ");
                        chon3 = check.KiemTraKieuInt();
                        switch (chon3)
                        {
                            case 1:
                                dstn.XuatTienNghi();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon3 != 0);
                    break;
                }
                case 4:
                {
                    dspt.DocfilePT();
                    int chon4;
                    do
                    {
                        System.out.println("\n==========QUẢN LÝ PHIẾU THUÊ===========");
                        System.out.println("|| 1. Hiển thị                       ||");
                        System.out.println("|| 2. Thêm                           ||");
                        System.out.println("|| 3. Sửa                            ||");
                        System.out.println("|| 4. Xóa                            ||");
                        System.out.println("|| 5. Tìm kiếm                       ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.print("Bạn muốn: ");
                        chon4 = check.KiemTraKieuInt();
                        switch (chon4)
                        {
                            case 1:
                                dspt.Xuat();
                                break;
                            case 2:
                                dspt.Them();
                                break;
                            case 3:
                                dspt.Sua();
                                break;
                            case 4:
                                dspt.Xoa();
                                break;
                            case 5:
                                dspt.Timkiem();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon4 != 0);
                    dspt.GhifilePT();
                    break;
                }
                case 5:
                {
                    dshd.DocfileHD();
                    int chon6;
                    do
                    {
                        System.out.println("\n==============QUẢN LÝ HÓA ĐƠN==============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 6. Quản lý chi tiết hóa đơn           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon6 = check.KiemTraKieuInt();
                        switch (chon6)
                        {
                            case 1:
                                dshd.Xuat();
                                break;
                            case 2:
                                dshd.Them();
                                break;
                            case 3:
                                dshd.Sua();
                                break;
                            case 4:
                                dshd.Xoa();
                                break;
                            case 5:
                                dshd.Timkiem();
                                break;
                            case 6:
                            {
                                dscthd.DocfileCTHD();
                                int cthd;
                                do {
                                    System.out.println("\n==========QUẢN LÝ CHI TIẾT HĐ==========");
                                    System.out.println("|| 1. Hiển thị                       ||");
                                    System.out.println("|| 2. Thêm                           ||");
                                    System.out.println("|| 0. Thoát                          ||");
                                    System.out.println("=======================================");
                                    System.out.print("Bạn muốn: ");
                                    cthd = check.KiemTraKieuInt();
                                    switch (cthd)
                                    {
                                        case 1:
                                            dscthd.Xuat();
                                            break;
                                        case 2:
                                            dscthd.Them();
                                            break;
                                        default:
                                            System.out.println("Hãy chọn lại: ");
                                    }
                                }while(cthd != 0);
                                dscthd.GhifileCTHD();
                                break;
                            }
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon6 != 0);
                    dshd.GhifileHD();
                    break;
                }
                case 6:
                {
                    dskh.DocfileKH();
                    int chon6;
                    do
                    {
                        System.out.println("\n============QUẢN LÝ KHÁCH HÀNG=============");
                        System.out.println("|| 1. Hiển thị                           ||");
                        System.out.println("|| 2. Thêm                               ||");
                        System.out.println("|| 3. Sửa                                ||");
                        System.out.println("|| 4. Xóa                                ||");
                        System.out.println("|| 5. Tìm kiếm                           ||");
                        System.out.println("|| 0. Thoát                              ||");
                        System.out.println("===========================================");
                        System.out.print("Bạn muốn: ");
                        chon6 = check.KiemTraKieuInt();
                        switch (chon6)
                        {
                            case 1:
                                dskh.Xuat();
                                break;
                            case 2:
                                dskh.Them();
                                break;
                            case 3:
                                dskh.Sua();
                                break;
                            case 4:
                                dskh.Xoa();
                                break;
                            case 5:
                                dskh.Timkiem();
                                break;
                            default:
                                System.out.println("Hãy chọn lại: ");
                        }
                    }while(chon6 != 0);
                    dskh.GhifileKH();
                    break;
                }
                default:
                    System.out.println("Hãy chọn lại: ");
            }
        }while(chon != 0);
    }
    public void KhachHang()
    {
        System.out.println("\nĐăng nhập với tư cách Khách hàng thành công");
        int chon;
        do
        {

            System.out.println("\n============================================");
            System.out.println("||                KHÁCH HÀNG              ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Xem danh sách phòng                 ||");
            System.out.println("|| 2. Xem danh sách dịch vụ               ||");
            System.out.println("|| 3. Đặt phòng                           ||");
            System.out.println("|| 4. Đổi mật khẩu                        ||");
            System.out.println("|| 0. Thoát                               ||");
            System.out.println("============================================");
            System.out.print("Bạn muốn: ");
            chon = check.KiemTraKieuInt() ;
            switch (chon)
            {
                case 1:
                    dsp.DocfileP();
                    dsp.XuatPhong();
                    break;
                case 2:
                    dsdv.DocFileDV();
                    dsdv.Xuat();
                    break;
                case 3:
                    dsp.DocfileP();
                    dsp.XuatPhong();
                    dspt.Them();
                    dspt.GhifilePT();
                    break;
                case 4:
                    dstk.Sua();
                    dstk.GhifileTK();
                    break;
                default:
                    System.out.println("Hãy chọn lại: ");
            }
        }while(chon != 0);
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.Menu();
    }
}