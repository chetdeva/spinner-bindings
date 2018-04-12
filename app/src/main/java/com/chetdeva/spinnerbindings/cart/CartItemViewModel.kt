package com.chetdeva.spinnerbindings.cart

import android.databinding.ObservableField
import android.graphics.drawable.Drawable
import com.chetdeva.spinnerbindings.dto.CartItem
import com.chetdeva.spinnerbindings.extensions.populateList

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
class CartItemViewModel(var cartItem: CartItem,
                        val name: ObservableField<String> = ObservableField(cartItem.name),
                        val description: ObservableField<String> = ObservableField(cartItem.description),
                        val image: ObservableField<Drawable> = ObservableField(cartItem.image),
                        val price: ObservableField<Double> = ObservableField(cartItem.quantifiedPrice),
                        val quantity: ObservableField<Int> = ObservableField(cartItem.quantity),
                        val quantityEntries: ObservableField<List<Int>> = ObservableField(cartItem.maxQuantity.populateList())) {

    fun update(cartItem: CartItem) {
        this.cartItem = cartItem
        name.set(cartItem.name)
        description.set(cartItem.description)
        image.set(cartItem.image)
        price.set(cartItem.quantifiedPrice)
        quantity.set(cartItem.quantity)
        quantityEntries.set(cartItem.maxQuantity.populateList())
    }
}