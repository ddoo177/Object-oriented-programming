package HoaDon;

import DuLieu.CheckLoi;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DanhSachHoaDon
{
    Scanner scanner = new Scanner(System.in);
    CheckLoi check = new CheckLoi();
    
    private ArrayList<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();

    public DanhSachHoaDon() {
        this.danhSachHoaDon = new ArrayList<>();
    }

    public DanhSachHoaDon(ArrayList<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    public void setdanhSachHoaDon(ArrayList<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    public ArrayList<HoaDon> getdanhSachHoaDon() {
        return danhSachHoaDon;
    }

    public Boolean Kiemtra(String tmp) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getMaHD().equals(tmp)) {
                return true;
            }
        }
        return false;
    }

    public void Them() {
        System.out.print("Nhập số lượng hóa đơn cần thêm: ");
        int soluong = scanner.nextInt();
        System.out.println();
        for (int i = 0; i < soluong; i++) {
            System.out.println("Nhập thông tin hóa đơn: ");
            HoaDon hd = new HoaDon();
            hd.Nhap();
            while (Kiemtra(hd.getMaHD())) {
                System.out.println("Mã hóa đơn này đã tồn tại");
                System.out.print("Hãy nhập lại mã hóa đơn: ");
                hd.setMaHD();
            }
            this.danhSachHoaDon.add(hd);
            System.out.println();
        }
    }

    public void Sua() {
        System.out.println("Nhập mã hóa đơn muốn sửa: ");
        String tmp = scanner.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                if (danhSachHoaDon.get(i).getMaHD().equals(tmp)) {
                    int choice;
                    do {
                        System.out.println("\n============SỬA THÔNG TIN============");
                        System.out.println("|| 1. Mã hóa đơn                     ||");
                        System.out.println("|| 2. Ngày lập                       ||");
                        System.out.println("|| 3. Mã phiếu thuê                  ||");
                        System.out.println("|| 4. Mã nhân viên                   ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.println("Bạn muốn sửa thông tin: ");
                        choice = check.KiemTraKieuInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 6 -> {
                                System.out.print("Nhập mã hóa đơn mới: ");
                                String mahdtmp = check.KiemTraMaHD();
                                if (Kiemtra(mahdtmp)) {
                                    System.out.println("Sửa thất bại");
                                    System.out.println("Mã hóa đơn này đã tồn tại");
                                } else {
                                    danhSachHoaDon.get(i).setMaHD(mahdtmp);
                                    System.out.println("Sửa thành công");
                                }
                            }
                            case 2 -> {
                                System.out.print("Nhập ngày lập mới: ");
                                danhSachHoaDon.get(i).setNgayLapHD();
                                System.out.println("Sửa thành công");
                            }
                            case 3 -> {
                                System.out.print("Nhập mã phiếu thuê mới: ");
                                danhSachHoaDon.get(i).setMaPT();
                                System.out.println("Sửa thành công");
                            }
                            case 4 -> {
                                System.out.print("Nhập mã nhân viên mới: ");
                                danhSachHoaDon.get(i).setMaNV();
                                System.out.println("Sửa thành công");
                            }
                            default ->
                                    System.out.println("Hãy chọn lại: ");
                        }
                    } while (choice != 0);
                }
            }
        } else {
            System.out.println("Không tìm thấy hóa đơn");
        }
    }

    public void Xoa() {
        System.out.print("Nhập mã hóa đơn muốn xóa: ");
        String tmp = scanner.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                if (danhSachHoaDon.get(i).getMaHD().equals(tmp)) {
                    danhSachHoaDon.remove(i);
                    System.out.println("Xóa hóa đơn thành công!");
                    break;
                }
            }
        } else {
            System.out.println("Không tìm thấy hóa đơn");
        }
    }

    public void Timkiem() {
        System.out.println("Nhập mã hóa đơn cần tìm: ");
        String tmp = scanner.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                if (danhSachHoaDon.get(i).getMaHD().equals(tmp)) {
                    System.out.println("|==================================================================================================|");
                    System.out.printf("|%-20s|%-15s|%-20s|%-20s|%-20s|\n", "Mã hóa đơn", "Ngày lập", "Mã phiếu thuê", "Mã nhân viên","Tổng tiền");
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                    System.out.print(danhSachHoaDon.get(i));
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                }
            }
        } else {
            System.out.println("Không tìm thấy hóa đơn");
        }
    }

    public void Xuat() {
        if (danhSachHoaDon.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("|===================================================================================================|");
            System.out.printf("|%-20s|%-15s|%-20s|%-20s|%-20s|\n", "Mã hóa đơn", "Ngày lập", "Mã phiếu thuê", "Mã nhân viên","Tổng tiền");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                System.out.print(danhSachHoaDon.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|");
            }
        }
    }


    public void DocfileHD() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachHoaDon.txt");
            BufferedReader br = new BufferedReader(fr);

            danhSachHoaDon = new ArrayList<HoaDon>();
            String line;
            String MaHD, NgayLapHD, MaPT, MaNV;
            long TongTien;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                MaHD = txt[0];
                NgayLapHD = txt[1];
                MaPT = txt[2];
                MaNV = txt[3];
                TongTien = Integer.parseInt(txt[4]);
                danhSachHoaDon.add(new HoaDon(MaHD, NgayLapHD, MaPT, MaNV,TongTien));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhifileHD() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachHoaDon.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (HoaDon i : danhSachHoaDon) {
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
