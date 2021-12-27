package TaiKhoan;

import DuLieu.Interface;
import Phong.TienNghi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachTaiKhoan implements Interface
{
    Scanner scanner = new Scanner(System.in);

    private ArrayList<TaiKhoan> danhSachTaiKhoan;

    public DanhSachTaiKhoan()
    {
        this.danhSachTaiKhoan = new ArrayList<TaiKhoan>();
    }
    public DanhSachTaiKhoan(ArrayList<TaiKhoan> danhSachTaiKhoan)
    {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }
    public boolean DangNhapAdmin(TaiKhoan tk)
    {
        String admin = "admin";
        if(tk.taiKhoan.equals(admin) && tk.matKhau.equals(admin))
        {
            return true;
        }
        return false;
    }
    public void DangKy(TaiKhoan tk)
    {
        this.danhSachTaiKhoan.add(tk);
    }
    public boolean DangNhap(TaiKhoan tk)
    {
        for (TaiKhoan taiKhoan : danhSachTaiKhoan)
        {
            if (taiKhoan.taiKhoan.equalsIgnoreCase(tk.taiKhoan) && taiKhoan.matKhau.equalsIgnoreCase(tk.matKhau))
                return true;
        }
        return false;
    }
    public void Xuat()
    {
        if(danhSachTaiKhoan.isEmpty())
        {
            System.out.println("Danh sách trống.");
        }
        else
        {
            System.out.println("|=========================================|");
            System.out.format("|%-20s|%-20s|\n", "Tên tài khoản","Mật khẩu");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            for(int i = 0; i < danhSachTaiKhoan.size(); i++)
            {
                System.out.println(danhSachTaiKhoan.get(i));
                System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|");
            }
        }
    }
    public boolean CheckTK(String taiKhoan)
    {
        for(int i = 0; i < danhSachTaiKhoan.size(); i++)
        {
            if(danhSachTaiKhoan.get(i).getTaiKhoan().equals(taiKhoan))
            {
                return true;
            }
        }
        return false;
    }
    public void Them()
    {
        String matKhau1 = null;
        String matKhau2 = null;
        System.out.print("Nhập tài khoản mới: ");
        String newTK = scanner.nextLine();
        for (int i = 0; i < danhSachTaiKhoan.size(); i++)
        {
            while (danhSachTaiKhoan.get(i).equals(newTK))
            {
                System.out.println("Tài khoản bạn nhập đã tồn tại.");
                System.out.print("Nhập tài khoản mới: ");
                newTK = scanner.nextLine();
            }
            System.out.println("Nhập mật khẩu: ");
            matKhau1 = scanner.nextLine();
            System.out.println("Nhắc lại mật khẩu: ");
            matKhau2 = scanner.nextLine();
            while (!matKhau1.equals(matKhau2))
            {
                System.out.println("Nhắc lại mật khẩu không đúng.");
                System.out.println("Nhắc lại mật khẩu: ");
                matKhau2 = scanner.nextLine();
            }
        }
        TaiKhoan tk = new TaiKhoan(newTK,matKhau1);
        danhSachTaiKhoan.add(tk);
    }
    public void Sua()
    {
        System.out.println("Nhập tài khoản: ");
        String tk = scanner.nextLine();
        String mk1 = null;
        String mk2 = null;
        if(CheckTK(tk))
        {
            for(int i = 0; i < danhSachTaiKhoan.size(); i++)
            {
                if(danhSachTaiKhoan.get(i).getTaiKhoan().equals(tk))
                {
                    System.out.print("Nhập mật khẩu mới: ");
                    mk1 = scanner.nextLine();
                    while(danhSachTaiKhoan.get(i).getMatKhau().equals(mk1))
                    {
                        System.out.print("Mật khẩu mới không được trùng mật khẩu cũ");
                        System.out.print("Nhập mật khẩu mới: ");
                        mk1 = scanner.nextLine();
                    }
                    System.out.print("Nhắc lại mật khẩu: ");
                    mk2 = scanner.nextLine();
                    while(!mk1.equals(mk2))
                    {
                        System.out.println("Nhắc lại mật khẩu không đúng");
                        System.out.print("Nhắc lại mật khẩu: ");
                        mk2 = scanner.nextLine();
                    }
                }
                danhSachTaiKhoan.get(i).setMatKhau(mk1);
            }
        }
        else
            System.out.println("Tài khoản không tồn tại");
    }
    public void Xoa()
    {
        System.out.println("Nhập tên tài khoản bạn muốn xóa: ");
        String temp = scanner.nextLine();
        if(CheckTK(temp))
        {
            for(int i = 0; i < danhSachTaiKhoan.size(); i++)
            {
                if(danhSachTaiKhoan.get(i).getTaiKhoan().equals(temp))
                {
                    danhSachTaiKhoan.remove(i);
                    System.out.println("Xóa tài khoản thành công.");
                    break;
                }
            }
        }
        else
            System.out.println("Tài khoản không tồn tại");
    }
    public void DocfileTK() {
        try {
            FileReader fr = new FileReader("src/DuLieu/DanhSachTaiKhoan.txt");
            BufferedReader br = new BufferedReader(fr);
            danhSachTaiKhoan = new ArrayList<TaiKhoan>();
            String line;
            String taiKhoan, matKhau;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                taiKhoan = txt[0];
                matKhau = txt[1];
                danhSachTaiKhoan.add(new TaiKhoan(taiKhoan, matKhau));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        }
    }
    public void GhifileTK() {
        try {
            FileWriter fw = new FileWriter("src/DuLieu/DanhSachTaiKhoan.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (TaiKhoan i : danhSachTaiKhoan) {
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
