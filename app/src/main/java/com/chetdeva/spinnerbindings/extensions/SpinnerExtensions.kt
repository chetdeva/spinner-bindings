package com.chetdeva.spinnerbindings.extensions

import android.databinding.InverseBindingListener
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 10/04/18
 */
object SpinnerExtensions {

    /**
     * sets spinner entries
     */
    fun Spinner.setSpinnerEntries(entries: List<Any>?) {
        if (entries != null) {
            val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, entries)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            adapter = arrayAdapter
        }
    }

    /**
     * sets spinner onItemSelectedListener listener
     */
    fun Spinner.setSpinnerItemSelectedListener(listener: ItemSelectedListener?) {
        if (listener == null) {
            onItemSelectedListener = null
        } else {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    if (tag != position) {
                        listener.onItemSelected(parent.getItemAtPosition(position))
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
    }

    /**
     * sets spinner onItemSelectedListener listener
     */
    fun Spinner.setSpinnerInverseBindingListener(listener: InverseBindingListener?) {
        if (listener == null) {
            onItemSelectedListener = null
        } else {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    if (tag != position) {
                        listener.onChange()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
    }

    /**
     * set spinner value
     */
    fun Spinner.setSpinnerValue(value: Any?) {
        if (adapter != null ) {
            val position = (adapter as ArrayAdapter<Any>).getPosition(value)
            setSelection(position, false)
            tag = position
        }
    }

    /**
     * get spinner value
     */
    fun Spinner.getSpinnerValue(): Any? {
        return selectedItem
    }

    interface ItemSelectedListener {
        fun onItemSelected(item: Any)
    }
}