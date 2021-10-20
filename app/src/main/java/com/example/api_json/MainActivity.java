package com.example.api_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_json.API.ApiService;
import com.example.api_json.model.Currentcy;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvTerm, tvSource, tvFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFormat=findViewById(R.id.tvVND);
        tvSource=findViewById(R.id.tvSource);
        tvTerm=findViewById(R.id.tvTerms);
        Button btn=findViewById(R.id.btnBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                checkAPI();
            }
        });
                
    }

    private void checkAPI() {
        ApiService.apiService.convertUsdToVnd("843d4d34ae72b3882e3db642c51e28e6", "VND", "USD",1).enqueue(new Callback<Currentcy>() {
            @Override
            public void onResponse(Call<Currentcy> call, Response<Currentcy> response) {
                Toast.makeText(getBaseContext(), "Call is sucess", Toast.LENGTH_SHORT).show();
                Currentcy currentcy=response.body();
                if(currentcy!=null && currentcy.isSuccess())
                {
                    tvSource.setText(currentcy.getSource());
                    tvFormat.setText(String.valueOf(currentcy.getQuotes()));
                    tvTerm.setText(currentcy.getTerms());
                }
            }

            @Override
            public void onFailure(Call<Currentcy> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Call is failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}