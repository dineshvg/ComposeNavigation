package com.dinesh.android.bonprix.category.ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dinesh.android.bonprix.category.presentation.CategoryViewModel
import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.ui.components.BonPrixCard
import com.dinesh.android.bonprix.ui.components.BonPrixTextView
import com.dinesh.android.compose_ui.components.BonPrixTopAppBar
import com.dinesh.android.compose_ui.theme.BonPrixTypography
import org.koin.androidx.compose.getViewModel

@SuppressLint("PrivateResource")
@Composable
fun CategoryView(
    data: AllCategoryUiState,
    selectedCategories: List<String>,
    viewModel: CategoryViewModel = getViewModel(),
    onTopBarClick: (String) -> Unit,
    onCategoryClick: (String) -> Unit,
    onWebLinkClick: (String) -> Unit,
    onBack: () -> Unit,
) {

    viewModel.getCategory(
        data = data,
        selectedCategories = selectedCategories,
    )
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        contentColor = Color.White,
        backgroundColor = Color.LightGray,
        topBar = {
            BonPrixTopAppBar(
                isFirst = false,
                title = uiState.title,
                webLink = null,
                onTopBarClicked = { onTopBarClick(it) },
                onBackPressed = onBack,
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            uiState.innerCategory?.forEach { category ->
                if(category.showChevron) {
                    item {
                        BonPrixCard(
                            onCategoryClick = onCategoryClick,
                            text = category.name
                        )
                    }
                } else {
                    item {
                        BonPrixTextView(
                            onWebLinkClick = onWebLinkClick,
                            title = category.name,
                            webUrl = category.webUrl,
                        )
                    }
                }

            }
        }
        BackHandler(
            enabled = true,
            onBack = onBack,
        )
    }
}