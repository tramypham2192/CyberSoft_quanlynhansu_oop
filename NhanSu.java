public class NhanSu {
    private String maSo;
    private String hoTen;
    private String soDienThoai;
    private int soNgayLamViec;
    private int luongTheoNgay;

    public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, int luongTheoNgay) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLamViec = soNgayLamViec;
        this.luongTheoNgay = luongTheoNgay;
    }

    public NhanSu() {

    }

    public String getMaSo() {
        return maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public int getLuongTheoNgay() {
        return luongTheoNgay;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public void setLuongTheoNgay(int luongTheoNgay) {
        this.luongTheoNgay = luongTheoNgay;
    }
    //toString
    public void lietKeThongTinNhanVien(){
        System.out.println("Ma so:" + this.getMaSo() + " Ho ten:"  + this.getHoTen() + " So dien thoai:" + this.getSoDienThoai() + " So ngay lam viec:" + this.getSoNgayLamViec() + " Luong theo ngay:" + this.getLuongTheoNgay());
    }
}
