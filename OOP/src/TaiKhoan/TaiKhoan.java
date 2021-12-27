package TaiKhoan;

import java.io.Serializable;
import java.util.Scanner;

public class TaiKhoan implements Serializable
{
    protected String taiKhoan;
    protected String matKhau;
    protected String matKhau2;

    static Scanner scanner = new Scanner(System.in);

    public TaiKhoan()
    {
        this.taiKhoan = null;
        this.matKhau = null;
        this.matKhau2 = null;
    }
    public TaiKhoan(String taiKhoan, String matKhau)
    {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }
    public TaiKhoan(String taiKhoan, String matKhau, String matKhau2)
    {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }
    public String getTaiKhoan() {
        return taiKhoan;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public String getMatKhau2() {
        return matKhau2;
    }
    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-20s|",taiKhoan,matKhau);
    }
    public String Ghifile(){
        return getTaiKhoan()+";"+getMatKhau();
    }
}
