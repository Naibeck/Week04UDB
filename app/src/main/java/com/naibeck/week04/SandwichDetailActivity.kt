package com.naibeck.week04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.naibeck.week04.databinding.ActivitySandwichDetailBinding

class SandwichDetailActivity : AppCompatActivity() {

    private var binding: ActivitySandwichDetailBinding? = null
    private var productQuantity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivitySandwichDetailBinding>(this, R.layout.activity_sandwich_detail)
        parseReceivedSandwich()?.let {
            loadSandwichData(it)
            setViewListeners()
            displayAddToCart()
        }
    }

    private fun setViewListeners() {
        binding?.plusButton?.setOnClickListener {
            increaseProduct()
        }
        binding?.minusButton?.setOnClickListener {
            reduceProduct()
        }
        binding?.addButton?.setOnClickListener {
            Toast.makeText(this, "It will add $productQuantity sandwiches", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadSandwichData(it: Sandwich) {
        binding?.sandwichScore?.text = it.rating.toString()
        binding?.sandwichPrice?.text = it.getDisplayPrice()
        binding?.sandwichDescription?.text = it.description
        binding?.sandwichImage?.setImageDrawable(ContextCompat.getDrawable(this, it.drawable))
        binding?.productQuantity?.text = productQuantity.toString()
    }

    private fun increaseProduct() {
        productQuantity += 1
        binding?.productQuantity?.text = productQuantity.toString()
        displayAddToCart()
    }

    private fun reduceProduct() {
        if (productQuantity > 0) {
            productQuantity -= 1
            binding?.productQuantity?.text = productQuantity.toString()
        }
        displayAddToCart()
    }

    private fun displayAddToCart() {
        binding?.addButton?.visibility = if (productQuantity == 0) View.GONE else View.VISIBLE
        binding?.addButton?.text = getString(R.string.add_to_cart_action, productQuantity)
    }

    private fun parseReceivedSandwich(): Sandwich? = intent.getParcelableExtra(SANDWICH_KEY)

    companion object {
        const val SANDWICH_KEY = "sandwich.key"
    }
}