package com.dinesh.android.api.categories.mapper

import com.dinesh.android.data.models.DomainModel.InnerCategory
import com.dinesh.android.data.models.DomainModel.ListCategory
import com.dinesh.android.data.models.DomainModel.TopCategory
import com.dinesh.android.data.models.DomainModel.WebCategory
import com.dinesh.android.data.models.RemoteCategory
import com.dinesh.android.data.models.RemoteInnerCategory

class DomainMapper {

    fun mapToDomain(from: RemoteCategory): TopCategory =
        TopCategory(
            label = from.label,
            url = from.url,
            imageUrl = from.imageUrl,
            innerCategories = from.children?.map(this::mapInnerCategory)
        )

    private fun mapInnerCategory(from: RemoteInnerCategory): InnerCategory =
        when (from.children == null) {
            true -> WebCategory(
                label = from.label,
                webUrl = from.url ?: "",
            )
            false -> ListCategory(
                label = from.label,
                webUrl = from.url ?: "",
                children = from.children?.map(this::mapInnerCategory) ?: emptyList()
            )
        }
}