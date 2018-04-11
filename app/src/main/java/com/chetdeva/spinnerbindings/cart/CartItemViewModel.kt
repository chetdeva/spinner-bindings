package com.chetdeva.spinnerbindings.cart

import android.databinding.ObservableField
import com.chetdeva.spinnerbindings.dto.CartItem
import com.chetdeva.spinnerbindings.extensions.populateList
import java.text.NumberFormat

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
class CartItemViewModel(var cartItem: CartItem,
                        val itemName: ObservableField<String> = ObservableField(cartItem.name),
                        val itemDescription: ObservableField<String> = ObservableField(cartItem.description),
                        val itemPrice: ObservableField<Double> = ObservableField(cartItem.quantifiedPrice),
                        val itemQuantity: ObservableField<Int> = ObservableField(cartItem.quantity),
                        val itemQuantityEntries: ObservableField<List<Int>> = ObservableField(cartItem.maxQuantity.populateList())) {

    fun update(cartItem: CartItem) {
        this.cartItem = cartItem
        itemName.set(cartItem.name)
        itemDescription.set(cartItem.description)
        itemPrice.set(cartItem.quantifiedPrice)
        itemQuantity.set(cartItem.quantity)
        itemQuantityEntries.set(cartItem.maxQuantity.populateList())
    }
}