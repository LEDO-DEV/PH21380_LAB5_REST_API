package dolvph21380.fpoly.ph21380_lab5_rest_api;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3;
    TextView tvKQ;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.demo51Txt1);
        txt2=findViewById(R.id.demo51Txt2);
        txt3=findViewById(R.id.demo51Txt3);
        tvKQ=findViewById(R.id.demo51TvKQ);
        btn1=findViewById(R.id.demo51Btn1);
        btn1.setOnClickListener(v ->{
            insertData(txt1,txt2,txt3,tvKQ);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void insertData(EditText txt1, EditText txt2, EditText txt3, TextView tvKQ){
        sanpham s=new sanpham(txt1.getText().toString(),txt2.getText().toString(),txt3.getText().toString());

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.1.14/2024071/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interfaceinsertsanpham insertsanpham
                =retrofit.create(Interfaceinsertsanpham.class);

        Call<SvrResponsesanpham> call=insertsanpham.insertSanPham(s.getMaSp(),s.getTenSP(),s.getMoTa());

        call.enqueue(new Callback<SvrResponsesanpham>() {
            @Override
            public void onResponse(Call<SvrResponsesanpham> call, Response<SvrResponsesanpham> response) {
                SvrResponsesanpham res=response.body();
                tvKQ.setText(res.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponsesanpham> call, Throwable t) {
                tvKQ.setText(t.getMessage());
            }
        });
    }
}