package com.chetdeva.spinnerbindings.dto

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
data class CartItem(val name: String, val description: String, val price: Double, val quantity: Int, val maxQuantity: Int) {
    val quantifiedPrice: Double
        get() = price * quantity
}