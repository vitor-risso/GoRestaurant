package com.vitorhr.gorestaurant.di

import com.vitorhr.gorestaurant.ui.MainViewModel
import com.vitorhr.gorestaurant.ui.list.ListViewModel
import com.vitorhr.gorestaurant.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { ListViewModel() }
}