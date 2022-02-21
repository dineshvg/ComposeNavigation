package com.dinesh.android.bonprix.model.category

import com.dinesh.android.bonprix.model.CategoryInnerName
import com.dinesh.android.data.models.DomainModel

internal data class CategoryViewModelState(
    val items: List<DomainModel.InnerCategory> = emptyList(),
    val isLoading: Boolean = false,
    val title: String = "",
    val innerCategories: List<CategoryInnerName>? = emptyList(),
)  {
    fun toUiState() : CategoryUiState =
        if(items.isEmpty()) {
            CategoryUiState(
                isLoading = isLoading,
                title = title,
                innerCategory = innerCategories,
            )
        } else {
            CategoryUiState(
                isLoading = isLoading,
                title = title,
                innerCategory = items
                    .map { innerCategory ->
                        if(innerCategory is DomainModel.ListCategory) {
                            CategoryInnerName(
                                name = innerCategory.label,
                                webUrl = innerCategory.webUrl,
                                showChevron = true,
                            )
                        } else {
                            CategoryInnerName(
                                name = innerCategory.label,
                                webUrl = innerCategory.webUrl,
                                showChevron = false,
                            )
                        }

                    },
            )
        }
}
