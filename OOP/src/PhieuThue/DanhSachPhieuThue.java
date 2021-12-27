package PhieuThue;

import DuLieu.Interface;

import java.util.ArrayList;
import java.util.Scanner;
import DuLieu.CheckLoi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DanhSachPhieuThue implements Interface
{
    Scanner scanner = new Scanner(System.in);
    private ArrayList<PhieuThue> danhSachPhieuThue = new ArrayList<PhieuThue>();
    CheckLoi check = new CheckLoi();

    public DanhSachPhieuThue()
    {
        this.danhSachPhieuThue = new ArrayList<PhieuThue>();
    }
    public DanhSachPhieuThue(ArrayList<PhieuThue> danhSachPhieuThue)
    {
        this.danhSachPhieuThue = danhSachPhieuThue;
    }

    public ArrayList<PhieuThue> getDanhSachPhieuThue() {
        return danhSachPhieuThue;
    }

    public void setDanhSachPhieuThue(ArrayList<PhieuThue> danhSachPhieuThue) {
        this.danhSachPhieuThue = danhSachPhieuThue;
    }
    public boolean checkPT(String MaPT)
    {
        for(int i = 0; i < danhSachPhieuThue.size(); i++)
        {
            if(danhSachPhieuThue.get(i).getMaPT().equals(MaPT))
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public void Them()
    {
        PhieuThue pt = new PhieuThue();
        pt.Nhap();
        danhSachPhieuThue.add(pt);
    }

    @Override
    public void Sua() {

    }

    @Override
    public void Xoa() {
        System.out.print("Nhập mã phiếu thuê muốn xóa: ");
        String tmp = check.KiemTraMaPT();
        if (checkPT(tmp)) {
            for (int i = 0; i < danhSachPhieuThue.size(); i++) {
                if (danhSachPhieuThue.get(i).getMaPT().equals(tmp)) {
                    danhSachPhieuThue.remove(i);
                    System.out.println("Xóa phiếu thuê thành công!");
                    break;
                }
            }
        } else {
            System.out.println("Không tìm thấy phiếu thuê");
        }
    }
    public void Timkiem() {
        System.out.print("Nhập mã phiếu thuê cần tìm: ");
        String tmp = check.KiemTraMaPT();
        if (checkPT(tmp)) {
            for (int i = 0; i < danhSachPhieuThue.size(); i++) {
                if (danhSachPhieuThue.get(i).getMaCC().equals(tmp)) {
                    System.out.println("|========================================================================================================================|");
                    System.out.printf("|%-20s|%-15s|%-20s|%-25s|%-20s|%-15s|\n", "Mã phiếu thuê", "Ngày lập", "Mã căn cước KH", "Họ tên KH", "Mã phòng", "Số ngày ở");
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                    System.out.print(danhSachPhieuThue.get(i));
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                }
            }
        } else {
            System.out.println("Không tìm thấy phiếu thuê");
        }
    }
    public void Xuat()
    {
        if (danhSachPhieuThue.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("|========================================================================================================================|");
            System.out.printf("|%-20s|%-15s|%-20s|%-25s|%-20s|%-15s|\n", "Mã phiếu thuê", "Ngày lập", "Mã căn cước KH", "Họ tên KH", "Mã phòng", "Số ngày ở");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for (int i = 0; i < danhSachPhieuThue.size(); i++) {
                System.out.print(danhSachPhieuThue.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|");
            }
        }
    }
    public void DocfilePT() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachPhieuThue.txt");
            BufferedReader br = new BufferedReader(fr);

            danhSachPhieuThue = new ArrayList<PhieuThue>();
            String line;
            String MaPT, Ngaylap, MaCC, HotenKH, MaPhong;
            int Songayo;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                MaPT = txt[0];
                Ngaylap = txt[1];
                MaCC = txt[2];
                HotenKH = txt[3];
                MaPhong = txt[4];
                Songayo = Integer.parseInt(txt[5]);
                danhSachPhieuThue.add(new PhieuThue(MaPT, Ngaylap, MaCC, HotenKH, MaPhong, Songayo));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhifilePT() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachPhieuThue.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (PhieuThue i : danhSachPhieuThue) {
                bw.write(i.Ghifile());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }}
