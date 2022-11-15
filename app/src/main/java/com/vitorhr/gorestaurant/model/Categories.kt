package com.vitorhr.gorestaurant.model

data class Categories(
    val icon: Int,
    val title: String,
    val onClick: (() -> Unit)? = null,
)
