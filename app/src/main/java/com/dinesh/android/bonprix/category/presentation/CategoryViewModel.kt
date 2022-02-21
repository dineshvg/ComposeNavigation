package com.dinesh.android.bonprix.category.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.model.category.CategoryUiState
import com.dinesh.android.bonprix.model.category.CategoryViewModelState
import com.dinesh.android.data.models.DomainModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class CategoryViewModel : ViewModel() {

    private val viewModelState: MutableStateFlow<CategoryViewModelState> =
        MutableStateFlow(
            CategoryViewModelState(isLoading = true)
        )

    val uiState: StateFlow<CategoryUiState> = viewModelState
        .map(CategoryViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getCategory(
        data: AllCategoryUiState,
        selectedCategories: List<String>,
    ) {
        var categories: List<DomainModel.InnerCategory> = emptyList()

        selectedCategories.forEachIndexed { index: Int, category: String ->
            categories = when (index) {
                0 -> extractCategories(data, selectedCategories[0])
                else -> {
                    categories.find { it.label == category }?.let {
                        when(it) {
                            is DomainModel.ListCategory -> it.children
                            else -> emptyList()
                        }
                    } ?: emptyList()
                }
            }
        }

        viewModelState.update {
            it.copy(
                items = categories,
                isLoading = false,
                title = selectedCategories.last(),
                innerCategories = it.innerCategories,
            )
        }
    }

    private fun extractCategories(
        data: AllCategoryUiState,
        selectedCategory: String
    ) =
        data.categories.first {
            it.label == selectedCategory
        }.innerCategories ?: emptyList()



}