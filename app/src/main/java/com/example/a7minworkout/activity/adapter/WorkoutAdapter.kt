package com.example.a7minworkout.activity.adapter

import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.const.Constants
import com.example.a7minworkout.activity.const.Times
import com.example.a7minworkout.activity.model.User
import kotlinx.android.synthetic.main.item_work.view.*
import java.util.*
import kotlin.collections.ArrayList

class WorkoutAdapter(var list: ArrayList<User>, val onClick: (user: User) -> Unit) :
    RecyclerView.Adapter<WorkoutAdapter.ViewHolder>(),TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User) {


            itemView.apply {
                text_user.text = user.name
                number_user.text = "${adapterPosition + 1}/${list.size}"
                lottie.setAnimation(user.image)
                sec_user.text="${Times.thirsty} sec"
                rest_time.text="Rest: ${Times.ten}"
                tts= TextToSpeech(context,this@WorkoutAdapter)
                mat.setOnClickListener {
                    tts!!.speak(user.name,TextToSpeech.QUEUE_FLUSH,null,"")
                }

            }

            itemView.setOnClickListener {
                onClick(user)
            }


        }

//        override fun onClick(v: View?) {
//            var pos = adapterPosition
//            if (pos != RecyclerView.NO_POSITION) {
//                listener.onClick(pos)
//            }
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
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

//    interface OnClick {
//        fun onClick(position: Int)
//    }
}