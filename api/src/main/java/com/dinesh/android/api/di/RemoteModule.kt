package com.dinesh.android.api.di

import com.dinesh.android.api.categories.mapper.DomainMapper
import com.dinesh.android.api.categories.remote.CategoriesRemote
import com.dinesh.android.api.categories.remote.CategoriesRemoteSource
import com.dinesh.android.api.categories.repository.CategoriesRepositoryImpl
import com.dinesh.android.data.repository.CategoriesRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val remoteModule = module {

    single { get<Retrofit>().create(CategoriesRemoteSource::class.java) }

    factory { CategoriesRemote(get()) }

    factory { DomainMapper() }

    factory<CategoriesRepository> { CategoriesRepositoryImpl(get(), get()) }

}