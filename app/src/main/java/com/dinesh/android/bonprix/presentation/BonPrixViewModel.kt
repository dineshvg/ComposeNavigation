package com.dinesh.android.bonprix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.android.bonprix.model.AllCategoryDataViewModelState
import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.data.models.DomainModel
import com.dinesh.android.domain.categories.usecases.GetAllDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BonPrixViewModel(
    private val allData: GetAllDataUseCase,
) : ViewModel()  {

    private val viewModelState: MutableStateFlow<AllCategoryDataViewModelState> = MutableStateFlow(
        AllCategoryDataViewModelState(categories = emptyList())
    )

    val uiState: StateFlow<AllCategoryUiState> = viewModelState
        .map {
            it.toUiState()
        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    var webUrl: String? = null

    fun getCategories() {
        viewModelScope.launch {
            val allData = allData()
            viewModelState.update {
                it.copy(
                    categories = allData
                )
            }
        }
    }
}