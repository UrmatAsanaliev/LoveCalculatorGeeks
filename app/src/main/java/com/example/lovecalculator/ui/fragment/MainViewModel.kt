package com.example.lovecalculator.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.data.model.LoveModel
import com.example.lovecalculator.data.repository.UserRepository

class MainViewModel: ViewModel() {

    private val repo = UserRepository()

    var liveData: LiveData<LoveModel> = MutableLiveData()

    fun getCalculator(fName: String, sName: String) {
        liveData = repo.getUsers(fName, sName)

    }
}