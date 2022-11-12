package com.vitorhr.gorestaurant.ui.list

import android.view.View
import com.vitorhr.gorestaurant.ui.MainViewModel

class ListViewModel:MainViewModel() {
    init {
        _bottomBarVisibility.value = View.VISIBLE
    }

    fun init(){

        _bottomBarVisibility.value = View.VISIBLE
    }
}