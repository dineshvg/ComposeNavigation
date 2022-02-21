package com.dinesh.android.bonprix.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class BonPrixActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            updateSystemUIBars()
            BonPrixApp() {
                finish()
            }
        }
    }
}

@Composable
fun updateSystemUIBars() {
    val systemUiController = rememberSystemUiController()
    with(systemUiController) {
        isStatusBarVisible = false

        if (isSystemInDarkTheme()) {
            setSystemBarsColor(color = Color.Transparent)
        } else {
            setSystemBarsColor(color = Color.White)
        }
    }
}