package com.example.a7minworkout.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.model.User
import kotlinx.android.synthetic.main.work_item_view.view.*


class WorkoutAdapterView(var list: ArrayList<User>) :
    RecyclerView.Adapter<WorkoutAdapterView.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User) {

            itemView.apply {
                work_text.text = user.name.toString()
                work_lotti.setAnimation(user.image)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.work_item_view, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}