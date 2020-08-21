package com.naibeck.week04

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class Sandwich(
    val name: String,
    private val price: Double,
    val rating: Double,
    val description: String,
    @DrawableRes val drawable: Int
) : Parcelable {
    fun getDisplayPrice() = "$$price"

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readDouble(),
        source.readDouble(),
        source.readString()!!,
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeDouble(price)
        writeDouble(rating)
        writeString(description)
        writeInt(drawable)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Sandwich> = object : Parcelable.Creator<Sandwich> {
            override fun createFromParcel(source: Parcel): Sandwich = Sandwich(source)
            override fun newArray(size: Int): Array<Sandwich?> = arrayOfNulls(size)
        }
    }
}