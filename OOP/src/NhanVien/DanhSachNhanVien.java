package NhanVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import DuLieu.Interface;

public class DanhSachNhanVien implements Interface
{
    Scanner scanner = new Scanner(System.in);

    private ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();

    public DanhSachNhanVien()
    {
        this.danhSachNhanVien = new ArrayList<NhanVien>();
    }
    public DanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien)
    {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public Boolean checkNV(String MaNV)
    {
        for(int i = 0; i < danhSachNhanVien.size(); i++)
        {
            if(danhSachNhanVien.get(i).getMaNV().equals(MaNV))
            {
                return true;
            }
        }
        return false;
    }
    public void Them()
    {
        NhanVien nv;
        int chon, n;
        System.out.print("Nhập số lượng nhân viên bạn muốn thêm: ");
        n = scanner.nextInt();
        for(int i = 0; i < n; i++)
        {
                System.out.println("\n=========THÊM NHÂN VIÊN=========");
                System.out.println("|| 1. Quản lý                   ||");
                System.out.println("|| 2. Lễ tân                    ||");
                System.out.println("|| 3. Phục vụ                   ||");
                System.out.println("|| 4. Bảo vệ                    ||");
                System.out.println("==================================");
                System.out.println("Bạn muốn thêm nhân viên: ");
                chon = scanner.nextInt();
                scanner.nextLine();
                switch (chon)
                {
                    case 1:
                        nv = new QuanLy();
                        nv.Nhap();
                        while(checkNV(nv.getMaNV()))
                        {
                            System.out.println("Mã nhân viên bạn nhập đã tồn tại");
                            System.out.println("Nhập lại mã nhân viên");
                            nv.setMaNV();
                        }
                        this.danhSachNhanVien.add(nv);
                        break;
                    case 2:
                        nv = new LeTan();
                        nv.Nhap();
                        while(checkNV(nv.getMaNV()))
                        {
                            System.out.println("Mã nhân viên bạn nhập đã tồn tại");
                            System.out.println("Nhập lại mã nhân viên");
                            nv.setMaNV();
                        }
                        this.danhSachNhanVien.add(nv);
                        break;
                    case 3:
                        nv = new PhucVu();
                        nv.Nhap();
                        while(checkNV(nv.getMaNV()))
                        {
                            System.out.println("Mã nhân viên bạn nhập đã tồn tại");
                            System.out.println("Nhập lại mã nhân viên");
                            nv.setMaNV();
                        }
                        this.danhSachNhanVien.add(nv);
                        break;
                    case 4:
                        nv = new BaoVe();
                        nv.Nhap();
                        while(checkNV(nv.getMaNV()))
                        {
                            System.out.println("Mã nhân viên bạn nhập đã tồn tại");
                            System.out.println("Nhập lại mã nhân viên");
                            nv.setMaNV();
                        }
                        this.danhSachNhanVien.add(nv);
                        break;
                }
        }
    }
    public void Sua()
    {
        System.out.println("Nhập mã nhân viên muốn sửa: ");
        String maNV = scanner.nextLine();
        if (checkNV(maNV)) {
            for (int i = 0; i < danhSachNhanVien.size(); i++) {
                if (danhSachNhanVien.get(i).getMaNV().equals(maNV))
                {
                    int chon;
                    do {
                        System.out.println("\n============SỬA THÔNG TIN============");
                        System.out.println("|| 1. Họ tên                         ||");
                        System.out.println("|| 2. Giới tính                      ||");
                        System.out.println("|| 3. Ngày sinh                      ||");
                        System.out.println("|| 4. Số điện thoại                  ||");
                        System.out.println("|| 5. Địa chỉ                        ||");
                        System.out.println("|| 6. Mã nhân viên                   ||");
                        System.out.println("|| 7. Chức vụ                        ||");
                        System.out.println("|| 8. Lương cơ bản                   ||");
                        System.out.println("|| 0. Thoát                          ||");
                        System.out.println("=======================================");
                        System.out.println("Bạn muốn sửa thông tin: ");
                        chon = scanner.nextInt();
                        scanner.nextLine();
                        switch (chon) {
                            case 1 -> {
                                System.out.print("Nhập họ tên mới: ");
                                danhSachNhanVien.get(i).setHoten();
                                System.out.println("Sửa thành công");
                            }
                            case 2 -> {
                                System.out.print("Nhập giới tính mới: ");
                                danhSachNhanVien.get(i).setGioitinh();
                                System.out.println("Sửa thành công");
                            }
                            case 3 -> {
                                System.out.print("Nhập ngày sinh mới: ");
                                danhSachNhanVien.get(i).setNgaysinh();
                                System.out.println("Sửa thành công");
                            }
                            case 4 -> {
                                System.out.print("Nhập số điện thoại mới: ");
                                danhSachNhanVien.get(i).setDienthoai();
                                System.out.println("Sửa thành công");
                            }
                            case 5 -> {
                                System.out.print("Nhập địa chỉ mới: ");
                                danhSachNhanVien.get(i).setDiachi();
                                System.out.println("Sửa thành công");
                            }
                            case 6 -> {
                                System.out.print("Nhập mã nhân viên mới: ");
                                String newMaVNV = scanner.nextLine();
                                if (checkNV(newMaVNV)) {
                                    System.out.println("Sửa thất bại");
                                    System.out.println("Mã căn cước này đã tồn tại");
                                } else {
                                    danhSachNhanVien.get(i).setMaNV(newMaVNV);
                                    System.out.println("Sửa thành công");
                                }
                            }
                            case 7 -> {
                                System.out.println("\n===========SỬA CHỨC VỤ===========");
                                System.out.println("|| 1. Quản lý                    ||");
                                System.out.println("|| 2. Lễ tân                     ||");
                                System.out.println("|| 3. Phục vụ                    ||");
                                System.out.println("|| 4. Bảo vệ                     ||");
                                System.out.println("===================================");
                                System.out.println("Bạn muốn sửa chức vụ thành: ");
                                int cv = scanner.nextInt();
                                scanner.nextLine();
                                switch (cv)
                                {
                                    case 1:
                                        danhSachNhanVien.get(i).setChucvu("Quản lý");
                                        System.out.println("Sửa thành công");
                                        break;
                                    case 2:
                                        danhSachNhanVien.get(i).setChucvu("Lễ tân");
                                        System.out.println("Sửa thành công");
                                        break;
                                    case 3:
                                        danhSachNhanVien.get(i).setChucvu("Phục vụ");
                                        System.out.println("Sửa thành công");
                                        break;
                                    case 4:
                                        danhSachNhanVien.get(i).setChucvu("Bảo vệ");
                                        System.out.println("Sửa thành công");
                                        break;
                                }
                            }
                            case 8 -> {
                                System.out.print("Nhập lương cơ bản mới: ");
                                danhSachNhanVien.get(i).setLuongcoban();
                                System.out.println("Sửa thành công");
                            }
                            default ->
                                    System.out.println("Hãy chọn lại: ");
                        }
                    } while (chon != 0);
                }
            }
        } else {
            System.out.println("Không tìm thấy nhân viên");
        }
    }
    public void Xoa()
    {
        System.out.print("Nhập mã nhân viên bạn muốn xóa: ");
        String maNV = scanner.nextLine();
        if(checkNV(maNV))
        {
            for(int i = 0; i < danhSachNhanVien.size(); i++)
            {
                if(danhSachNhanVien.get(i).getMaNV().equals(maNV))
                {
                    danhSachNhanVien.remove(i);
                    System.out.println("Xóa nhân viên thành công!");
                    break;
                }
            }
        }
        else
            System.out.println("Mã nhân viên bạn nhập không hợp lệ");
    }
    public void TimKiemNhanVien() {
        System.out.println("Nhập mã nhân viên muốn tìm: ");
        String maNV = scanner.nextLine();
        if (checkNV(maNV)) {
            for(int i = 0; i < danhSachNhanVien.size(); i++)
            {
                if (danhSachNhanVien.get(i).getMaNV().equals(maNV))
                {
                    System.out.println("|================================================================================================================================================================================|");
                    System.out.format("|%-20s|%-15s|%-18s|%-20s|%-20s|%-20s|%-15s|%-20s|%-20s|\n", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Mã nhân viên", "Chức vụ","Lương cơ bản","Lương");
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                    System.out.print(danhSachNhanVien.get(i));
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                }
            }
        }
        else
        {
            System.out.println("Không tìm thấy nhân viên");
        }
    }
    public void XuatNhanVien()
    {
        if(danhSachNhanVien.size()==0)
        {
            System.out.println("Danh sách trống");
        }
        else
        {
            System.out.println("|================================================================================================================================================================================|");
            System.out.format("|%-20s|%-15s|%-18s|%-20s|%-20s|%-20s|%-15s|%-20s|%-20s|\n", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Mã nhân viên", "Chức vụ","Lương cơ bản","Lương");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for(int i = 0; i < danhSachNhanVien.size(); i++)
            {
                System.out.print(danhSachNhanVien.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|");
            }
        }
    }
    public void DocfileNV() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachNhanVien.txt");
            BufferedReader br = new BufferedReader(fr);

            danhSachNhanVien = new ArrayList<NhanVien>();
            String line;
            String Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi, MaNV, Chucvu;
            Long Luongcoban;
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
                MaNV = txt[5];
                Chucvu = txt[6];
                Luongcoban = Long.parseLong(txt[7]);
                switch (Chucvu) {
                    case "Quản lý":
                        danhSachNhanVien.add(new QuanLy(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi));
                        break;
                    case "Phục vụ":
                        danhSachNhanVien.add(new PhucVu(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi));
                        break;
                    case "Lễ tân":
                        danhSachNhanVien.add(new LeTan(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi));
                        break;
                    case "Bảo vệ":
                        danhSachNhanVien.add(new BaoVe(MaNV, Chucvu, Luongcoban, Hoten, Gioitinh, Ngaysinh, Dienthoai, Diachi));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhifileNV() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachNhanVien.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (NhanVien i : danhSachNhanVien) {
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