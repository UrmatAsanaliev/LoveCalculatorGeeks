package com.example.lovecalculator.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiResponse {

    fun getApi() =
        Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}