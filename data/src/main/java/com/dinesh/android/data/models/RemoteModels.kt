package com.dinesh.android.data.models

import com.squareup.moshi.Json

data class RemoteCategoriesOverview(
    @Json(name = "categories") val categories: List<RemoteCategory>,
)

data class RemoteCategory(
    @Json(name = "label") val label: String,
    @Json(name = "url") val url: String? = null,
    @Json(name = "image") val imageUrl: String? = null,
    @Json(name = "children") val children: List<RemoteInnerCategory>? = null,
)

data class RemoteInnerCategory(
    @Json(name = "label") val label: String,
    @Json(name = "url") val url: String? = null,
    @Json(name = "children") val children: List<RemoteInnerCategory>? = null,
)