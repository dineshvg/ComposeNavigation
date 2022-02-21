package com.dinesh.android.api.categories.repository

import com.dinesh.android.api.categories.mapper.DomainMapper
import com.dinesh.android.api.categories.remote.CategoriesRemote
import com.dinesh.android.data.repository.CategoriesRepository

class CategoriesRepositoryImpl(
    private val remote: CategoriesRemote,
    private val mapper: DomainMapper,
): CategoriesRepository {

    override suspend fun getAllCategories() =
        remote.getCategories().categories.map(mapper::mapToDomain)
}