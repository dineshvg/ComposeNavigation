package com.dinesh.android.bonprix.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dinesh.android.bonprix.category.navigation.CategoryRoute
import com.dinesh.android.bonprix.overview.navigation.CategoriesOverviewRoute
import com.dinesh.android.bonprix.presentation.BonPrixViewModel
import com.dinesh.android.bonprix.ui.components.BonPrixWebView
import org.koin.androidx.compose.getViewModel

internal const val CATEGORY_NAME = "categoryName"

internal object BonPrixDestinations {
    const val HOME_ROUTE = "home"
    const val INNER_ROUTE = "innerRoute/{$CATEGORY_NAME}"
    const val ANDROID_WEB_VIEW = "ANDROID_WEB_VIEW"
}

@Composable
fun BonPrixNavGraph(
    modifier: Modifier = Modifier,
    viewModel: BonPrixViewModel = getViewModel(),
    navController: NavHostController = rememberNavController(),
    startDestination: String = BonPrixDestinations.HOME_ROUTE,
    onFinalBackPress: () -> Unit,
) {
    viewModel.getCategories()
    val data by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = BonPrixDestinations.HOME_ROUTE) {
            CategoriesOverviewRoute(
                data = data,
                onCategoryClicked = { topCategoryName ->
                    navController.navigate("innerRoute/${topCategoryName}&&")
                },
                onTopBarClicked = { url ->
                    viewModel.webUrl = url
                    navController.navigate(BonPrixDestinations.ANDROID_WEB_VIEW)
                },
                onBack = onFinalBackPress,
            )
        }
        composable(
            route = BonPrixDestinations.INNER_ROUTE,
            arguments = listOf(navArgument(CATEGORY_NAME) { type = NavType.StringType }),
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(CATEGORY_NAME)?.let { args ->
                CategoryRoute(
                    data = data,
                    //since jetpack compose does not allow navigation with parcelables
                    selectedCategories = args.split("&&").filter { it.isNotEmpty() },
                    onTopBarClicked = { url ->
                        viewModel.webUrl = url
                        navController.navigate(BonPrixDestinations.ANDROID_WEB_VIEW)
                    },
                    onWebLinkClicked = { url ->
                        viewModel.webUrl = url
                        navController.navigate(BonPrixDestinations.ANDROID_WEB_VIEW)
                    },
                    onCategoryClicked = { categoryName ->
                        navController.navigate("innerRoute/${args}${categoryName}&&")
                    },
                    onBack = navController::popBackStack,
                )
            }
        }
        composable(
            BonPrixDestinations.ANDROID_WEB_VIEW,
        ) {
            viewModel.webUrl?.let { urlForItem ->

                BonPrixWebView(
                    url = urlForItem,
                    title = "",
                    onBack = navController::popBackStack,
                )
            }
        }
    }
}

