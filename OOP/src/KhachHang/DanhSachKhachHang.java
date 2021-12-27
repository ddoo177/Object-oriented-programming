package KhachHang;

import DuLieu.Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachKhachHang implements Interface {

    Scanner sc = new Scanner(System.in);

    private ArrayList<KhachHang> DSKH = new ArrayList<KhachHang>();

    public DanhSachKhachHang() {
        this.DSKH = new ArrayList<>();
    }

    public DanhSachKhachHang(ArrayList<KhachHang> danhSachKhachHang) {
        this.DSKH = danhSachKhachHang;
    }

    public void setDSKH(ArrayList<KhachHang> DSKH) {
        this.DSKH = DSKH;
    }

    public ArrayList<KhachHang> getDSKH() {
        return DSKH;
    }

    public Boolean Kiemtra(String tmp) {
        for (int i = 0; i < DSKH.size(); i++) {
            if (DSKH.get(i).getMaCC().equals(tmp)) {
                return true;
            }
        }
        return false;
    }

    public void Them() {
        System.out.print("Nhập số lượng khách hàng cần thêm: ");
        int soluong = sc.nextInt();
        System.out.println();
        for (int i = 0; i < soluong; i++) {
            System.out.println("Nhập thông tin Khách hàng mới: ");
            KhachHang kh = new KhachHang();
            kh.Nhap();
            while (Kiemtra(kh.getMaCC())) {
                System.out.println("Mã căn cước của khách hàng này đã tồn tại");
                System.out.print("Hãy nhập lại mã căn cước: ");
                kh.setMaCC();
            }
            this.DSKH.add(kh);
            System.out.println();
        }
    }

    public void Sua() {
        System.out.println("Nhập mã khách hàng muốn sửa: ");
        String tmp = sc.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < DSKH.size(); i++) {
                if (DSKH.get(i).getMaCC().equals(tmp)) {
                    int choice;
                    do {
                        System.out.println("\n============SỬA THÔNG TIN============");
                        System.out.println("|| 1. Họ tên                         ||");
                        System.out.println("|| 2. Giới tính                      ||");
                        System.out.println("|| 3. Ngày sinh                      ||");
                        System.out.println("|| 4. Số điện thoại                  ||");
                        System.out.println("|| 5. Địa chỉ                        ||");
                        System.out.println("|| 6. Mã căn cước                    ||");
                        System.out.println("|| 7. Quốc tịch                      ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.println("Bạn muốn sửa thông tin: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1 -> {
                                System.out.print("Nhập họ tên mới: ");
                                DSKH.get(i).setHoten();
                                System.out.println("Sửa thành công");
                            }
                            case 2 -> {
                                System.out.print("Nhập giới tính mới: ");
                                DSKH.get(i).setGioitinh();
                                System.out.println("Sửa thành công");
                            }
                            case 3 -> {
                                System.out.print("Nhập ngày sinh mới: ");
                                DSKH.get(i).setNgaysinh();
                                System.out.println("Sửa thành công");
                            }
                            case 4 -> {
                                System.out.print("Nhập số điện thoại mới: ");
                                DSKH.get(i).setDienthoai();
                                System.out.println("Sửa thành công");
                            }
                            case 5 -> {
                                System.out.print("Nhập địa chỉ mới: ");
                                DSKH.get(i).setDiachi();
                                System.out.println("Sửa thành công");
                            }
                            case 6 -> {
                                System.out.print("Nhập mã căn cước mới: ");
                                String macctmp = sc.nextLine();
                                if (Kiemtra(macctmp)) {
                                    System.out.println("Sửa thất bại");
                                    System.out.println("Mã căn cước này đã tồn tại");
                                } else {
                                    DSKH.get(i).setMaCC(macctmp);
                                    System.out.println("Sửa thành công");
                                }
                            }
                            case 7 -> {
                                System.out.print("Nhập quốc tịch mới: ");
                                DSKH.get(i).setQuoctich();
                                System.out.println("Sửa thành công");
                            }
                            default ->
                                    System.out.println("Hãy chọn lại: ");
                        }
                    } while (choice != 0);
                }
            }
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    public void Xoa() {
        System.out.print("Nhập mã khách hàng muốn xóa: ");
        String tmp = sc.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < DSKH.size(); i++) {
                if (DSKH.get(i).getMaCC().equals(tmp)) {
                    DSKH.remove(i);
                    System.out.println("Xóa khách hàng thành công!");
                    break;
                }
            }
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    public void Timkiem() {
        System.out.println("Nhập mã khách hàng cần tìm: ");
        String tmp = sc.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < DSKH.size(); i++) {
                if (DSKH.get(i).getMaCC().equals(tmp)) {
                    System.out.println("|================================================================================================================================================================================|");
                    System.out.printf("|%-20s|%-15s|%-18s|%-20s|%-20s|%-20s|%-15s|\n", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Căn cước", "Quốc tịch");
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                    System.out.print(DSKH.get(i));
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                }
            }
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    public void Xuat() {
        if (DSKH.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("|======================================================================================================================================|");
            System.out.printf("|%-20s|%-15s|%-18s|%-20s|%-20s|%-20s|%-15s|\n", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Căn cước", "Quốc tịch");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for (int i = 0; i < DSKH.size(); i++) {
                System.out.print(DSKH.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|");
            }
        }
    }

    public void DocfileKH() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachKhachHang.txt");
            BufferedReader br = new BufferedReader(fr);

            DSKH = new ArrayList<KhachHang>();
            String line;
            String Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi, MaCC, Quoctich;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                Hoten = txt[0];
                Gioitinh = txt[1];
                Ngaysinh = txt[2];
                Dienthoai = txt[3];
                Diachi = txt[4];
                MaCC = txt[5];
                Quoctich = txt[6];
                DSKH.add(new KhachHang(Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi, MaCC, Quoctich));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhifileKH() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachKhachHang.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (KhachHang i : DSKH) {
                bw.write(i.Ghifile());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
