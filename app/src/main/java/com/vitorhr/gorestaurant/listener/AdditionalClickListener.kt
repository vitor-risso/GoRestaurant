package com.vitorhr.gorestaurant.listener

class AdditionalClickListener {
    val clickListener: (priceInCents: Int) -> Unit

    constructor(_clickListener: (priceInCents: Int) -> Unit) {//constructor of class
        clickListener = _clickListener
    }

    fun onClick(priceInCents: Int) {
        clickListener(priceInCents)
    }
}
