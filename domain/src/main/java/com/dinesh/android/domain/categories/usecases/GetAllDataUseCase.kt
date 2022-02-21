package com.dinesh.android.domain.categories.usecases

import com.dinesh.android.data.models.DomainModel.TopCategory
import com.dinesh.android.data.repository.CategoriesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllDataUseCase(
    private val repository: CategoriesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    suspend operator fun invoke(): List<TopCategory> =
        withContext(dispatcher) {
            repository.getAllCategories()
        }
}