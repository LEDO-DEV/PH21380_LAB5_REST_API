package dolvph21380.fpoly.ph21380_lab5_rest_api;

public class sanpham {
    private String MaSp,TenSP,MoTa;

    public sanpham() {
    }

    public sanpham(String maSp, String tenSP, String moTa) {
        MaSp = maSp;
        TenSP = tenSP;
        MoTa = moTa;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String maSp) {
        MaSp = maSp;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }
}
