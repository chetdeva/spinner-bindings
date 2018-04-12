package com.chetdeva.spinnerbindings.invcart

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.chetdeva.spinnerbindings.R
import com.chetdeva.spinnerbindings.cart.CartItemViewModel
import com.chetdeva.spinnerbindings.databinding.ActivityInvCartBinding
import com.chetdeva.spinnerbindings.dto.CartItem
import com.chetdeva.spinnerbindings.extensions.get

class InvCartActivity : AppCompatActivity(), InvCartContract.View {

    private lateinit var binding: ActivityInvCartBinding

    private val defaultCartItem: CartItem by lazy {
        val name = getString(R.string.android_figurine)
        val description = getString(R.string.android_figurine_description)
        val image = ContextCompat.getDrawable(this, R.drawable.android_figurine)
        val price = 16.0
        CartItem(name, description, image, price, MIN_CART_ITEM_QUANTITY, MAX_CART_ITEM_QUANTITY)
    }

    private val presenter: InvCartContract.Presenter by lazy {
        InvCartPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inv_cart)
        supportActionBar?.setTitle(R.string.inv_cart_title)

        binding.presenter = presenter
        binding.model = buildModel()
    }

    private fun buildModel(): CartItemViewModel {
        return CartItemViewModel(defaultCartItem)
                .apply {
                    quantity.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                        override fun onPropertyChanged(p0: Observable, p1: Int) {
                            presenter.onItemQuantityChange(cartItem, p0.get())
                        }
                    })
                }
    }

    override fun updateItem(cartItem: CartItem) {
        binding.model?.update(cartItem)
    }

    override fun updateItemQuantity(newQuantity: Int) {
        binding.model?.quantity?.set(newQuantity)
    }

    override fun showMaxQuantityError() {
        val itemMaxQuantityError = getString(R.string.item_max_quantity_error, MAX_CART_ITEM_QUANTITY)
        Snackbar.make(binding.addToCartFab, itemMaxQuantityError, Snackbar.LENGTH_SHORT).show()
    }
}
