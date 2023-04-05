import java.util.ArrayList;

public class GiamDoc extends NhanSu {
    private double coPhanNamGiu;

    public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, int luongTheoNgay, double coPhanNamGiu) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luongTheoNgay);
        if (coPhanNamGiu <= 1){
            this.coPhanNamGiu = coPhanNamGiu;
        }
    }

    public double getCoPhanNamGiu() {
        return this.coPhanNamGiu;
    }

    public void setCoPhanNamGiu(double coPhanNamGiu) {
        this.coPhanNamGiu = coPhanNamGiu;
    }

    //tinh luong cua giam doc
    public int cachTinhLuong(int soNgayLamViec){
        return 300 * soNgayLamViec;
    }

    //tinh thu nhap cua giam doc
    public int thuNhapCuaGiamDoc(int soNgayLamViec){
        return (int) (this.cachTinhLuong(soNgayLamViec) + this.coPhanNamGiu * 200000); //200000 la loi nhuan cong ty
    }
    //them giam doc vao danh sach
//    public void themGiamDoc(GiamDoc gd){
//        this.danhSachGiamDoc.add(gd);
//    }
    //show danh sach giam doc
//    public void showDanhSachGiamDoc(){
//        for (GiamDoc gd : danhSachGiamDoc){
//            gd.lietKeThongTinNhanVien();
//            System.out.println(" So co phan nam giu: " + this.getCoPhanNamGiu());
//        }
//    }
}
