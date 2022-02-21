package com.dinesh.android.bonprix.model.category

import com.dinesh.android.bonprix.model.CategoryInnerName

data class CategoryUiState(
    val isLoading: Boolean,
    val title: String,
    val innerCategory: List<CategoryInnerName>?,
)
