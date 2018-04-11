package com.chetdeva.spinnerbindings.cart

import com.chetdeva.spinnerbindings.dto.CartItem

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */

const val MAX_CART_ITEM_QUANTITY = 9
const val MIN_CART_ITEM_QUANTITY = 1

class CartPresenterImpl(val view: CartContract.View) : CartContract.Presenter {

    override fun onItemQuantityChange(cartItem: CartItem, newQuantity: Int) {
        updateCart(cartItem, newQuantity)
    }

    private fun updateCart(cartItem: CartItem, newQuantity: Int) {
        val updatedCartItem = cartItem.copy(quantity = newQuantity)
        view.showUpdatedCart(updatedCartItem)
    }

    override fun onAddToCartClick(cartItem: CartItem) {
        val newQuantity = cartItem.quantity + 1
        if (newQuantity <= MAX_CART_ITEM_QUANTITY) {
            updateCart(cartItem, newQuantity)
        } else {
            view.showMaxQuantityError()
        }
    }
}