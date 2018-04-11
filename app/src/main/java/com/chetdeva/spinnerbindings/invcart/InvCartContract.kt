package com.chetdeva.spinnerbindings.invcart

import com.chetdeva.spinnerbindings.dto.CartItem

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
interface InvCartContract {

    interface View {
        fun updateItem(cartItem: CartItem)
        fun updateItemQuantity(newQuantity: Int)
        fun showMaxQuantityError()
    }

    interface Presenter {
        fun onItemQuantityChange(cartItem: CartItem, newQuantity: Int)
        fun onAddToCartClick(cartItem: CartItem)
    }
}