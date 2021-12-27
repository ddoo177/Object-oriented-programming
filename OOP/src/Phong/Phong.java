package Phong;

import java.util.Scanner;

public abstract class Phong
{
    public String MaPhong;
    protected String TinhTrangPhong;
    protected long GiaPhong;
    protected String LoaiPhong;
    protected String MoTaPhong;

    Scanner scanner = new Scanner(System.in);

    public Phong()
    {
        this.MaPhong = null;
        this.TinhTrangPhong = "Trống";
        this.GiaPhong = 0;
        this.LoaiPhong = null;
        this.MoTaPhong = null;
    }
    public Phong(String maPhong, String tinhTrangPhong, long giaPhong, String loaiPhong, String moTaPhong) {
        this.MaPhong = maPhong;
        this.TinhTrangPhong = tinhTrangPhong;
        this.GiaPhong = giaPhong;
        this.LoaiPhong = loaiPhong;
        this.MoTaPhong = moTaPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getTinhTrangPhong() {
        return TinhTrangPhong;
    }

    public long getGiaPhong() {
        return GiaPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public String getMoTaPhong() {
        return MoTaPhong;
    }

    public void setMaPhong(String maPhong) {
        this.MaPhong = maPhong;
    }

    public void setTinhTrangPhong(String tinhTrangPhong) {
        this.TinhTrangPhong = tinhTrangPhong;
    }

    public void setGiaPhong(long giaPhong) {
        this.GiaPhong = giaPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.LoaiPhong = loaiPhong;
    }

    public void setMoTaPhong(String moTaPhong) {
        this.MoTaPhong = moTaPhong;
    }
    public void setMaPhong() {
        this.MaPhong = scanner.nextLine();
    }

    public void setTinhTrangPhong() {
        this.TinhTrangPhong = scanner.nextLine();
    }

    abstract public void setGiaPhong();

    abstract public void setLoaiPhong();

    abstract public void setMoTaPhong();

    public void Nhap()
    {
        System.out.print("Nhập mã phòng: ");
        this.setMaPhong();
        System.out.print("Nhập tình trạng phòng: ");
        this.setTinhTrangPhong();
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-15s|%-20s|%-15s|%-45s|\n", MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong);
    }
    public String Ghifile() {
        return getMaPhong() + ";" + getTinhTrangPhong() + ";" + getGiaPhong() + ";" + getLoaiPhong() + ";" + getMoTaPhong();
    }
}
