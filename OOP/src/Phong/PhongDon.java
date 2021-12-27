package Phong;

public class PhongDon extends Phong
{
    public PhongDon()
    {
        super();
    }
    public PhongDon(String MaPhong, String TinhTrangPhong, long GiaPhong, String LoaiPhong, String MoTaPhong){
        super(MaPhong, TinhTrangPhong, GiaPhong, LoaiPhong, MoTaPhong);
    }
    @Override
    public void setGiaPhong() {
        GiaPhong = 500000;
    }

    @Override
    public void setLoaiPhong() {
        LoaiPhong = "Phòng đơn";
    }

    @Override
    public void setMoTaPhong() {
        MoTaPhong = "1 giường, yên tĩnh, tiện nghi đầy đủ";
    }
    public void Nhap()
    {
        super.Nhap();
        setGiaPhong();
        setLoaiPhong();
        setMoTaPhong();
    }
}
