package com.vitorhr.gorestaurant.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.vitorhr.gorestaurant.model.NavigationCommand
import com.vitorhr.gorestaurant.ui.MainViewModel

class LoginViewModel : MainViewModel() {

    private val _loadingVisibility = MutableLiveData(View.GONE)
    val loadingVisibility: LiveData<Int>
        get() = _loadingVisibility

    private val  _navigate = MutableLiveData<Boolean>(false)
    val navigate
    get() = _navigate

    fun loginButtonClick() {
        navigate.value = true
    }

}