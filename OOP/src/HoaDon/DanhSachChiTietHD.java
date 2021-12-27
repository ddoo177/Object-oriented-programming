package HoaDon;

import DichVu.DichVu;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DanhSachChiTietHD
{
    Scanner scanner = new Scanner(System.in);

    private ArrayList<ChiTietHoaDon> danhSachChiTietHD;
    DichVu dv = new DichVu();

    public DanhSachChiTietHD()
    {
        this.danhSachChiTietHD = new ArrayList<ChiTietHoaDon>();
    }
    public DanhSachChiTietHD(ArrayList<ChiTietHoaDon> danhSachChiTietHD)
    {
        this.danhSachChiTietHD = danhSachChiTietHD;
    }

    public void setDanhSachChiTietHD(ArrayList<ChiTietHoaDon> danhSachChiTietHD) {
        this.danhSachChiTietHD = danhSachChiTietHD;
    }

    public ArrayList<ChiTietHoaDon> getDanhSachChiTietHD() {
        return danhSachChiTietHD;
    }

    public void Them() {
        System.out.println("Nhập chi tiết hóa đơn: ");
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd.Nhap();
        this.danhSachChiTietHD.add(cthd);
        System.out.println("");
    }
    public void Xuat() {
        if (danhSachChiTietHD.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("|==============================================================================================|");
            System.out.printf("|%-20s|%-20s|%-15s|%-20s|%-15s|\n", "Mã hóa đơn", "Mã Phòng", "Số ngày ở", "Mã dịch vụ", "Số lượng DV");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for (int i = 0; i < danhSachChiTietHD.size(); i++) {
                System.out.print(danhSachChiTietHD.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|");
            }
        }
    }

    public void DocfileCTHD() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachChiTietHoaDon.txt");
            BufferedReader br = new BufferedReader(fr);

            danhSachChiTietHD = new ArrayList<ChiTietHoaDon>();
            String line;
            String MaHD, MaPhong, MaDV;
            int Songayo, SoluongDV;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                MaHD = txt[0];
                MaPhong = txt[1];
                Songayo = Integer.parseInt(txt[2]);
                MaDV = txt[3];
                SoluongDV = Integer.parseInt(txt[4]);
                danhSachChiTietHD.add(new ChiTietHoaDon(MaHD, MaPhong, Songayo, MaDV, SoluongDV));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhifileCTHD() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachChiTietHoaDon.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (ChiTietHoaDon i : danhSachChiTietHD) {
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
