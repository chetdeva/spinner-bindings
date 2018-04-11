package com.chetdeva.spinnerbindings.extensions

import android.databinding.Observable
import android.databinding.ObservableField

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 05/04/18
 */

inline fun <reified T> Observable.get(): T = (this as ObservableField<T>).get()
