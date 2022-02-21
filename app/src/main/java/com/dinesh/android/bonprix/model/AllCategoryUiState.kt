package com.dinesh.android.bonprix.model

import com.dinesh.android.data.models.DomainModel

data class AllCategoryUiState(
    val isLoading: Boolean = false,
    val categories: List<DomainModel.TopCategory> = emptyList(),
)