package com.weather.app.login.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.weather.app.common.ui.theme.appThemeColors
import com.weather.app.common.ui.theme.baseDensityIndependentPixels
import com.weather.app.common.ui.theme.quarter
import com.weather.app.login.ui.R

private val BOTTOM_PADDING = baseDensityIndependentPixels.dp
private val IMAGE_WIDTH = (baseDensityIndependentPixels * 5.8).dp
private val IMAGE_HEIGHT = (baseDensityIndependentPixels * 1.6).dp
private val SPACER_BETWEEN_TEXT_IMAGE = (quarter* baseDensityIndependentPixels).dp

@Composable
fun LoginBottomView(){
    Column(modifier = Modifier.padding(bottom = BOTTOM_PADDING)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

            ) {
            Text(text = "by", color = MaterialTheme.appThemeColors.textPrimary.main.value)
            Spacer(modifier = Modifier.width(SPACER_BETWEEN_TEXT_IMAGE))
            Image(
                painter = painterResource(id = R.drawable.login_bottom_image),
                contentDescription = "",
                modifier = Modifier
                    .width(IMAGE_WIDTH)
                    .height(IMAGE_HEIGHT)
            )
        }
        Text(text = "Version 2.00.00", color = MaterialTheme.appThemeColors.textPrimary.main.value)
    }
}