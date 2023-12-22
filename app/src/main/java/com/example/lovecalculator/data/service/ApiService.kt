package com.example.lovecalculator.data.service

import com.example.lovecalculator.core.Const
import com.example.lovecalculator.data.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {


    @GET("getPercentage?")
    fun getCalculator(
        @Query("sname") sName: String,
        @Query("fname") fName: String,
        @Header("X-RapidAPI-Key") key: String = Const.XRapidApiKey,
        @Header("X-RapidAPI-Host") host: String = Const.XRapidApiHost
    ): Call<LoveModel>
}