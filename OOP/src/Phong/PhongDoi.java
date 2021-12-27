package Phong;

public class PhongDoi extends Phong
{
    public PhongDoi()
    {
        super();
    }
    public PhongDoi(String MaPhong, String TinhTrangPhong, long GiaPhong, String LoaiPhong, String MoTaPhong){
        super(MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong);
    }
    @Override
    public void setGiaPhong() {
        GiaPhong = 800000;
    }

    @Override
    public void setLoaiPhong() {
        LoaiPhong = "Phòng đôi";
    }

    @Override
    public void setMoTaPhong() {
        MoTaPhong = "1 giường lớn, tiện nghi cao cấp";
    }

    public void Nhap()
    {
        super.Nhap();
        setGiaPhong();
        setLoaiPhong();
        setMoTaPhong();
    }
}
