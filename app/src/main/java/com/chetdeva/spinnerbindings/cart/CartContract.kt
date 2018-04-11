package com.chetdeva.spinnerbindings.cart

import com.chetdeva.spinnerbindings.dto.CartItem

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
interface CartContract {

    interface View {
        fun showUpdatedCart(cartItem: CartItem)
        fun showMaxQuantityError()
        fun updateItemQuantity(newQuantity: Int)
    }

    interface Presenter {
        fun onItemQuantityChange(cartItem: CartItem, newQuantity: Int)
        fun onAddToCartClick(cartItem: CartItem)
    }
}