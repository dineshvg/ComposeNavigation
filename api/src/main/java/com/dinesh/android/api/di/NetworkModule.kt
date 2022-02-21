package com.dinesh.android.api.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL_NAME = "BASE_URL"
private const val BASE_URL = "https://codechallenge.mobilelab.io/"

val networkModule = module {

    single(named(BASE_URL_NAME)) { BASE_URL }

    single { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }

    single { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }

    single { OkHttpClient().newBuilder()
        .addInterceptor(get<HttpLoggingInterceptor>())
        .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named(BASE_URL_NAME)))
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }
}