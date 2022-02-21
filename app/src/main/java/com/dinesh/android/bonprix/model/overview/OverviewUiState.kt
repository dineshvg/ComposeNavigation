package com.dinesh.android.bonprix.model.overview

import com.dinesh.android.bonprix.model.OverviewInnerName

data class OverviewUiState(
    val isLoading: Boolean,
    val title: String,
    val link: String,
    val innerNames: List<OverviewInnerName>,
)