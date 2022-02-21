package com.dinesh.android.bonprix.overview.ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.overview.presentation.CategoriesOverviewViewModel
import com.dinesh.android.compose_ui.components.BonPrixTopAppBar
import com.dinesh.android.compose_ui.theme.BonPrixTypography
import org.koin.androidx.compose.getViewModel

@SuppressLint("PrivateResource")
@Composable
fun CategoryOverview(
    data: AllCategoryUiState,
    viewModel: CategoriesOverviewViewModel = getViewModel(),
    onTopBarClicked: (webUrl: String) -> Unit,
    onCategoryClicked: (innerCategoryLabel: String) -> Unit,
    onBack: () -> Unit,
) {

    viewModel.getOverview(data)
    val uiState by viewModel.uiState.collectAsState()
    AnimatedVisibility(visible = !uiState.isLoading) {
        Scaffold(
            contentColor = Color.White,
            backgroundColor = Color.LightGray,
            topBar = {
                BonPrixTopAppBar(
                    isFirst = true,
                    title = uiState.title,
                    webLink = uiState.link,
                    onTopBarClicked = { onTopBarClicked(it) },
                    onBackPressed = onBack,
                    )
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier.padding(innerPadding)
            ) {
                uiState.innerNames.forEach { topCategoryItem ->
                    OverviewListItem(
                        label = topCategoryItem.name,
                        imageUrl = topCategoryItem.imageUrl,
                        onClick = {
                            onCategoryClicked(topCategoryItem.name)
                        }
                    )
                }
            }
            BackHandler(
                enabled = true,
                onBack = onBack,
            )
        }
    }

}

@OptIn(ExperimentalCoilApi::class)
@Suppress("FunctionName")
fun LazyListScope.OverviewListItem(
    label: String,
    imageUrl: String?,
    onClick: () -> Unit,
) {
    item {
        Column {
            Text(
                modifier = Modifier.padding(
                    vertical = 8.dp,
                    horizontal = 16.dp,
                ),
                text = label,
                style = BonPrixTypography.h5,
                color = Color.Black
            )

            val painter = rememberImagePainter(data = imageUrl)
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 2.dp)
                    .clickable(
                        enabled = true,
                        onClick = onClick,
                    ),
                painter = painter,
                contentDescription = label,
                contentScale = ContentScale.Crop
            )

            Divider(
                thickness = 2.dp,
                color = Color.Gray.copy(alpha = 0.2f)
            )
        }
    }
}