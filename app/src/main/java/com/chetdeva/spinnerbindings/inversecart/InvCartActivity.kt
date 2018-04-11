package com.chetdeva.spinnerbindings.inversecart

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.chetdeva.spinnerbindings.R
import com.chetdeva.spinnerbindings.cart.CartContract
import com.chetdeva.spinnerbindings.cart.CartItemViewModel
import com.chetdeva.spinnerbindings.cart.MAX_CART_ITEM_QUANTITY
import com.chetdeva.spinnerbindings.cart.MIN_CART_ITEM_QUANTITY
import com.chetdeva.spinnerbindings.databinding.ActivityInvCartBinding
import com.chetdeva.spinnerbindings.dto.CartItem

class InvCartActivity : AppCompatActivity(), CartContract.View {

    private lateinit var binding: ActivityInvCartBinding

    private val defaultCartItem: CartItem by lazy {
        val name = getString(R.string.android_figurine)
        val description = getString(R.string.android_figurine_description)
        val price = 16.0
        CartItem(name, description, price, MAX_CART_ITEM_QUANTITY, MIN_CART_ITEM_QUANTITY)
    }

    private val presenter: CartContract.Presenter by lazy {
        InvCartPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inv_cart)

        binding.presenter = presenter
        binding.model = buildModel()
    }

    private fun buildModel(): CartItemViewModel {
        return CartItemViewModel(defaultCartItem)
                .apply {
                    itemQuantity.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                        override fun onPropertyChanged(p0: Observable?, p1: Int) {
                            presenter.onItemQuantityChange(cartItem, itemQuantity.get())
                        }
                    })
                }
    }

    override fun showUpdatedCart(cartItem: CartItem) {
        binding.model?.update(cartItem)
    }

    override fun updateItemQuantity(newQuantity: Int) {
        binding.model?.itemQuantity?.set(newQuantity)
    }

    override fun showMaxQuantityError() {
        val itemMaxQuantityError = getString(R.string.item_max_quantity_error, MAX_CART_ITEM_QUANTITY)
        Snackbar.make(binding.addToCartFab, itemMaxQuantityError, Snackbar.LENGTH_SHORT).show()
    }
}
