package Phong;

import DuLieu.Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachPhong implements Interface
{
     Scanner scanner = new Scanner(System.in);

     private ArrayList<Phong> danhSachPhong = new ArrayList<Phong>();

     public DanhSachPhong()
     {
          this.danhSachPhong = new ArrayList<Phong>();
     }
     public DanhSachPhong(ArrayList<Phong> danhSachPhong)
     {
          this.danhSachPhong = danhSachPhong;
     }

     public void setDanhSachPhong(ArrayList<Phong> danhSachPhong) {
          this.danhSachPhong = danhSachPhong;
     }

     public ArrayList<Phong> getDanhSachPhong() {
          return danhSachPhong;
     }
     public Boolean checkPhong(String MaPhong)
     {
          for(int i = 0; i < danhSachPhong.size(); i++)
          {
               if(danhSachPhong.get(i).getMaPhong().equals(MaPhong))
               {
                    return true;
               }
          }
          return false;
     }
     public void Them()
     {
          Phong p;
          int chon, n;
          System.out.print("Nhập số lượng phòng bạn muốn thêm: ");
          n = scanner.nextInt();
          for(int i = 0; i < n; i++)
          {
               System.out.println("\n============THÊM PHÒNG============");
               System.out.println("|| 1. Phòng VIP                 ||");
               System.out.println("|| 2. Phòng đơn                 ||");
               System.out.println("|| 3. Phòng đôi                 ||");
               System.out.println("==================================");
               System.out.println("Bạn muốn thêm loại phòng: ");
               chon = scanner.nextInt();
               scanner.nextLine();
               switch (chon)
               {
                    case 1:
                         p = new PhongVip();
                         p.Nhap();
                         while(checkPhong(p.getMaPhong()))
                         {
                              System.out.println("Mã phòng bạn nhập đã tồn tại");
                              System.out.println("Nhập lại mã phòng");
                              p.setMaPhong();
                         }
                         this.danhSachPhong.add(p);
                         break;
                    case 2:
                         p = new PhongDon();
                         p.Nhap();
                         while(checkPhong(p.getMaPhong()))
                         {
                              System.out.println("Mã phòng bạn nhập đã tồn tại");
                              System.out.println("Nhập lại mã phòng");
                              p.setMaPhong();
                         }
                         this.danhSachPhong.add(p);
                         break;
                    case 3:
                         p = new PhongDoi();
                         p.Nhap();
                         while(checkPhong(p.getMaPhong()))
                         {
                              System.out.println("Mã phòng bạn nhập đã tồn tại");
                              System.out.println("Nhập lại mã phòng");
                              p.setMaPhong();
                         }
                         this.danhSachPhong.add(p);
                         break;
               }
          }
     }
     public void Sua()
     {
          System.out.println("Nhập mã phòng muốn sửa: ");
          String maPhong = scanner.nextLine();
          if (checkPhong(maPhong)) {
               for (int i = 0; i < danhSachPhong.size(); i++) {
                    if (danhSachPhong.get(i).getMaPhong().equals(maPhong))
                    {
                         int chon;
                         do {
                              System.out.println("\n===========SỬA PHÒNG============");
                              System.out.println("|| 1. Tình trạng              ||");
                              System.out.println("|| 2. Giá phòng               ||");
                              System.out.println("|| 3. Loại phòng              ||");
                              System.out.println("|| 4. Mô tả                   ||");
                              System.out.println("|| 0. Thoát                   ||");
                              System.out.println("================================");
                              System.out.println("Bạn muốn sửa thông tin: ");
                              chon = scanner.nextInt();
                              scanner.nextLine();
                              switch (chon) {
                                   case 1 -> {
                                        System.out.print("Nhập tình trạng phòng: ");
                                        danhSachPhong.get(i).setTinhTrangPhong();
                                        System.out.println("Sửa thành công");
                                   }
                                   case 2 -> {
                                        System.out.print("Nhập giá phòng mới: ");
                                        danhSachPhong.get(i).setGiaPhong();
                                        System.out.println("Sửa thành công");
                                   }
                                   case 3 -> {
                                        System.out.println("\n==========SỬA LOẠI PHÒNG===========");
                                        System.out.println("|| 1. Phòng VIP                    ||");
                                        System.out.println("|| 2. Phòng đơn                     ||");
                                        System.out.println("|| 3. Phòng Đôi                    ||");
                                        System.out.println("===================================");
                                        System.out.println("Bạn muốn sửa loại phòng thành: ");
                                        int cv = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (cv)
                                        {
                                             case 1:
                                                  danhSachPhong.get(i).setLoaiPhong("Phòng VIP");
                                                  System.out.println("Sửa thành công");
                                                  break;
                                             case 2:
                                                  danhSachPhong.get(i).setLoaiPhong("Phòng đơn");
                                                  System.out.println("Sửa thành công");
                                                  break;
                                             case 3:
                                                  danhSachPhong.get(i).setLoaiPhong("Phòng đôi");
                                                  System.out.println("Sửa thành công");
                                                  break;
                                        }
                                   }
                                   case 4 -> {
                                        System.out.print("Nhập mô tả phòng mới: ");
                                        danhSachPhong.get(i).setMoTaPhong();
                                        System.out.println("Sửa thành công");
                                   }
                                   default ->
                                           System.out.println("Hãy chọn lại: ");
                              }
                         } while (chon != 0);
                    }
               }
          } else {
               System.out.println("Không tìm thấy phòng");
          }
     }
     public void Xoa()
     {
          System.out.print("Nhập mã phòng bạn muốn xóa: ");
          String maPhong = scanner.nextLine();
          if(checkPhong(maPhong))
          {
               for(int i = 0; i < danhSachPhong.size(); i++)
               {
                    if(danhSachPhong.get(i).getMaPhong().equals(maPhong))
                    {
                         danhSachPhong.remove(i);
                         System.out.println("Xóa phòng thành công!");
                         break;
                    }
               }
          }
          else
               System.out.println("Mã phòng bạn nhập không hợp lệ");
     }
     public void TimKiemPhong() {
          System.out.println("Nhập mã phòng muốn tìm: ");
          String maPhong = scanner.nextLine();
          if (checkPhong(maPhong)) {
               for(int i = 0; i < danhSachPhong.size(); i++)
               {
                    if (danhSachPhong.get(i).getMaPhong().equals(maPhong))
                    {
                         System.out.println("|=======================================================================================================================|");
                         System.out.format("|%-20s|%-15s|%-20s|%-15s|%-45s|\n", "Mã phòng","Tình trạng", "Giá phòng", "Loại phòng", "Mô tả phòng");
                         System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                         System.out.print(danhSachPhong.get(i));
                         System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                    }
               }
          }
          else
          {
               System.out.println("Không tìm thấy nhân viên");
          }
     }
     public void XuatPhong()
     {
          if(danhSachPhong.isEmpty())
          {
               System.out.println("Danh sách phòng trống");
          }
          else
          {
               System.out.println("|=======================================================================================================================|");
               System.out.format("|%-20s|%-15s|%-20s|%-15s|%-45s|\n", "Mã phòng","Tình trạng", "Giá phòng", "Loại phòng", "Mô tả phòng");
               System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
               for(int i = 0; i < danhSachPhong.size(); i++)
               {
                    System.out.print(danhSachPhong.get(i));
                    System.out.println("|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
               }
          }
     }
     public void DocfileP() {
          try {
               FileReader fr = new FileReader("src/DuLieu/DanhSachPhong.txt");
               BufferedReader br = new BufferedReader(fr);

               danhSachPhong = new ArrayList<Phong>();
               String line;
               String MaPhong, TinhTrangPhong, LoaiPhong, MoTaPhong;
               Long GiaPhong;
               while (true) {
                    line = br.readLine();
                    if (line == null) {
                         break;
                    }
                    String txt[] = line.split(";");
                    MaPhong = txt[0];
                    TinhTrangPhong = txt[1];
                    GiaPhong = Long.parseLong(txt[2]);
                    LoaiPhong = txt[3];
                    MoTaPhong = txt[4];
                    switch (LoaiPhong) {
                         case "Phòng VIP" ->
                                 danhSachPhong.add(new PhongVip(MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong));
                         case "Phòng đơn" ->
                                 danhSachPhong.add(new PhongDon(MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong));
                         case "Phòng đôi" ->
                                 danhSachPhong.add(new PhongDoi(MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong));
                    }
               }
          } catch (Exception e) {
               System.out.println(e);
          } finally {

          }

     }
     public void MenuDSP() {
          int choice;
          do {
               System.out.println("\n============================================");
               System.out.println("||               Quản lý Phòng            ||");
               System.out.println("||________________________________________||");
               System.out.println("|| 1. Xuất danh sách phòng                ||");
               System.out.println("|| 3. Thêm phòng                          ||");
               System.out.println("|| 4. Sửa thông tin phòng                 ||");
               System.out.println("|| 5. Xóa phòng                           ||");
               System.out.println("|| 6. Tìm kiếm phòng                      ||");
               System.out.println("|| 0. Lưu lại                             ||");
               System.out.println("============================================");
               System.out.print("Bạn muốn: ");
               choice = scanner.nextInt();
               scanner.nextLine();
               switch (choice) {
                    case 1 ->
                            XuatPhong();

                    case 3 ->
                            Them();
                    case 4 ->
                            Sua();
                    case 5 ->
                            Xoa();
                    case 6 ->
                            TimKiemPhong();
                    default ->
                            System.out.println("Hãy chọn lại: ");
               }
          } while (choice != 0);
     }
     public void GhifileP() {
          try {
               FileWriter fw = new FileWriter("src/DuLieu/DanhSachPhong.txt");
               BufferedWriter bw = new BufferedWriter(fw);

               for (Phong i : danhSachPhong) {
                    bw.write(i.Ghifile());
                    bw.newLine();
               }

               bw.close();
               fw.close();
          } catch (Exception e) {
               System.out.println(e);
          }
     }
     public static void main(String[] args) {
          DanhSachPhong p = new DanhSachPhong();
          p.DocfileP();
          p.MenuDSP();
          p.GhifileP();
     }
}
