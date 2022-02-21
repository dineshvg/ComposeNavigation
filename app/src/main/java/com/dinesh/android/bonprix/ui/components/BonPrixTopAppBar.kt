package com.dinesh.android.compose_ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dinesh.android.compose_ui.theme.BonPrixTypography
import com.google.android.material.R as GoogleR

@SuppressLint("PrivateResource")
@Composable
fun BonPrixTopAppBar(
    modifier: Modifier = Modifier,
    isFirst: Boolean,
    title: String,
    webLink: String?,
    onTopBarClicked: (webUrl: String) -> Unit,
    onBackPressed: () -> Unit,
) {
    TopAppBar(
        elevation = 4.dp
    ) {
        if (isFirst) {
            Image(
                modifier = Modifier
                    .weight(0.1f)
                    .height(25.dp)
                    .clickable { onBackPressed() },
                painter = painterResource(id = GoogleR.drawable.mtrl_ic_cancel),
                contentDescription = "Close"
            )
        } else {
            Image(
                modifier = Modifier
                    .weight(0.1f)
                    .height(25.dp)
                    .clickable { onBackPressed() },
                colorFilter = ColorFilter.tint(Color.White),
                painter = painterResource(id = GoogleR.drawable.material_ic_keyboard_arrow_left_black_24dp),
                contentDescription = "Close"
            )
        }
        Spacer(modifier = Modifier
            .width(20.dp)
            .weight(0.05f))
        TextButton(
            modifier = Modifier
                .height(40.dp)
                .weight(0.85f),
            onClick = { webLink?.let { onTopBarClicked(it) } }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                style = BonPrixTypography.h6,
                text = title
            )
        }
    }
}