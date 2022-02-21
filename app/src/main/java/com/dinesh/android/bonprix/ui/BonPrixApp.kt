package com.dinesh.android.bonprix.ui

import androidx.compose.runtime.Composable
import com.dinesh.android.bonprix.navigation.BonPrixNavGraph

@Composable
fun BonPrixApp(
    onFinalBackPress: () -> Unit,
) {
    BonPrixTheme() {
        BonPrixNavGraph(
            onFinalBackPress = onFinalBackPress
        )
    }
}

