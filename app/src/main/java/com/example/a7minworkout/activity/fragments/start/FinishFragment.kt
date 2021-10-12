package com.example.a7minworkout.activity.fragments.start

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.activity.MainActivity
import com.example.a7minworkout.databinding.FragmentFinishBinding


class FinishFragment : Fragment() {

    private lateinit var binding: FragmentFinishBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinishBinding.inflate(inflater, container, false)
        binding.confettiView.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLACK, Color.BLUE, Color.RED)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(
                nl.dionsegijn.konfetti.models.Shape.Square,
                nl.dionsegijn.konfetti.models.Shape.Circle
            )
            .addSizes(nl.dionsegijn.konfetti.models.Size(12))
            .setPosition(-50f, binding.confettiView.width + 50f, -50f, -50f)
            .streamFor(300, 5000L)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)

        }, 5000)
        return binding.root
    }


}