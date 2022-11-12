package com.vitorhr.gorestaurant.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MainViewModel : ViewModel() {
    val _bottomBarVisibility = MutableLiveData<Int>(View.VISIBLE)
    val bottomBarVisibility: LiveData<Int>
        get() = _bottomBarVisibility
}