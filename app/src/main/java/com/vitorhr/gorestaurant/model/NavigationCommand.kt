package com.vitorhr.gorestaurant.model

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class navigateTo(val navigate: NavDirections) : NavigationCommand()
    object navigateBack : NavigationCommand()
}
