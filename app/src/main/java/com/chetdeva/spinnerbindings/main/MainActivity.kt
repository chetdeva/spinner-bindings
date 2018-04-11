package com.chetdeva.spinnerbindings.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chetdeva.spinnerbindings.R
import com.chetdeva.spinnerbindings.cart.CartActivity
import com.chetdeva.spinnerbindings.databinding.ActivityMainBinding
import com.chetdeva.spinnerbindings.inversecart.InvCartActivity

class MainActivity : AppCompatActivity(), MainHandler {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this
    }

    override fun onCartClicked() {
        startActivity(Intent(this, CartActivity::class.java))
    }

    override fun onInverseCartClicked() {
        startActivity(Intent(this, InvCartActivity::class.java))
    }
}