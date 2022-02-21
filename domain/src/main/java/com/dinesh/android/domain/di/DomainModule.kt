package com.dinesh.android.domain.di

import com.dinesh.android.domain.categories.usecases.GetAllDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { GetAllDataUseCase(get()) }
}