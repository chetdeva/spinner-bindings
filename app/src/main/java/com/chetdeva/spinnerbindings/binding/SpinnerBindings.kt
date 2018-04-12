package com.chetdeva.spinnerbindings.binding

import android.databinding.BindingAdapter
import android.widget.Spinner
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.ItemSelectedListener
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.setSpinnerEntries
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.setSpinnerItemSelectedListener
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.setSpinnerValue

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
class SpinnerBindings {

    @BindingAdapter("entries")
    fun Spinner.setEntries(entries: List<Any>?) {
        setSpinnerEntries(entries)
    }

    @BindingAdapter("onItemSelected")
    fun Spinner.setOnItemSelectedListener(itemSelectedListener: ItemSelectedListener?) {
        setSpinnerItemSelectedListener(itemSelectedListener)
    }

    @BindingAdapter("newValue")
    fun Spinner.setNewValue(newValue: Any?) {
        setSpinnerValue(newValue)
    }
}