package com.example.lovecalculator.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.lovecalculator.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        binding.btnCalculate.setOnClickListener {
            val fname = binding.edFname.text.toString()
            val sname = binding.edSname.text.toString()
            getResult(fname, sname)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getResult(fname: String, sname: String) {
        viewModel.getCalculator(fname, sname)
        viewModel.liveData.observe(requireActivity()) {
            binding.txtResult.text = "${it.percentage}%"
        }

    }
}