package Phong;

import DuLieu.Interface;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DanhSachChiTietPhong
{
    Scanner scanner = new Scanner(System.in);

    private ArrayList<ChiTietPhong> DanhSachChiTietPhong = new ArrayList<ChiTietPhong>();

    public DanhSachChiTietPhong()
    {
        this.DanhSachChiTietPhong = new ArrayList<ChiTietPhong>();
    }
    public DanhSachChiTietPhong(ArrayList<ChiTietPhong> DanhSachChiTietPhong)
    {
        this.DanhSachChiTietPhong = DanhSachChiTietPhong;
    }

    public void setDanhSachChiTietPhong(ArrayList<ChiTietPhong> DanhSachChiTietPhong) {
        this.DanhSachChiTietPhong = DanhSachChiTietPhong;
    }

    public ArrayList<ChiTietPhong> getDanhSachChiTietPhong() {
        return DanhSachChiTietPhong;
    }

    public void Xuat()
    {
        System.out.println("|=========================================================|");
        System.out.format("|%-20s|%-20s|%-15s|\n", "Mã tiện nghi","Tên tiện nghi","Số lượng");
        System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
        for(int i = 0; i < DanhSachChiTietPhong.size(); i++)
        {
            System.out.print(DanhSachChiTietPhong.get(i));
            System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|");
        }
    }
    public void DocfileCTP() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachChiTietPhong.txt");
            BufferedReader br = new BufferedReader(fr);

            DanhSachChiTietPhong = new ArrayList<ChiTietPhong>();
            String line;
            String MaPhong, MaTN;
            int SoLuong;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                MaPhong = txt[0];
                MaTN = txt[1];
                SoLuong = Integer.parseInt(txt[2]);
                DanhSachChiTietPhong.add(new ChiTietPhong(MaPhong, MaTN, SoLuong));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public void GhifileCTP() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachChiTietPhong.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (ChiTietPhong i : DanhSachChiTietPhong) {
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
