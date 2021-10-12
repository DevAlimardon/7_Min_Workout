package com.example.a7minworkout.activity.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.adapter.WorkoutAdapterView
import com.example.a7minworkout.activity.const.Constants
import com.example.a7minworkout.databinding.FragmentExerciseBinding


class ExerciseFragment : Fragment() {

private lateinit var binding: FragmentExerciseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentExerciseBinding.inflate(inflater, container, false)
        binding.recycler.adapter= WorkoutAdapterView(Constants.AllExercises())


        binding.recycler.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

        }
//        binding.recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//
//                binding.add.visibility = View.GONE
//                super.onScrolled(recyclerView, dx, dy)
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                binding.add.visibility = View.VISIBLE
//                super.onScrollStateChanged(recyclerView, newState)
//            }
//        })
        binding.materialCardView.setOnClickListener {
            val dialog=AlertDialog.Builder(requireContext()).create()
            var view=layoutInflater.inflate(R.layout.add_dialog_item,binding.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setView(view)

        }
        return binding.root
    }


}