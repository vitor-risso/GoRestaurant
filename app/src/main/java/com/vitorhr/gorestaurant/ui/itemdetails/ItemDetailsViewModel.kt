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
    private val price = dish.priceInCents

    private val _totalOrders = MutableLiveData("1")
    val totalOrders: LiveData<String> get() = _totalOrders

    private val _favoriteItem = MutableLiveData(R.drawable.favorite_icon_empty)
    val favoriteItem: LiveData<Int> get() = _favoriteItem

    private var totalPrice = MutableLiveData(dish.priceInCents)

    private val formatter = DecimalFormat("##,##")

    private val _totalPriceString = MutableLiveData(formatter.format(totalPrice.value))
    val totalPriceString: LiveData<String> get() = _totalPriceString

    fun decrementClick() {
        if (totalOrders.value?.toString()?.toInt() == 1) return
        _totalOrders.value = (totalOrders.value?.toInt()?.minus(1)).toString()
        totalPrice.value = totalPrice.value!! / 2
        updateTotalPriceString()
    }

    fun incrementClick() {
        _totalOrders.value = (totalOrders.value?.toInt()?.plus(1)).toString()
        totalPrice.value = (totalPrice.value!! * totalOrders.value!!.toInt())
        updateTotalPriceString()
    }

    fun confirmOrderClick() {

    }

    fun incrementToTotalPrice(priceInCents: Int) {
        totalPrice.value = totalPrice.value?.plus((priceInCents ))
        updateTotalPriceString()
    }

    fun decrementFromTotalPrice(priceInCents: Int) {
        totalPrice.value = totalPrice.value?.minus((priceInCents))
        updateTotalPriceString()
    }

    fun updateTotalPriceString() {
        _totalPriceString.value = formatter.format(totalPrice.value)
    }
}