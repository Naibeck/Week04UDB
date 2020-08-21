package com.naibeck.week04

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.naibeck.week04.SandwichDetailActivity.Companion.SANDWICH_ADD_REQUEST
import com.naibeck.week04.SandwichDetailActivity.Companion.SANDWICH_KEY
import com.naibeck.week04.cart.Cart
import com.naibeck.week04.cart.CartItem
import com.naibeck.week04.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private val avocadoGrilledCheese = Sandwich("Avocado Grilled Cheese", 15.00, 4.3, "Grilled Cheese Sandwich", R.drawable.sandwich_avocado_grilled_cheese)
    private val phillyCheese = Sandwich("Phylly Cheese", 25.00, 4.9, "Recommended of the house", R.drawable.sandwich_phylly_cheese)
    private val sampler = Sandwich("Sampler", 10.00, 4.2, "6 sandwiches from multiple ingredients", R.drawable.sandwich_sampler)

    private val cart: Cart = Cart()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadSandwichData()
        loadPayButton()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("RequestCode: $requestCode - ResultCode: $resultCode")
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                SANDWICH_ADD_REQUEST -> addItemToCart(data?.getParcelableExtra(CART_ITEM_KEY))
            }
        }
    }

    private fun addItemToCart(cartItem: CartItem?) {
        cartItem?.let {
            cart.addProduct(it)
        }
        loadPayButton()
    }

    private fun loadPayButton() {
        binding?.payButton?.visibility = if (cart.products.isNotEmpty()) View.VISIBLE else View.GONE
        if (cart.products.isNotEmpty()) {
            binding?.payButton?.text = getString(R.string.pay_total, cart.calculateTotal())
        }
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
            launchSandwichIntent(avocadoGrilledCheese)
        }
        binding?.secondSandwich?.setOnClickListener {
            launchSandwichIntent(phillyCheese)
        }
        binding?.thirdSandwich?.setOnClickListener {
            launchSandwichIntent(sampler)
        }
    }

    private fun launchSandwichIntent(sandwich: Sandwich) {
        val intent = Intent(this, SandwichDetailActivity::class.java)
        intent.putExtra(SANDWICH_KEY, sandwich)
        startActivityForResult(intent, SANDWICH_ADD_REQUEST)
    }

    companion object {
        const val CART_ITEM_KEY = "cart.item.key"
    }
}