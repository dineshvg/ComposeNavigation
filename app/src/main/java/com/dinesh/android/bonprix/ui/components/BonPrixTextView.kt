package com.dinesh.android.bonprix.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dinesh.android.compose_ui.theme.BonPrixTypography

@Composable
fun BonPrixTextView(
    onWebLinkClick: (String) -> Unit,
    title: String,
    webUrl: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp,
            )
            .clickable {
                onWebLinkClick(webUrl)
            }
    ) {
        Text(
            text = title,
            style = BonPrixTypography.button,
            maxLines = 1
        )
        Divider(
            thickness = 2.dp,
            color = Color.Black.copy(alpha = 0.5f),
            modifier = Modifier.padding(
                top = 8.dp,
            )
        )
    }
}