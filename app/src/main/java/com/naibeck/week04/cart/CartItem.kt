package com.naibeck.week04.cart

import android.os.Parcel
import android.os.Parcelable
import com.naibeck.week04.Sandwich

data class CartItem(
    val sandwich: Sandwich,
    val quantity: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readParcelable<Sandwich>(Sandwich::class.java.classLoader)!!,
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(sandwich, 0)
        writeInt(quantity)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CartItem> = object : Parcelable.Creator<CartItem> {
            override fun createFromParcel(source: Parcel): CartItem = CartItem(source)
            override fun newArray(size: Int): Array<CartItem?> = arrayOfNulls(size)
        }
    }
}
