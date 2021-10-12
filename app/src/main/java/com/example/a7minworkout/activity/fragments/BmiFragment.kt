package com.example.a7minworkout.activity.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.charts.Cartesian
import com.example.a7minworkout.activity.adapter.MasAdapter
import com.example.a7minworkout.activity.shared.SharedPreference
import com.example.a7minworkout.activity.user.Model
import com.example.a7minworkout.databinding.FragmentBmiBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class BmiFragment : Fragment() {

    private lateinit var binding: FragmentBmiBinding

    var user = ""

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBmiBinding.inflate(inflater, container, false)

        SharedPreference.init(requireContext())
        val date = SimpleDateFormat("dd/MM/yyyy hh:mm:ss ")
        var currencyDate = date.format(Date())

        if (SharedPreference.userDate.isNullOrEmpty()) {


        } else {
            user=SharedPreference.userDate.toString()
            binding.speed.setSpeed(user.toFloat())
            if (user!!.toFloat() > 56.7 && user
                    .toFloat() < 76.6
            ) {
                binding.weigthText.text = "Overweight"
                binding.weight.text = "0.0"
                binding.text.text = "medium"
            }
            if (user.toFloat() > 76.6) {
                binding.weigthText.text = "Overweight"
                binding.weight.text = "${user.toFloat() - 76.6}"
                binding.text.text = "heavy"

            }
            if (user.toFloat() < 56.7) {
                binding.weigthText.text = "Light"
                binding.weight.text = "${56.7 - user!!.toFloat()}"
                binding.text.text = "light"
            }
        }
        binding.save.setOnClickListener {
            if (binding.kg.text.isNullOrEmpty() || binding.sm.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Please fill all gaps", Toast.LENGTH_SHORT).show()
            } else {
                SharedPreference.userDate = binding.kg.text.toString()

                val name = binding.kg.text.toString()
                binding.speed.setSpeed(binding.kg.text.toString().toFloat())
                if (name!!.toFloat() > 56.7 && name
                        .toFloat() < 76.6
                ) {
                    binding.weigthText.text = "Overweight"
                    binding.weight.text = "0.0"
                    binding.text.text = "medium"
                }
                if (name.toFloat() > 76.6) {
                    binding.weigthText.text = "Overweight"
                    binding.weight.text = "${name.toFloat() - 76.6}"
                    binding.text.text = "heavy"

                }
                if (name.toFloat() < 56.7) {
                    binding.weigthText.text = "Light"
                    binding.weight.text = "${56.7 - name!!.toFloat()}"
                    binding.text.text = "light"
                }
            }
        }

        return binding.root
    }


}