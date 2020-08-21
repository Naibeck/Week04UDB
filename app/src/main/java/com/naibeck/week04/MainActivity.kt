package com.naibeck.week04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.naibeck.week04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private val avocadoGrilledCheese = Sandwich("Avocado Grilled Cheese", 15.00)
    private val phillyCheese = Sandwich("Phylly Cheese", 25.00)
    private val sampler = Sandwich("Sampler", 10.00)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadSandwichData()
    }

    private fun loadSandwichData() {
        binding?.firstName?.text = avocadoGrilledCheese.name
        binding?.firstPrice?.text = avocadoGrilledCheese.getDisplayPrice()
        binding?.secondName?.text = phillyCheese.name
        binding?.secondPrice?.text = phillyCheese.getDisplayPrice()
        binding?.thirdName?.text = sampler.name
        binding?.thirdPrice?.text = sampler.getDisplayPrice()

        setClickableSandwiches()
    }

    private fun setClickableSandwiches() {
        binding?.firstSandwich?.setOnClickListener {
            startActivity(Intent(this, SandwichDetailActivity::class.java))
        }
        binding?.secondSandwich?.setOnClickListener {
            startActivity(Intent(this, SandwichDetailActivity::class.java))
        }
        binding?.thirdSandwich?.setOnClickListener {
            startActivity(Intent(this, SandwichDetailActivity::class.java))
        }
    }
}