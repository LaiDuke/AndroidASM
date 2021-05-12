package com.fpt.aptech.t1902e.asm;

import android.os.Bundle;
import android.widget.TextView;

import com.fpt.aptech.t1902e.asm.adapter.ForecastAdapter;
import com.fpt.aptech.t1902e.asm.model.Forecast;
import com.fpt.aptech.t1902e.asm.service.ServiceManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Forecast> listData = new ArrayList<>();
    ForecastAdapter adapter;

    TextView tvIconMain, tvTemperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //B1: RecyclerView
        RecyclerView rvMessage = findViewById(R.id.rvForecast);

        tvIconMain = findViewById(R.id.tvIconMain);
        tvTemperature = findViewById(R.id.tvTemperature);

        //B2: Datasource
        initData();

        //B3: Layout manager
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        //B4: Adapter
        adapter = new ForecastAdapter(this, listData);
        rvMessage.setLayoutManager(layoutManager);
        rvMessage.setAdapter(adapter);

    }

    private void initData() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Const.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceManagement service = retrofit.create(ServiceManagement.class);
        service.getListData().enqueue(new Callback<List<Forecast>>() {
            @Override
            public void onResponse(Call<List<Forecast>> call, Response<List<Forecast>> response) {
                if (response.body() != null){
                    listData = response.body();
                    assert listData != null;
                    Forecast weather = listData.get(0);
                    tvTemperature.setText(String.format("%s°", weather.getTemperature().getValue()));
                    tvIconMain.setText(weather.getIconPhrase());
                    adapter.reloadData(listData);

                }
            }

            @Override
            public void onFailure(Call<List<Forecast>> call, Throwable t) {
                tvIconMain.setText("error");
            }
        });
    }


}