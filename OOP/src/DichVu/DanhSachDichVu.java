package DichVu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DanhSachDichVu {

    Scanner sc = new Scanner(System.in);
    private ArrayList<DichVu> DSDV = new ArrayList<DichVu>();

    public DanhSachDichVu() {
        this.DSDV = new ArrayList<>();
    }

    public DanhSachDichVu(ArrayList<DichVu> danhsachDichVu) {
        this.DSDV = danhsachDichVu;
    }

    public ArrayList<DichVu> getDSDV() {
        return DSDV;
    }

    public void setDSDV(ArrayList<DichVu> DSDV) {
        this.DSDV = DSDV;
    }

    public Boolean Kiemtra(String tmp) {
        for (int i = 0; i < DSDV.size(); i++) {
            if (DSDV.get(i).getMaDV().equals(tmp)) {
                return true;
            }
        }
        return false;
    }

    public void Them() {
        System.out.print("Nhập số lượng dịch vụ cần thêm: ");
        int soluong = sc.nextInt();
        System.out.println();
        for (int i = 0; i < soluong; i++) {
            System.out.println("Nhập thông tin dịch vụ mới: ");
            DichVu dv = new DichVu();
            dv.Nhap();
            while (Kiemtra(dv.getMaDV())) {
                System.out.println("Mã dịch vụ này đã tồn tại");
                System.out.print("Hãy nhập lại mã dịch vụ khác: ");
                dv.setMaDV();
            }
            this.DSDV.add(dv);
            System.out.println();
        }
    }

    public void Sua() {
        System.out.println("Nhập mã dịch vụ muốn sửa: ");
        String tmp = sc.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < DSDV.size(); i++) {
                if (DSDV.get(i).getMaDV().equals(tmp)) {
                    int choice;
                    do {
                        System.out.println("\n============SỬA THÔNG TIN============");
                        System.out.println("|| 1. Mã dịch vụ                     ||");
                        System.out.println("|| 2. Tên dịch vụ                    ||");
                        System.out.println("|| 3. Giá dịch vụ                    ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.println("Bạn muốn sửa thông tin: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1 -> {
                                System.out.print("Nhập mã dịch vụ mới: ");
                                String madvtmp = sc.nextLine();
                                if (Kiemtra(madvtmp)) {
                                    System.out.println("Sửa thất bại");
                                    System.out.println("Mã dịch vụ này đã tồn tại");
                                } else {
                                    DSDV.get(i).setMaDV(madvtmp);
                                    System.out.println("Sửa thành công");
                                }
                            }
                            case 2 -> {
                                System.out.print("Nhập tên dịch vụ mới: ");
                                DSDV.get(i).setTenDV();
                                System.out.println("Sửa thành công");
                            }
                            case 3 -> {
                                System.out.print("Nhập giá dịch vụ mới: ");
                                DSDV.get(i).setGiaDV();
                                System.out.println("Sửa thành công");
                            }
                            default ->
                                System.out.println("Hãy chọn lại: ");
                        }
                    } while (choice != 0);
                }
            }
        } else {
            System.out.println("Không tìm thấy dịch vụ");
        }
    }

    public void Xoa() {
        System.out.print("Nhập mã dịch vụ muốn xóa: ");
        String tmp = sc.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < DSDV.size(); i++) {
                if (DSDV.get(i).getMaDV().equals(tmp)) {
                    DSDV.remove(i);
                    System.out.println("Xóa dịch vụ thành công!");
                    break;
                }
            }
        } else {
            System.out.println("Không tìm thấy dịch vụ");
        }
    }

    public void Timkiem() {
        System.out.println("Nhập mã dịch vụ cần tìm: ");
        String tmp = sc.nextLine();
        if (Kiemtra(tmp)) {
            for (int i = 0; i < DSDV.size(); i++) {
                if (DSDV.get(i).getMaDV().equals(tmp)) {
                    System.out.println("|=========================================================|");
                    System.out.printf("|%-10s|%-30s|%-15s|\n", "MaDV", "TenDV", "GiaDV");
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                    System.out.print(DSDV.get(i));
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                }
            }
        } else {
            System.out.println("Không tìm thấy dịch vụ");
        }
    }

    public void Xuat() {
        if (DSDV.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("|=========================================================|");
            System.out.printf("|%-10s|%-30s|%-15s|\n", "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for (int i = 0; i < DSDV.size(); i++) {
                System.out.print(DSDV.get(i));
                System.out.println("|━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|");
            }
        }
    }

    public void MenuDSDV() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("||            Quản lý dịch vụ             ||");
            System.out.println("||________________________________________||");
            System.out.println("|| 1. Xuất danh sách dịch vụ              ||");
            System.out.println("|| 2. Thêm dịch vụ                        ||");
            System.out.println("|| 3. Sửa dịch vụ                         ||");
            System.out.println("|| 4. Xóa dịch vụ                         ||");
            System.out.println("|| 5. Tìm kiếm dịch vụ                    ||");
            System.out.println("|| 0. Lưu lại                             ||");
            System.out.println("============================================");
            System.out.print("Bạn muốn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 ->
                    Xuat();
                case 2 ->
                    Them();
                case 3 ->
                    Sua();
                case 4 ->
                    Xoa();
                case 5 ->
                    Timkiem();
                default ->
                    System.out.println("Hãy chọn lại: ");
            }
        } while (choice != 0);
    }

    public void DocFileDV() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachDichVu.txt");
            BufferedReader br = new BufferedReader(fr);

            DSDV = new ArrayList<DichVu>();
            String line;
            String MaDV, TenDV;
            Long GiaDV;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                MaDV = txt[0];
                TenDV = txt[1];
                GiaDV = Long.parseLong(txt[2]);
                DSDV.add(new DichVu(MaDV, TenDV, GiaDV));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhiFileDV() {
        try {
            FileWriter fw = new FileWriter("DichVu.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (DichVu i : DSDV) {
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

