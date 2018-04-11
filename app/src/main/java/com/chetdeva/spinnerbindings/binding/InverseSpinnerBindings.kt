package com.chetdeva.spinnerbindings.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.widget.Spinner
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.getSpinnerValue
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.setSpinnerInverseBindingListener
import com.chetdeva.spinnerbindings.extensions.SpinnerExtensions.setSpinnerValue

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 10/04/18
 */
class InverseSpinnerBindings {

    @BindingAdapter("selectedValue")
    fun Spinner.setSelectedValue(selectedValue: Any?) {
        setSpinnerValue(selectedValue)
    }

    @BindingAdapter("selectedValueAttrChanged")
    fun Spinner.setSelectedValueAttrChanged(inverseBindingListener: InverseBindingListener?) {
        setSpinnerInverseBindingListener(inverseBindingListener)
    }

    companion object InverseSpinnerBindings {

        @JvmStatic
        @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
        fun Spinner.getSelectedValue(): Any? {
            return getSpinnerValue()
        }
    }
}