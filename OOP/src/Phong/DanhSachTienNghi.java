package Phong;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DanhSachTienNghi
{
    Scanner scanner = new Scanner(System.in);

    private ArrayList<TienNghi> danhSachTienNghi = new ArrayList<TienNghi>();

    public DanhSachTienNghi()
    {
        this.danhSachTienNghi = new ArrayList<TienNghi>();
    }
    public DanhSachTienNghi(ArrayList<TienNghi> danhSachTienNghi)
    {
        this.danhSachTienNghi = danhSachTienNghi;
    }

    public void setDanhSachTienNghi(ArrayList<TienNghi> danhSachTienNghi) {
        this.danhSachTienNghi = danhSachTienNghi;
    }

    public ArrayList<TienNghi> getDanhSachTienNghi() {
        return danhSachTienNghi;
    }

    public void XuatTienNghi()
    {
        if(danhSachTienNghi.size() == 0)
        {
            System.out.println("Danh sách trống.");
        }
        else
        {
            System.out.println("|===================================================|");
            System.out.format("|%-20s|%-30s|\n", "Mã tiện nghi","Tên tiện nghi");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for(int i = 0; i < danhSachTienNghi.size(); i++)
            {
                System.out.println(danhSachTienNghi.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            }
        }
    }
    public void DocfileTN() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachTienNghi.txt");
            BufferedReader br = new BufferedReader(fr);

            danhSachTienNghi = new ArrayList<TienNghi>();
            String line;
            String MaTN, Tentiennghi;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                MaTN = txt[0];
                Tentiennghi = txt[1];
                danhSachTienNghi.add(new TienNghi(MaTN, Tentiennghi));
            }
        } catch (Exception e) {
        } finally {
        }
    }
}
