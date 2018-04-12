package com.chetdeva.spinnerbindings.cart

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.chetdeva.spinnerbindings.R
import com.chetdeva.spinnerbindings.databinding.ActivityCartBinding
import com.chetdeva.spinnerbindings.dto.CartItem

class CartActivity : AppCompatActivity(), CartContract.View {

    private lateinit var binding: ActivityCartBinding

    private val defaultCartItem: CartItem by lazy {
        val name = getString(R.string.android_figurine)
        val description = getString(R.string.android_figurine_description)
        val image = ContextCompat.getDrawable(this, R.drawable.android_figurine)
        val price = 16.0
        CartItem(name, description, image, price, MIN_CART_ITEM_QUANTITY, MAX_CART_ITEM_QUANTITY)
    }

    private val presenter: CartContract.Presenter by lazy {
        CartPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        supportActionBar?.setTitle(R.string.cart_title)

        binding.presenter = presenter
        binding.model = buildModel(defaultCartItem)
    }

    private fun buildModel(cartItem: CartItem): CartItemViewModel {
        return CartItemViewModel(cartItem)
    }

    override fun showUpdatedCart(cartItem: CartItem) {
        binding.model?.update(cartItem)
    }

    override fun showMaxQuantityError() {
        val itemMaxQuantityError = getString(R.string.item_max_quantity_error, MAX_CART_ITEM_QUANTITY)
        Snackbar.make(binding.addToCartFab, itemMaxQuantityError, Snackbar.LENGTH_SHORT).show()
    }
}
