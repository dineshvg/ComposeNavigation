package com.dinesh.android.bonprix.model

import com.dinesh.android.data.models.DomainModel

data class AllCategoryDataViewModelState(
    val categories: List<DomainModel.TopCategory>
) {
    fun toUiState() :AllCategoryUiState  =
        AllCategoryUiState(
            isLoading = categories.isEmpty(),
            categories = categories
        )
}
