package com.weather.app.common.ui.theme.modifiers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.horizontalGradientBackground(
    colors: List<Color>
) = gradientBackground(colors) { gradientColors, size ->
    Brush.horizontalGradient(
        colors = gradientColors,
        startX = 0f,
        endX = size.width
    )
}

fun Modifier.verticalGradientBackground(
    colors: List<Color>
) = gradientBackground(colors) { gradientColors, size ->
    Brush.verticalGradient(
        colors = gradientColors,
        startY = 0f,
        endY = size.width
    )
}

fun Modifier.diagonalGradientTint(
    colors: List<Color>,
    blendMode: BlendMode
) = gradientTint(colors, blendMode) { gradientColors, size ->
    Brush.linearGradient(
        colors = gradientColors,
        start = Offset(
            x = 0f,
            y = 0f
        ),
        end = Offset(
            x = size.width,
            y = size.height
        ),
        tileMode = TileMode.Clamp
    )
}

fun Modifier.gradientBackground(
    colors: List<Color>,
    brushProvider: (List<Color>, Size) -> Brush
): Modifier = composed {
    var size by remember { mutableStateOf(Size.Zero) }
    val gradient = remember(colors, size) { brushProvider(colors, size) }
    drawWithContent {
        size = this.size
        drawRect(brush = gradient)
        drawContent()
    }
}

fun Modifier.gradientTint(
    colors: List<Color>,
    blendMode: BlendMode,
    brushProvider: (List<Color>, Size) -> Brush
) = composed {
    var size by remember { mutableStateOf(Size.Zero) }
    val gradient = remember(colors, size) { brushProvider(colors, size) }
    drawWithContent {
        drawContent()
        size = this.size
        drawRect(
            brush = gradient,
            blendMode = blendMode
        )
    }
}

fun Modifier.drawColoredShadow(
    color: Color = Color.Black,
    alpha: Float = 0.7f,
    borderRadius: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 10.dp,
    spread: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = color.copy(alpha = 0.0f).toArgb()
    val shadowColor = color.copy(alpha = alpha).toArgb()
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            blurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.save()

        if (spread.value > 0) {
            fun calcSpreadScale(spread: Float, childSize: Float): Float {
                return 1f + ((spread / childSize) * 2f)
            }

            it.scale(
                calcSpreadScale(spread.toPx(), this.size.width),
                calcSpreadScale(spread.toPx(), this.size.height),
                this.center.x,
                this.center.y
            )
        }

        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
        it.restore()
    }
}