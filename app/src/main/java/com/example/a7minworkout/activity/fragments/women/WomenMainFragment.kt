package com.example.a7minworkout.activity.fragments.women

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.adapter.WorkoutAdapter
import com.example.a7minworkout.activity.const.Constants
import com.example.a7minworkout.activity.model.User
import com.example.a7minworkout.databinding.FragmentWomenMainBinding
import java.util.*
import kotlin.collections.ArrayList


class WomenMainFragment : Fragment(),TextToSpeech.OnInitListener {
private lateinit var binding: FragmentWomenMainBinding
    private lateinit var list: ArrayList<User>
    private var tts: TextToSpeech? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentWomenMainBinding.inflate(inflater, container, false)
        list = ArrayList()
        list = Constants.getWomens()

        tts = TextToSpeech(requireContext(), this)
        binding.recycler.adapter = WorkoutAdapter(list) {
            Toast.makeText(
                requireContext(), it.name, Toast.LENGTH_SHORT
            ).show()

            speakOut(it.name.toString())
        }

        binding.back.setOnClickListener {


            requireActivity().onBackPressed()
        }


        binding.start.setOnClickListener {
            findNavController().navigate(R.id.womenStertFragment)
        }


        return binding.root
    }
    private fun speakOut(toString: String) {
        tts?.speak(toString, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {

            } else {

            }
        } else {

        }
    }


}