public class NhanVien extends NhanSu {
    private String maSoCuaTruongPhongCapTren = null;

    public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, int luongTheoNgay, String capTren) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luongTheoNgay);
        this.maSoCuaTruongPhongCapTren = capTren;
    }

    //getter setter
    public String getMaSoCuaTruongPhongCapTren() {
        return maSoCuaTruongPhongCapTren;
    }

    public void setMaSoCuaTruongPhongCapTren(String maSoCuaTruongPhongCapTren) {
        this.maSoCuaTruongPhongCapTren = maSoCuaTruongPhongCapTren;
    }

    public int cachTinhLuong(int soNgayLamViec){
        return 100 * soNgayLamViec; //luong cua nhan vien 1 ngay la 100
    }
}
