import java.util.ArrayList;

public class TruongPhong extends NhanSu {
    private int soLuongNVcapDuoi;
    ArrayList<NhanVien> danhSachNhanVienDuoiQuyen = new ArrayList<>();
    //constructor
    public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, int luongTheoNgay, int soLuongNVcapDuoi) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luongTheoNgay);
        this.soLuongNVcapDuoi = soLuongNVcapDuoi;
    }

    //getter setter
    public int getSoLuongNVcapDuoi() {
        return soLuongNVcapDuoi;
    }

    public void setSoLuongNVcapDuoi(int soLuongNVcapDuoi) {
        this.soLuongNVcapDuoi = soLuongNVcapDuoi;
    }

    public void setDanhSachNhanVienDuoiQuyen(ArrayList<NhanVien> danhSachNhanVienDuoiQuyen) {
        this.danhSachNhanVienDuoiQuyen = danhSachNhanVienDuoiQuyen;
    }

    public ArrayList<NhanVien> getDanhSachNhanVienDuoiQuyen() {
        return this.danhSachNhanVienDuoiQuyen;
    }

    public void themNhanVienVaoTeam(NhanVien nv){
        this.soLuongNVcapDuoi++;
        danhSachNhanVienDuoiQuyen.add(nv);
    }

    public int cachTinhLuong(int soNgayLamViec){
        return 200 * soNgayLamViec * this.soLuongNVcapDuoi; //luong cua truong phong 1 ngay la 200
    }


}
