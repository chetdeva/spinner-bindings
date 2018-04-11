package com.chetdeva.spinnerbindings.invcart

import com.chetdeva.spinnerbindings.dto.CartItem

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */

const val MAX_CART_ITEM_QUANTITY = 9
const val MIN_CART_ITEM_QUANTITY = 1

class InvCartPresenterImpl(val view: InvCartContract.View) : InvCartContract.Presenter {

    override fun onItemQuantityChange(cartItem: CartItem, newQuantity: Int) {
        view.updateItem(cartItem.copy(quantity = newQuantity))
    }

    override fun onAddToCartClick(cartItem: CartItem) {
        val newQuantity = cartItem.quantity + 1
        if (newQuantity <= MAX_CART_ITEM_QUANTITY) {
            view.updateItemQuantity(newQuantity)
        } else {
            view.showMaxQuantityError()
        }
    }
}