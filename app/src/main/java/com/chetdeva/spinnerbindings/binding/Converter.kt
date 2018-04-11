package com.chetdeva.spinnerbindings.binding

import android.databinding.InverseBindingAdapter
import android.widget.Spinner

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
object Converter {

    @JvmStatic
    fun toInt(any: Any): Int {
        return any as Int
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    fun Spinner.captureSelectedValue(): Int {
        return selectedItem as Int
    }
}