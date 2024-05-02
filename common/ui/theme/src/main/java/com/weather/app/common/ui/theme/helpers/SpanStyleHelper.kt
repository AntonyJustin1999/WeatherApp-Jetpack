package com.spares.propeller.commons.ui.theme.helpers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.spares.propeller.commons.ui.theme.*
import com.weather.app.common.ui.theme.baseScalablePixels
import com.weather.app.common.ui.theme.bodyOneScale
import com.weather.app.common.ui.theme.bodyTwoScale

fun getSpanStyleBody2Regular(color: Color) = SpanStyle(
    color = color,
    fontFamily = Lato,
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Normal,
    fontSize = (bodyTwoScale * baseScalablePixels).sp,
    letterSpacing = (0.00125 * baseScalablePixels).sp
)

fun getSpanStyleBody2Bold(color: Color) = SpanStyle(
    color = color,
    fontFamily = Lato,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    fontSize = (bodyTwoScale * baseScalablePixels).sp,
    letterSpacing = (0.00125 * baseScalablePixels).sp
)

fun getSpanStyleBody1Regular(color: Color) = SpanStyle(
    color = color,
    fontFamily = Lato,
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Normal,
    fontSize = (bodyOneScale * baseScalablePixels).sp,
    letterSpacing = (0.00125 * baseScalablePixels).sp
)

fun getSpanStyleBody1Bold(color: Color) = SpanStyle(
    color = color,
    fontFamily = Lato,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    fontSize = (bodyOneScale * baseScalablePixels).sp,
    letterSpacing = (0.00125 * baseScalablePixels).sp
)
