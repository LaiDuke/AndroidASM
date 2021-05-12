package com.fpt.aptech.t1902e.asm.service;

import com.fpt.aptech.t1902e.asm.model.Forecast;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.fpt.aptech.t1902e.asm.Const.URI;

public interface ServiceManagement {

    @GET(URI)
    Call<List<Forecast>> getListData();
}
