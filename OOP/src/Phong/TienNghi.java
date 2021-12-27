package Phong;

import java.util.Scanner;

public class TienNghi
{
    protected String MaTN;
    protected String TenTienNghi;
    Scanner scanner = new Scanner(System.in);

    public TienNghi()
    {
        this.MaTN = null;
        this.TenTienNghi = null;
    }
    public TienNghi(String MaTN, String TenTienNghi)
    {
        this.MaTN = MaTN;
        this.TenTienNghi = TenTienNghi;
    }

    public String getMaTN() {
        return MaTN;
    }
    public String getTenTienNghi() {
        return TenTienNghi;
    }
    public void setMaTN(String maTN) {
        MaTN = maTN;
    }
    public void setTenTienNghi(String tenTienNghi) {
        TenTienNghi = tenTienNghi;
    }
    public void setMaTN() {
        this.MaTN = scanner.nextLine();
    }
    public void setTenTienNghi() {
        this.TenTienNghi = scanner.nextLine();
    }

    public void Nhap()
    {
        System.out.print("Nhập mã tiện nghi: ");
        setMaTN();
        System.out.print("Nhập tên tiện nghi: ");
        setTenTienNghi();
    }

    public String toString() {
        return String.format("|%-20s|%-30s|",MaTN,TenTienNghi);
    }
    public String Ghifile(){
        return getMaTN()+";"+getTenTienNghi();
    }
}
