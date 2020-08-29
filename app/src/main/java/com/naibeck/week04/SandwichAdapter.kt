package com.naibeck.week04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SandwichAdapter constructor(private val sandwiches: List<Sandwich>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sandwich, parent, false)
        return SandwichViewHolder(view)
    }

    override fun getItemCount(): Int = sandwiches.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    class SandwichViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

    }
}
