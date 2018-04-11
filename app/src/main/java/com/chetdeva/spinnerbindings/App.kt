package com.chetdeva.spinnerbindings

import android.app.Application
import android.databinding.DataBindingUtil
import com.chetdeva.spinnerbindings.binding.BindingComponent

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        DataBindingUtil.setDefaultComponent(BindingComponent())
    }
}