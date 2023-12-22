package com.example.lovecalculator.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.data.model.LoveModel
import com.example.lovecalculator.data.service.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository() {

    private val api = ApiResponse().getApi()

    fun getUsers(fname: String, sname: String): LiveData<LoveModel> {
        val livedata = MutableLiveData<LoveModel>()
        api.getCalculator(fname, sname).enqueue(object: Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                livedata.value = response.body()
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", t.message.toString())
            }
        })
        return livedata
    }
}