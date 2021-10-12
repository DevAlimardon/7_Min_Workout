package com.example.a7minworkout.activity.fragments.women

import android.app.AlertDialog
import android.content.DialogInterface
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.const.Constants
import com.example.a7minworkout.activity.const.Times
import com.example.a7minworkout.activity.model.User
import com.example.a7minworkout.databinding.FragmentWomenStertBinding
import java.util.*
import kotlin.collections.ArrayList

class WomenStertFragment : Fragment() ,TextToSpeech.OnInitListener{
private lateinit var binding: FragmentWomenStertBinding
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var restTimerExec: CountDownTimer? = null
    private var restProgressExec = 0
    private var list: ArrayList<User>? = null
    var exercise = 0
    private var un = 0
    private var uttiz = 0
    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null
    var tugadi = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentWomenStertBinding.inflate(inflater, container, false)
        list = ArrayList()
        list = Constants.getWomens()
        tugadi = Times.women
        un = Times.ten
        uttiz = Times.thirsty
        tts = TextToSpeech(requireContext(), this)
        tts!!.speak(
            "hello first exercise ${list!![exercise].name}",
            TextToSpeech.QUEUE_FLUSH,
            null,
            ""
        )
        binding.back.setOnClickListener {
            findNavController().popBackStack()
            onDestroy()

        }
        tts!!.speak(
            "hello first exercise ${list!![exercise].name}",
            TextToSpeech.QUEUE_FLUSH,
            null,
            ""
        )
        nextAndBackBtn()
        restTime()
        reset()
        return binding.root
    }
    override fun onPause() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        if (player != null) {
            player!!.stop()
        }
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()

        }

        setRestProgressbar()

        super.onPause()
    }


    private fun mediaPlayer(b: Boolean) {
        if (b) {


            try {
                player = MediaPlayer.create(requireContext(), R.raw.aler)
                player!!.isLooping = false
                if (player!!.isPlaying) {
                    player!!.stop()

                }
                player!!.start()
//                player!!.setOnCompletionListener {
//                    player!!.stop()
//                    player!!.reset()
//                }

            } catch (e: Exception) {

            }
        } else {
            try {
                player = MediaPlayer.create(requireContext(), R.raw.clickuz)
                player!!.isLooping = false

                if (player!!.isPlaying) {
                    player!!.stop()

                }
                player!!.start()

//                player!!.setOnCompletionListener {
//                    player!!.stop()
//                    player!!.reset()
//                }


            } catch (e: Exception) {

            }
        }
    }


    private fun restTime() {
        binding.rest.setOnClickListener {
            un += 10
            reset()
        }
    }


    private fun nextAndBackBtn() {
        binding.next.setOnClickListener {
            binding.progressExec.max = un
            exercise++
            un = Times.ten
            reset()

        }
        binding.stop.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            dialog.setTitle("Do you want to exit?")
            dialog.setButton(
                AlertDialog.BUTTON_POSITIVE,
                "yes",
                DialogInterface.OnClickListener { dialog, which ->
                    findNavController().popBackStack()
                    onDestroy()
                })
            dialog.setButton(
                AlertDialog.BUTTON_NEGATIVE,
                "no",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
            dialog.show()
        }
    }


    override fun onDestroy() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        if (player != null) {
            player!!.stop()
        }
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()

        }
        setRestProgressbar()
        super.onDestroy()
    }


    private fun setRestProgressbar() {
        binding.progressExec.max = un
        tts!!.speak(
            "Take a rest. Next exercise ${list!![exercise].name}",
            TextToSpeech.QUEUE_FLUSH,
            null,
            ""
        )
        binding.progressExec.progress = restProgress
        restTimer = object : CountDownTimer((un * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding.progressExec.progress = un - restProgress
                binding.progressTextExec.text = (un - restProgress).toString()

                if ((un - restProgress) < 4 && (un - restProgress) > 0) {
                    player?.release()
                    mediaPlayer(true)

                } else if ((un - restProgress) == 0) {
                    player?.release()
                    mediaPlayer(false)
                }
            }

            override fun onFinish() {
                un = 10
                resetExec()
            }

        }.start()
    }


    private fun reset() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0

        }

        binding.number.text = "${exercise + 1}/$tugadi"
        binding.restLayout.visibility = View.VISIBLE
        binding.lottie.setAnimation(list!![exercise].image)
        binding.readyExec.text = list!![exercise].name
        binding.lottie.playAnimation()
        binding.lottie.loop(true)

        setRestProgressbar()
    }


    private fun setRestProgressbarExec() {
        binding.progressExec.progress = restProgressExec
        binding.progressExec.max = uttiz
        tts!!.speak(list!![exercise].name.toString(), TextToSpeech.QUEUE_FLUSH, null, "")
        exercise++
        restTimerExec = object : CountDownTimer((uttiz * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgressExec++
                binding.progressExec.progress = uttiz - restProgressExec
                binding.progressTextExec.text = (uttiz - restProgressExec).toString()
                if (uttiz - restProgressExec == 20 || uttiz - restProgressExec == 10) {
                    player?.release()
                }
                if ((uttiz - restProgressExec) > 0) {
                    player?.release()
                    mediaPlayer(true)
                } else if ((un - restProgress) == 0) {
                    player?.release()
                    mediaPlayer(false)
                }

            }

            override fun onFinish() {
                if (exercise < tugadi) {
                    reset()
                } else {
                    exercise = 0
                    findNavController().navigate(R.id.womenFinishFragment)
                    onDestroy()
                }
            }

        }.start()
    }


    private fun resetExec() {
        if (restTimerExec != null) {
            restTimerExec!!.cancel()
            restProgressExec = 0
        }
        binding.restLayout.visibility = View.GONE
        binding.lottie.setAnimation(list!![exercise].image)
        binding.readyExec.text = list!![exercise].name
        binding.lottie.playAnimation()
        binding.lottie.loop(true)
        setRestProgressbarExec()
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