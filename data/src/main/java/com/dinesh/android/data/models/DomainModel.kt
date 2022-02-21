package com.dinesh.android.data.models

class DomainModel {

    data class TopCategory(
        val label: String = "",
        val url: String? = null,
        val imageUrl: String? = null,
        val innerCategories: List<InnerCategory>? = null,
    )

    interface InnerCategory {
        val label: String
        val webUrl: String
    }

    data class ListCategory(
        override val label: String,
        override val webUrl: String,
        val children: List<InnerCategory>,
    ) : InnerCategory

    data class WebCategory(
        override val label: String,
        override val webUrl: String,
    ) : InnerCategory
}