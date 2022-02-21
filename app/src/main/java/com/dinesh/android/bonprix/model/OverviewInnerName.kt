package com.dinesh.android.bonprix.model

data class OverviewInnerName(
    val name: String,
    val imageUrl: String,
)

data class CategoryInnerName(
    val name: String,
    val webUrl: String,
    val showChevron: Boolean,
)
