package com.dinesh.android.bonprix

import android.app.Application
import com.dinesh.android.api.di.networkModule
import com.dinesh.android.api.di.remoteModule
import com.dinesh.android.bonprix.di.bonPrixDataModule
import com.dinesh.android.bonprix.di.categoriesOverviewModule
import com.dinesh.android.bonprix.di.categoryModule
import com.dinesh.android.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BonPrixApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BonPrixApplication)
            androidLogger()
            modules(
                networkModule,
                remoteModule,
                domainModule,
                bonPrixDataModule,
                categoriesOverviewModule,
                categoryModule,
            )
        }
    }
}