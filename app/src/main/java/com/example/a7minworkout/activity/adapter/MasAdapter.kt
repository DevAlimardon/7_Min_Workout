package com.example.a7minworkout.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.user.Model
import kotlinx.android.synthetic.main.mas_item.view.*

class MasAdapter(var list: List<Model>) : RecyclerView.Adapter<MasAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(model: Model) {
            itemView.apply {
                mas.text = model.mas
                heit.text = model.height
                date.text = model.date
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.mas_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}