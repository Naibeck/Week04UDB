package com.naibeck.week04.cart

class Cart {
    private val _sandwiches: MutableList<CartItem> = mutableListOf()
    val products: List<CartItem> = _sandwiches

    fun addProduct(item: CartItem) {
        _sandwiches.add(item)
    }

    fun calculateTotal(): Double = products.sumByDouble { it.quantity * it.sandwich.price }
}