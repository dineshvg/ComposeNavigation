package com.dinesh.android.bonprix.overview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.overview.ui.CategoryOverview
import com.dinesh.android.data.models.DomainModel

@Composable
fun CategoriesOverviewRoute(
    data: AllCategoryUiState,
    onCategoryClicked: (String) -> Unit,
    onTopBarClicked: (String) -> Unit,
    onBack: () -> Unit,
) {
    CategoryOverview(
        data = data,
        onTopBarClicked = onTopBarClicked,
        onCategoryClicked = onCategoryClicked,
        onBack = onBack,
    )
}