package com.chetdeva.spinnerbindings.cart

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.chetdeva.spinnerbindings.R
import com.chetdeva.spinnerbindings.databinding.ActivityCartBinding
import com.chetdeva.spinnerbindings.dto.CartItem

class CartActivity : AppCompatActivity(), CartContract.View {

    private lateinit var binding: ActivityCartBinding

    private val defaultCartItem: CartItem by lazy {
        val name = getString(R.string.android_figurine)
        val description = getString(R.string.android_figurine_description)
        val price = 16.0
        CartItem(name, description, price, MAX_CART_ITEM_QUANTITY, MIN_CART_ITEM_QUANTITY)
    }

    private val presenter: CartContract.Presenter by lazy {
        CartPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)

        binding.presenter = presenter
        binding.model = buildModel(defaultCartItem)
    }

    private fun buildModel(cartItem: CartItem): CartItemViewModel {
        return CartItemViewModel(cartItem)
    }

    override fun showUpdatedCart(cartItem: CartItem) {
        binding.model?.update(cartItem)
    }

    override fun updateItemQuantity(newQuantity: Int) {

    }

    override fun showMaxQuantityError() {
        val itemMaxQuantityError = getString(R.string.item_max_quantity_error, MAX_CART_ITEM_QUANTITY)
        Snackbar.make(binding.addToCartFab, itemMaxQuantityError, Snackbar.LENGTH_SHORT).show()
    }
}
