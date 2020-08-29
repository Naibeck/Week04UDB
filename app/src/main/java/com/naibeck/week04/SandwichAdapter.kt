package com.naibeck.week04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naibeck.week04.databinding.ItemSandwichBinding

class SandwichAdapter constructor(
    private val sandwiches: List<Sandwich>,
    private val sandwichListener: OnSandwichClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sandwich, parent, false)
        return SandwichViewHolder(view)
    }

    override fun getItemCount(): Int = sandwiches.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SandwichViewHolder).bind(sandwiches[position])
    }

    inner class SandwichViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(sandwich: Sandwich) {
            val binding = DataBindingUtil.bind<ItemSandwichBinding>(itemView)
            binding?.name?.text = sandwich.name
            binding?.price?.text = sandwich.getDisplayPrice()
            itemView.setOnClickListener {
                sandwichListener.onClick(sandwich)
            }
            Glide.with(itemView.context)
                .load(sandwich.image)
                .into(binding?.image!!)
        }
    }
}

interface OnSandwichClickListener {
    fun onClick(sandwich: Sandwich)
}