package com.dinesh.android.bonprix.overview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.model.overview.CategoriesOverViewModelState
import com.dinesh.android.bonprix.model.overview.OverviewUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class CategoriesOverviewViewModel: ViewModel() {

    private val viewModelState: MutableStateFlow<CategoriesOverViewModelState> =
        MutableStateFlow(
            CategoriesOverViewModelState(isLoading = true)
    )

    val uiState: StateFlow<OverviewUiState> = viewModelState
        .map(CategoriesOverViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            viewModelState.value.toUiState()
        )

    fun getOverview(data: AllCategoryUiState) {
        viewModelState.update { it.copy(isLoading = true) }
        viewModelState.update {
            it.copy(
                isLoading = false,
                categories = data.categories
            )
        }
    }
}