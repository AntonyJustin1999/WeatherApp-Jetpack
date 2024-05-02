package com.spares.propeller.commons.ui.theme.color

import androidx.compose.ui.graphics.Color
import com.weather.app.common.ui.theme.model.color.ColorOpacities

object AppColorUtils {

    fun getColorWithOpacity(
        inputColor: Color,
        inputOpacity: ColorOpacities
    ): Color =
        inputColor.copy(alpha = inputOpacity.level)


}