package dolvph21380.fpoly.ph21380_lab5_rest_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Interfaceinsertsanpham {
    @FormUrlEncoded
    @POST("insert.php")
    Call<SvrResponsesanpham>insertSanPham(
        @Field("MaSP")String MaSP,
        @Field("TenSP")String TenSP,
        @Field("MoTa")String MoTa
    );
}
