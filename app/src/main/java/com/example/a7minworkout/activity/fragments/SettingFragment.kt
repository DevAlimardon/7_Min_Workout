package com.example.a7minworkout.activity.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.const.Times
import com.example.a7minworkout.databinding.FragmentSettingBinding
import kotlinx.coroutines.NonCancellable.cancel

class SettingFragment : Fragment() {
private lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSettingBinding.inflate(inflater, container, false)
        binding.share.setOnClickListener {
            val dialog=AlertDialog.Builder(requireContext()).create()
            dialog.setTitle("Do you want to share this app?")
            dialog.setCanceledOnTouchOutside(false)
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"Yes", DialogInterface.OnClickListener { dialog, which ->
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val url = ""
                intent.putExtra(Intent.EXTRA_SUBJECT, "7 min workout app mobile app ")
                intent.putExtra(Intent.EXTRA_TEXT, url)
                startActivity(intent)
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            dialog.show()

        }
        binding.chasWork.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val view = layoutInflater.inflate(R.layout.dialogottiz_item, binding.root, false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val minus = view.findViewById<AppCompatImageView>(R.id.minus)
            val pilus = view.findViewById<AppCompatImageView>(R.id.pilus)
            val text = view.findViewById<AppCompatTextView>(R.id.text_dialog)
            val save=view.findViewById<AppCompatTextView>(R.id.save)
            val cancel=view.findViewById<AppCompatTextView>(R.id.cancel)
            text.text = Times.thirsty.toString()
            var a = Times.thirsty
            dialog.setCanceledOnTouchOutside(false)
            minus.setOnClickListener {

                a--
                text.text = a.toString()
            }
            pilus.setOnClickListener {
                a++
                text.text = a.toString()
            }
            save.setOnClickListener {
                Times.thirsty=a
                dialog.dismiss()
            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setView(view)
            dialog.show()
        }
        binding.chasRest.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val view = layoutInflater.inflate(R.layout.dialogottiz_item, binding.root, false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val minus = view.findViewById<AppCompatImageView>(R.id.minus)
            val pilus = view.findViewById<AppCompatImageView>(R.id.pilus)
            val text = view.findViewById<AppCompatTextView>(R.id.text_dialog)
            val save=view.findViewById<AppCompatTextView>(R.id.save)
            val cancel=view.findViewById<AppCompatTextView>(R.id.cancel)
            text.text = Times.ten.toString()
            var a = Times.ten
            dialog.setCanceledOnTouchOutside(false)
            minus.setOnClickListener {

                a--
                text.text = a.toString()
            }
            pilus.setOnClickListener {
                a++
                text.text = a.toString()
            }
            save.setOnClickListener {
                Times.ten=a
                dialog.dismiss()

            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setView(view)
            dialog.show()
        }

        return binding.root
    }


}