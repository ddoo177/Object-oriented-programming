package Phong;

import java.util.Scanner;

public class ChiTietPhong
{
    private String MaPhong;
    private String MaTN;
    private int SoLuong;
    Scanner scanner = new Scanner(System.in);

    public ChiTietPhong()
    {
        this.MaPhong = null;
        this.MaTN = null;
        this.SoLuong = 0;
    }

    public ChiTietPhong(String maPhong, String maTN, int soLuong) {
        this.MaPhong = maPhong;
        this.MaTN = maTN;
        this.SoLuong = soLuong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getMaTN() {
        return MaTN;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public void setMaTN(String maTN) {
        MaTN = maTN;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
    public void setMaPhong() {
        MaPhong = scanner.nextLine();
    }

    public void setMaTN() {
        MaTN = scanner.nextLine();
    }

    public void setSoLuong() {
        SoLuong = scanner.nextInt();
    }
    public void Nhap()
    {
        System.out.println("Nhập mã phòng: ");
        setMaPhong();
        System.out.println("Nhập mã tiện nghi: ");
        setMaTN();
        System.out.println("Nhập số lượng: ");
        setSoLuong();
    }
    @Override
    public String toString() {
        return String.format("|%-20s|%-20s|%-15s|\n", MaPhong, MaTN, SoLuong);
    }
    public String Ghifile() {
        return getMaPhong()+";"+getMaTN()+";"+getSoLuong();
    }
}
