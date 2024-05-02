package com.spares.propeller.commons.ui.theme.model.color.component

import androidx.compose.ui.graphics.Color

data class FilterColor(
    val text: Color,
    val background: Color,
    val icon: Color = Color.LightGray,
    var badgeBackground: Color = Color.White,
    val badgeText: Color = Color.Black,
)
