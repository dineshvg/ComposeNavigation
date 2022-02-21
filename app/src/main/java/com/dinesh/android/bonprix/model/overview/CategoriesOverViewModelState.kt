package com.dinesh.android.bonprix.model.overview

import com.dinesh.android.bonprix.model.OverviewInnerName
import com.dinesh.android.data.models.DomainModel

internal data class CategoriesOverViewModelState(
    val categories: List<DomainModel.TopCategory> = emptyList(),
    val isLoading: Boolean = false,
    val title: String = "",
    val link: String = "",
) {
    fun toUiState(): OverviewUiState =
        if (categories.isEmpty()) {
            OverviewUiState(
                isLoading = isLoading,
                title = title,
                link = link,
                innerNames = emptyList(),
            )
        } else {
            OverviewUiState(
                isLoading = isLoading,
                title = categories
                    .first { it.innerCategories == null }.label,
                link = categories
                    .first { it.innerCategories == null }.url ?: "",
                innerNames = categories
                    .filter { it.innerCategories != null }
                    .map {
                        OverviewInnerName(
                            name = it.label,
                            imageUrl = it.imageUrl ?: ""
                        )
                    },
            )
        }
}
