package com.naibeck.week04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.naibeck.week04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadSandwichData()
    }

    private fun loadSandwichData() {
        val avocadoGrilledCheese = Sandwich("Avocado Grilled Cheese", 15.00)
        val phyllyCheese = Sandwich("Phylly Cheese", 25.00)
        val sampler = Sandwich("Sampler", 10.00)

        binding?.firstName?.text = avocadoGrilledCheese.name
        binding?.firstPrice?.text = avocadoGrilledCheese.getDisplayPrice()
        binding?.secondName?.text = phyllyCheese.name
        binding?.secondPrice?.text = phyllyCheese.getDisplayPrice()
        binding?.thirdName?.text = sampler.name
        binding?.thirdPrice?.text = sampler.getDisplayPrice()
    }
}