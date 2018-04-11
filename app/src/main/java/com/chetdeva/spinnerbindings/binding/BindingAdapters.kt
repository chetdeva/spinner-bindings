package com.chetdeva.spinnerbindings.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 08/03/18
 */
object BindingAdapters {

//    @JvmStatic
//    @BindingAdapter(value = ["selectedValue", "selectedValueAttrChanged"], requireAll = false)
//    fun bindSpinnerData(spinner: Spinner, newSelectedValue: String?, newTextAttrChanged: InverseBindingListener) {
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//                newTextAttrChanged.onChange()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {}
//        }
//        if (newSelectedValue != null) {
//            val pos = (spinner.adapter as ArrayAdapter<String>).getPosition(newSelectedValue)
//            spinner.setSelection(pos, false)
//        }
//    }
//
//    @JvmStatic
//    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
//    fun captureSelectedValue(spinner: Spinner): String {
//        return spinner.selectedItem as String
//    }
}