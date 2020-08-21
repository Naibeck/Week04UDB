package com.naibeck.week04

data class Sandwich(
    val name: String,
    private val price: Double
) {
    fun getDisplayPrice() = "$$price"
}