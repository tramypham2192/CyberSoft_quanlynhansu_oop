import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String optionDuocChon = chonOption(sc);
        ArrayList<ArrayList> danhSachToanBoCongNhanVien = new ArrayList<>();
        while (!(optionDuocChon.equals("0"))){
            danhSachToanBoCongNhanVien = manage(sc, optionDuocChon, danhSachToanBoCongNhanVien);
            optionDuocChon = chonOption(sc);
        }
    }

    public static ArrayList<ArrayList> manage(Scanner sc, String option, ArrayList<ArrayList> danhSachToanBoCongNhanVien) {
        ArrayList<GiamDoc> danhSachGiamDoc = new ArrayList<>();
        ArrayList<TruongPhong> danhSachTruongPhong = new ArrayList<>();
        ArrayList<NhanVien> danhSachNhanVienCapDuoi = new ArrayList<>();
        switch (option) {
            case "1":
                System.out.println("Nhap vao thong tin cong ty ");

                //THEM THONG TIN CAC GIAM DOC
                System.out.println("Nhap vao so luong giam doc: ");
                int soLuongGiamDoc = sc.nextInt();
                //tao array list giam doc
                for (int i = 1; i <= soLuongGiamDoc; i++) {
                    System.out.println("Nhap vao ma so cua giam doc thu " + i + ":");
                    String maSo = sc.next();
                    System.out.println("Nhap vao ho ten cua giam doc thu " + i + ":");
                    String hoTen = sc.next();
                    System.out.println("Nhap vao so dien thoai cua giam doc thu " + i + ":");
                    String soDienThoai = sc.next();
                    System.out.println("Nhap vao so ngay lam viec cua giam doc thu " + i + ":");
                    int soNgayLamViec = sc.nextInt();
                    System.out.println("Nhap vao so co phan nam giu cua giam doc thu " + i + ":");
                    double coPhanNamGiu = sc.nextDouble();
                    GiamDoc newGiamDocObj = new GiamDoc(maSo, hoTen, soDienThoai, soNgayLamViec, 300, coPhanNamGiu); //300 la luong giam doc 1 ngay
                    danhSachGiamDoc.add(new GiamDoc(maSo, hoTen, soDienThoai, soNgayLamViec, 300, coPhanNamGiu));
                    danhSachToanBoCongNhanVien.add(danhSachGiamDoc);
                    System.out.println("Danh sach giam doc den thoi diem hien tai: ");
                    //liet ke danh sach giam doc
                    for (GiamDoc gd : danhSachGiamDoc) gd.lietKeThongTinNhanVien();
                }

                //THEM THONG TIN CAC TRUONG PHONG
                System.out.println("Nhap vao so luong truong phong: ");
                int soLuongTruongPhong = sc.nextInt();
                //tao array list truong phong
                for (int i = 1; i <= soLuongTruongPhong; i++) {
                    System.out.println("Nhap vao ma so cua truong phong thu " + i + ":");
                    String maSo = sc.next();
                    System.out.println("Nhap vao ho ten cua truong phong thu " + i + ":");
                    String hoTen = sc.next();
                    System.out.println("Nhap vao so dien thoai cua truong phong thu " + i + ":");
                    String soDienThoai = sc.next();
                    System.out.println("Nhap vao so ngay lam viec cua truong phong thu " + i + ":");
                    int soNgayLamViec = sc.nextInt();
                    System.out.println("Nhap vao so luong nhan vien cap duoi cua truong phong thu " + i + ":");
                    int soLuongNhanVienCapDuoi = sc.nextInt();
                    TruongPhong newTruongPhongObj = new TruongPhong(maSo, hoTen, soDienThoai, soNgayLamViec, 200, soLuongNhanVienCapDuoi);
                    danhSachTruongPhong.add(new TruongPhong(maSo, hoTen, soDienThoai, soNgayLamViec, 200, soLuongNhanVienCapDuoi));
                    danhSachToanBoCongNhanVien.add(danhSachTruongPhong);
                    System.out.println("Danh sach truong phong den thoi diem hien tai: ");
                    for (TruongPhong tp : danhSachTruongPhong) {
                        tp.lietKeThongTinNhanVien();
                        System.out.println("So nhan vien cap duoi: " + tp.getSoLuongNVcapDuoi());
                    }
                }
                break;

            case "2":
                //Lay ra danh sach toan bo cong nhan vien trong cong ty roi lay ra danh sach truong phong dang co
                ArrayList<TruongPhong> danhSachTruongPhongDangCo = danhSachToanBoCongNhanVien.get(1);
                //Nhap thong tin truong phong can them nhan vien
                System.out.println("Nhap vao ma so cua truong phong can phan bo them nhan vien: ");
                String maSoCuaTruongPhongCanThemNhanVien = sc.next();
                //Tinh so nhan vien can them vao cho truong phong co ma so nhu tren va get danh sach nhan vien cap duoi hien tai truong
                //phong co ma so nhu tren dang co
                int soNhanVienCanThem = 0;
                for (int i = 0; i < danhSachTruongPhongDangCo.size(); i++){
                    if (danhSachTruongPhongDangCo.get(i).getMaSo().equals(maSoCuaTruongPhongCanThemNhanVien)){
                        soNhanVienCanThem = danhSachTruongPhongDangCo.get(i).getSoLuongNVcapDuoi() - danhSachTruongPhongDangCo.get(i).danhSachNhanVienDuoiQuyen.size();
                        danhSachNhanVienCapDuoi = danhSachTruongPhongDangCo.get(i).getDanhSachNhanVienDuoiQuyen();
                    }

                }
                System.out.println("Truong phong co ma so " + maSoCuaTruongPhongCanThemNhanVien + " can duoc them " + soNhanVienCanThem + " nhan vien" );
                //Them vao thong tin cac nhan vien phan bo cho truong phong co ma so nhu tren
                //Neu truong phong co du so nhan vien duoc khoi tao luc ban dau roi nhung van muon add them nhan vien
                if (soNhanVienCanThem == 0){
                    System.out.println("Hien tai truong phong nay co du so nhan vien duoc phan cong ban dau roi. Ban van muon them nhan vien?");
                    String cauTraLoi = sc.next();
                    if (cauTraLoi.equals("Them")){
                        System.out.println("Nhap vao ma so cua nhan vien :");
                        String maSo = sc.next();
                        System.out.println("Nhap vao ho ten cua nhan vien:");
                        String hoTen = sc.next();
                        System.out.println("Nhap vao so dien thoai cua nhan vien:");
                        String soDienThoai = sc.next();
                        System.out.println("Nhap vao so ngay lam viec cua nhan vien:");
                        int soNgayLamViec = sc.nextInt();
                        NhanVien nhanVienObj = new NhanVien(maSo, hoTen, soDienThoai, soNgayLamViec, 100, maSoCuaTruongPhongCanThemNhanVien);
                        danhSachNhanVienCapDuoi.add(nhanVienObj);
                        System.out.println("Truong phong co ma so " + maSoCuaTruongPhongCanThemNhanVien + "co list nhan vien sau khi them nhan vien vua roi nhu sau: ");
                        for (NhanVien nv : danhSachNhanVienCapDuoi){
                            nv.lietKeThongTinNhanVien();
                        }
                    }
                }
                //Neu truong phong chua co du so nhan vien duoc phan cong ban dau thi them nhu binh thuong
                else {
                    System.out.println("Nhap thong tin cua nhan vien can them vao cho truong phong co ma so la " + maSoCuaTruongPhongCanThemNhanVien + ":");
                    for (int i = 1; i <= soNhanVienCanThem; i++){
                        System.out.println("Nhap vao ma so cua nhan vien thu " + i + ":");
                        String maSo = sc.next();
                        System.out.println("Nhap vao ho ten cua nhan vien thu " + i + ":");
                        String hoTen = sc.next();
                        System.out.println("Nhap vao so dien thoai cua nhan vien thu " + i + ":");
                        String soDienThoai = sc.next();
                        System.out.println("Nhap vao so ngay lam viec cua nhan vien thu " + i + ":");
                        int soNgayLamViec = sc.nextInt();
                        NhanVien nhanVienObj = new NhanVien(maSo, hoTen, soDienThoai, soNgayLamViec, 100, maSoCuaTruongPhongCanThemNhanVien);
                        danhSachNhanVienCapDuoi.add(nhanVienObj);
                    }
                    System.out.println("Truong phong co ma so " + maSoCuaTruongPhongCanThemNhanVien + "co list nhan vien sau khi them nhan vien vua roi nhu sau: ");
                    for (NhanVien nv : danhSachNhanVienCapDuoi){
                        nv.lietKeThongTinNhanVien();
                    }
                    danhSachToanBoCongNhanVien.add(danhSachNhanVienCapDuoi);
                }
                break;

            case "3":
                ArrayList<NhanVien> danhSachNhanVien = danhSachToanBoCongNhanVien.get(2);
                System.out.println("Ban can thay doi thong tin nhan vien hay xoa nhan vien do khoi danh sach nhan vien?: ");
                String luaChon = sc.next();
                if (luaChon.equals("thaydoi")){
                    System.out.println("Nhap thong tin ma so nhan vien can thay doi thong tin: ");
                    String maSoNVThayDoiInfo = sc.next();
                    for (int i = 0; i < danhSachNhanVien.size(); i++){
                        danhSachNhanVien.get(i).lietKeThongTinNhanVien();
                        if (danhSachNhanVien.get(i).getMaSo().equals(maSoNVThayDoiInfo)){
                            System.out.println("Nhap thong tin can thay doi (ho ten/so dien thoai/so ngay lam viec):");
                            String thongTinCanThayDoi = sc.next();
                            if (thongTinCanThayDoi.equals("hoten")){
                                System.out.println("Nhap vao ho ten chinh xac cua nhan vien: ");
                                String hoTenChinhXac = sc.nextLine();
                                danhSachNhanVien.get(i).setHoTen(hoTenChinhXac);
                                System.out.println("Thong tin cua nhan vien co ma so " + maSoNVThayDoiInfo + " sau khi thay doi ho ten la:");
                                danhSachNhanVien.get(i).lietKeThongTinNhanVien();
                            }
                        }
                }
                if (luaChon.equals("xoa")){
                    System.out.println("Nhap thong tin ma so nhan vien can xoa: ");
                    String maSoNVXoa = sc.next();
                    for (int i = 0; i < danhSachNhanVienCapDuoi.size(); i++) {
                        danhSachNhanVienCapDuoi.remove(i);
                    }
                    System.out.println("Danh sach nhan vien sau khi xoa:");
                    for (NhanVien nv : danhSachNhanVienCapDuoi){
                        nv.lietKeThongTinNhanVien();
                    }
                }

                }
//                TruongPhong truongPhongCoNVThayDoiThongTin =

        }
        return danhSachToanBoCongNhanVien;
    }

    public static String chonOption(Scanner sc){
        System.out.println("Cac chuc nang: ");
        System.out.println("1. Nhap thong tin cong ty");
        System.out.println("2. Phan bo nhan vien vao truong phong");
        System.out.println("3. Them, xoa thong tin nhan su bat ki");
        System.out.println("4. Xuat ra thong tin toan bo nguoi trong cong ty");
        System.out.println("5- Tinh va xuat tong luong cho toan cong ty");
        System.out.println("6. Tim nhan vien co luong cao nhat");
        System.out.println("7. Tim truong phong co so luong nhan vien duoi quyen nhieu nhat");
        System.out.println("8. Sap xep nhan vien toan cong ty theo thu tu abc");
        System.out.println("9. Sap xep nhan vien theo thu tu luong giam dan");
        System.out.println("10. Tim giam doc co so luong co phan nhieu nhat");
        System.out.println("11. Tinh va xuat tong thu nhap cua tung giam doc");
        System.out.println("Exit");

        System.out.println("Hay chon 1 chuc nang: ");
        String option = sc.next();
        return option;
    }


}
