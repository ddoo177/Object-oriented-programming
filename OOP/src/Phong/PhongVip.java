package Phong;

public class PhongVip extends Phong
{
    public PhongVip()
    {
        super();
    }
    public PhongVip(String MaPhong, String TinhTrangPhong, long GiaPhong, String LoaiPhong, String MoTaPhong){
        super(MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong);
    }
    @Override
    public void setGiaPhong() {
        GiaPhong = 1500000;
    }

    @Override
    public void setLoaiPhong() {
        LoaiPhong = "Phòng VIP";
    }

    @Override
    public void setMoTaPhong() {
        MoTaPhong = "2 giường, view biển, bồn tắm lớn";
    }

    public void Nhap()
    {
        super.Nhap();
        setGiaPhong();
        setLoaiPhong();
        setMoTaPhong();
    }
}
