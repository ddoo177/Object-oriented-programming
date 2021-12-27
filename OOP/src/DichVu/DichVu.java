package DichVu;

import java.util.Scanner;
import DuLieu.CheckLoi;

public class DichVu {

	Scanner sc = new Scanner(System.in);
	private String MaDV;
	private String TenDV;
	private Long GiaDV;
	CheckLoi check = new CheckLoi();

	public DichVu() {
		MaDV = null;
		TenDV = null;
		GiaDV = null;
	}

	public DichVu(String MaDV, String TenDV, Long GiaDV) {
		this.MaDV = MaDV;
		this.TenDV = TenDV;
		this.GiaDV = GiaDV;
	}

	public String getMaDV() {
		return MaDV;
	}

	public String getTenDV() {
		return TenDV;
	}

	public Long getGiaDV() {
		return GiaDV;
	}

	public void setMaDV(String MaDV) {
		this.MaDV = MaDV;
	}

	public void setMaDV() {
		this.MaDV = check.KiemTraMaDV();
	}

	public void setTenDV(String TenDV) {
		this.TenDV = TenDV;
	}

	public void setTenDV() {
		this.TenDV = sc.nextLine();
	}

	public void setGiaDV(Long GiaDV) {
		this.GiaDV = GiaDV;
	}

	public void setGiaDV() {
		this.GiaDV = sc.nextLong();
	}

	public void Nhap(){
		System.out.print("Nhập mã dịch vụ: ");
		this.setMaDV();
		System.out.print("Nhập tên dịch vụ: ");
		this.setTenDV();
		System.out.print("Nhập giá dịch vụ: ");
		this.setGiaDV();
	}
	public String Ghifile(){
		return getMaDV()+";"+getTenDV()+";"+getGiaDV();
	}

	@Override
	public String toString() {
		return String.format("|%-10s|%-30s|%-15s|\n", MaDV, TenDV, GiaDV);
	}
}