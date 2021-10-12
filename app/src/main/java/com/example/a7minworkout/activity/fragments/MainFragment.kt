package com.example.a7minworkout.activity.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.WHITE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.activity.MainActivity2
import com.example.a7minworkout.activity.activity.MainActivity3
import com.example.a7minworkout.activity.activity.MainActivity4
import com.example.a7minworkout.activity.const.Times
import com.example.a7minworkout.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var b = false
    private var a = false

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.start.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity2::class.java)
            startActivity(intent)
        }
        binding.warmup.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity3::class.java)
            startActivity(intent)
        }

        binding.stretch.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity4::class.java)
            startActivity(intent)

        }
        binding.time.text = "Total workout time: ${(Times.thirsty * 11 + Times.ten * 11) / 60} min"
        return binding.root
    }


}