package com.fpt.aptech.t1902e.asm.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fpt.aptech.t1902e.asm.R;
import com.fpt.aptech.t1902e.asm.model.Forecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter{
    //Adapter nhan vao layout va data

    private Activity activity;
    private List<Forecast> listData;

    public  void reloadData(List<Forecast> list){
        this.listData = list;
        this.notifyDataSetChanged();
    }
    //B1
    public ForecastAdapter(Activity activity, List<Forecast> listData) {
        this.activity = activity;
        this.listData = listData;
    }

    //B3
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.forecast_item, parent, false);
        return new ForecastHolder(itemView);
    }

    //B4
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Forecast model = listData.get(position);
        ForecastHolder vh = (ForecastHolder) holder;
        Glide.with(activity).load(convertIcon((int) model.getWeatherIcon())).into(vh.icon);
        vh.tvTime.setText(convertTime(model.getDateTime()));
        vh.tvTemp.setText(String.format("%s°", model.getTemperature().getValue()));

    }

    //B5
    @Override
    public int getItemCount() {
        return listData.size();
    }

    //B2
    public class ForecastHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tvTime;
        TextView tvTemp;

        public ForecastHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.ivIcon);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvTemp = itemView.findViewById(R.id.tvTemp);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        return outFormat.format(date);
    }
    public String convertIcon(int input){
        String Url = "https://developer.accuweather.com/sites/default/files/";
        if(input < 10){
            return  Url+"0"+input+"-s.png";
        }
        return  Url+input+"-s.png";
    }
}
