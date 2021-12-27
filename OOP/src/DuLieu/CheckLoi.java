package DuLieu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CheckLoi
{
    Scanner scanner = new Scanner(System.in);

    public int KiemTraKieuInt() {
        int n;
        while(true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.print("Sai kiểu dữ liệu. Xin nhập lại: ");
            }
        }
    }
    public String KiemTraNhapMaNV() {
        String DauVao;
        while (true) {
            DauVao = scanner.nextLine();
            DauVao = DauVao.toUpperCase();
            if (DauVao.matches("NV" + "[0-9]{2}")) {
                return DauVao;
            } else {
                System.out.println("Định dạng mã nhân viên: NV__. Ví dụ: NV01");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    public String KiemTraNhapMaCC() {
        String DauVao;
        while (true) {
            DauVao = scanner.nextLine();
            DauVao = DauVao.toUpperCase();
            if (DauVao.matches("[0-9]{12}")) {
                return DauVao;
            } else {
                System.out.println("Mã căn cước không hợp lệ. Căn cước bao gồm 12 số");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    public String KiemTraMaDV() {
        while(true) {
            String MaDV = scanner.nextLine();
            if (MaDV != null) {
                MaDV = MaDV.toUpperCase();
                if (MaDV.matches("DV" + "[0-9]{1,2}"))
                    return MaDV;
                else {
                    System.out.println("Định dạng mã dịch vụ: DV__ (Ví dụ: DV01).");
                }
            }
            System.out.print("Xin mời nhập lại: ");
        }
    }
    public String KiemTraNhapTen() {
        String DauVao;
        while (true) {
            DauVao = scanner.nextLine();
            if (DauVao.matches("[\\pL\\pMn*\\s*]+")) {
                DauVao = DauVao.trim();
                DauVao = DauVao.replaceAll("\\s+", " ");
                DauVao = DauVao.toLowerCase();
                String[] Chuoi = DauVao.split(" ");
                DauVao = "";
                for (int i = 0; i < Chuoi.length; i++) {
                    DauVao += String.valueOf(Chuoi[i].charAt(0)).toUpperCase() + Chuoi[i].substring(1);
                    if (i < Chuoi.length - 1) {
                        DauVao += " ";
                    }
                }
                return DauVao;
            } else {
                System.out.print("Tên không hợp lệ ! Mời nhập lại: ");
            }
        }
    }
    public String KiemTraNgayThang() {
        while (true) {
            String NgayThang = scanner.nextLine();
            String DinhDang = "dd/MM/yyyy";
            try {
                DateFormat df = new SimpleDateFormat(DinhDang);
                df.setLenient(false);
                df.parse(NgayThang);
                return NgayThang;
            } catch (ParseException e) {
                System.out.print("Sai kiểu dữ liệu hoặc định dạng!\nXin mời nhập lại: ");
            }
        }
    }
    public String KiemTraMaPT() {
        while(true) {
            String MaPT = scanner.nextLine();
            if (MaPT != null) {
                MaPT = MaPT.toUpperCase();
                if (MaPT.matches("PT" + "[0-9]{1,2}"))
                    return MaPT;
                else {
                    System.out.println("Định dạng mã phiếu thuê: PT__ (Ví dụ: PT01).");
                }
                System.out.print("Xin mời nhập lại: ");
            }
        }
    }
    public String KiemTraMaHD() {
        while(true) {
            String MaHD = scanner.nextLine();
            if (MaHD != null) {
                MaHD = MaHD.toUpperCase();
                if (MaHD.matches("HD" + "[0-9]{1,2}"))
                    return MaHD;
                else {
                    System.out.println("Định dạng mã phiếu thuê: HD__ (Ví dụ: HD01).");
                }
                System.out.print("Xin mời nhập lại: ");
            }
        }
    }
    public String KiemTraMaPhong() {
        while(true) {
            String MaPhong = scanner.nextLine();
            if (MaPhong != null) {
                MaPhong = MaPhong.toUpperCase();
                if (MaPhong.matches("PHG" + "[0-9]{1,2}"))
                    return MaPhong;
                else {
                    System.out.println("Định dạng mã phòng: PHG__ (Ví dụ: PHG01)");
                }
                System.out.print("Xin mời nhập lại: ");
            }
        }
    }
}
