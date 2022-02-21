package com.dinesh.android.data.repository

import com.dinesh.android.data.models.DomainModel.TopCategory

interface CategoriesRepository {

    suspend fun getAllCategories(): List<TopCategory>
}