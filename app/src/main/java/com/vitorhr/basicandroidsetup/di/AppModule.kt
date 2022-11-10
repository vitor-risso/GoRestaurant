package com.vitorhr.basicandroidsetup.di

import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    // Retrofit instance
    single { Retrofit.Builder().baseUrl(BASE_URL).build() }
    // Create instance of the service
//    single { get<Retrofit>().create() }
}

val BASE_URL = ""