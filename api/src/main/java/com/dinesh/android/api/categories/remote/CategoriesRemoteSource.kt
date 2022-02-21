package com.dinesh.android.api.categories.remote

import com.dinesh.android.data.models.RemoteCategoriesOverview
import retrofit2.http.GET
import retrofit2.http.Header

interface CategoriesRemoteSource {

    @GET(value = "v1/bonprix/navigation/")
    suspend fun getCategories(
        @Header("x-api-key") apiKey: String,
    ): RemoteCategoriesOverview
}