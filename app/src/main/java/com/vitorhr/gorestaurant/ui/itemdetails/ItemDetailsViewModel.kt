package com.vitorhr.gorestaurant.ui.itemdetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitorhr.gorestaurant.R
import com.vitorhr.gorestaurant.model.Dish
import java.text.DecimalFormat

class ItemDetailsViewModel(val application: Context, private val dish: Dish) : ViewModel() {

    val title = dish.title
    val description = dish.description
    val price = dish.priceInCents

    private val _totalOrders = MutableLiveData("1")
    val totalOrders: LiveData<String> get() = _totalOrders

    private val _favoriteItem = MutableLiveData(R.drawable.favorite_icon_empty)
    val favoriteItem: LiveData<Int> get() = _favoriteItem

    var totalPrice = MutableLiveData(dish.priceInCents)

    private val _totalPriceString = MutableLiveData("${totalPrice.value}")
    val totalPriceString: LiveData<String> get() = _totalPriceString

    private val formatter = DecimalFormat("##,##")

    fun decrementClick() {
        if (totalOrders.value?.toString()?.toInt() == 1) return
        _totalOrders.value = (totalOrders.value?.toInt()?.minus(1)).toString()
        totalPrice.value = totalPrice.value!! - price
        _totalPriceString.value = formatter.format(totalPrice.value)
    }

    fun incrementClick() {
        _totalOrders.value = (totalOrders.value?.toInt()?.plus(1)).toString()
        totalPrice.value = (price * totalOrders.value!!.toInt())
        _totalPriceString.value = formatter.format(totalPrice.value)
    }

    fun confirmOrderClick() {

    }
}