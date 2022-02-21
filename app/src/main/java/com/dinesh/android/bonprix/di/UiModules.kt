package com.dinesh.android.bonprix.di

import com.dinesh.android.bonprix.category.presentation.CategoryViewModel
import com.dinesh.android.bonprix.overview.presentation.CategoriesOverviewViewModel
import com.dinesh.android.bonprix.presentation.BonPrixViewModel
import org.koin.dsl.module

val bonPrixDataModule = module {

    factory {
        BonPrixViewModel(get())
    }
}
val categoriesOverviewModule = module {

    factory {
        CategoriesOverviewViewModel()
    }
}

val categoryModule = module {

    factory {
        CategoryViewModel()
    }
}