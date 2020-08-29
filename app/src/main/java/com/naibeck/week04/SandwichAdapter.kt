package com.naibeck.week04

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SandwichAdapter constructor(private val sandwiches: List<Sandwich>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    }

    override fun getItemCount(): Int = sandwiches.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

}
