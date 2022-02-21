package com.dinesh.android.bonprix.ui.components

import android.annotation.SuppressLint
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.dinesh.android.compose_ui.theme.BonPrixTypography

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun BonPrixWebView(
    url: String,
    title: String,
    onBack: () -> Unit,
) {
    Scaffold(
        contentColor = Color.White,
        backgroundColor = Color.LightGray,
        topBar = {
            TopAppBar(
                elevation = 2.dp,
            ) {
                TextButton(
                    modifier = Modifier.height(40.dp),
                    onClick = {  }
                ) {
                    Text(
                        style = BonPrixTypography.h6,
                        text = title,
                    )
                }
            }
        }
    ) { innerPadding ->
        AndroidView(
            modifier = Modifier.padding(innerPadding),
            factory = {
                WebView(it).apply {
                    webViewClient = WebViewClient()
                    webChromeClient = WebChromeClient()

                    CookieManager
                        .getInstance()
                        .setAcceptCookie(true)

                    isVerticalScrollBarEnabled = false
                    isHorizontalScrollBarEnabled = false

                    with(settings) {
                        allowContentAccess = true
                        domStorageEnabled = true
                        allowFileAccess = true
                        databaseEnabled = true
                        javaScriptEnabled = true
                        javaScriptCanOpenWindowsAutomatically = true
                    }
                    loadUrl(url)
                }
            }
        )
        BackHandler(
            enabled = true,
            onBack = onBack,
        )
    }
}