package com.dinesh.android.api.categories.remote

import com.dinesh.android.data.models.RemoteCategoriesOverview

class CategoriesRemote(
    private val remoteSource: CategoriesRemoteSource,
) {

    suspend fun getCategories(): RemoteCategoriesOverview =
        remoteSource.getCategories(
            apiKey = "N8Nx0OwOvo1iuN2ZkFHZlyVKBVgoIcy4tUHMppO5"
        )
}