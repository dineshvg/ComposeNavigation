package com.dinesh.android.bonprix.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dinesh.android.compose_ui.theme.BonPrixTypography
import com.google.android.material.R

@SuppressLint("PrivateResource")
@Composable
fun BonPrixCard(
    onCategoryClick: (String) -> Unit,
    text: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp,
            ),
        backgroundColor = Color.DarkGray,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(8.dp)
                .clickable {
                    onCategoryClick(text)
                }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .weight(0.7f),
                text = text,
                style = BonPrixTypography.button,
                color = Color.White,
            )
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .weight(0.3f),
                colorFilter = ColorFilter.tint(Color.White),
                painter = painterResource(
                    id = R.drawable.material_ic_keyboard_arrow_next_black_24dp
                ),
                contentDescription = "next section $text")
        }
    }
}