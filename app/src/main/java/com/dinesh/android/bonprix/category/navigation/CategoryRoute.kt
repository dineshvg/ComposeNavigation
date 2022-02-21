package com.dinesh.android.bonprix.category.navigation

import androidx.compose.runtime.Composable
import com.dinesh.android.bonprix.category.ui.CategoryView
import com.dinesh.android.bonprix.model.AllCategoryUiState

@Composable
fun CategoryRoute(
    data: AllCategoryUiState,
    selectedCategories: List<String>,
    onCategoryClicked: (String) -> Unit,
    onTopBarClicked: (String) -> Unit,
    onWebLinkClicked: (String) -> Unit,
    onBack: () -> Unit,
) {
    CategoryView(
        data = data,
        selectedCategories = selectedCategories,
        onTopBarClick = onTopBarClicked,
        onCategoryClick = onCategoryClicked,
        onWebLinkClick = onWebLinkClicked,
        onBack = onBack
    )
}