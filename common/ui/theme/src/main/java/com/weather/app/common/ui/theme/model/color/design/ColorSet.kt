package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class ColorSet(
    val main: MutableState<Color>,
    val light: MutableState<Color>,
    val dark: MutableState<Color>,
    val contrastText: MutableState<Color>
){
    fun clone(
        main: MutableState<Color> = mutableStateOf(this.main.value),
        light: MutableState<Color> = mutableStateOf(this.light.value),
        dark: MutableState<Color> = mutableStateOf(this.dark.value),
        contrastText: MutableState<Color> = mutableStateOf(this.contrastText.value)
    )=ColorSet(
        main = main,
        light = light,
        dark = dark,
        contrastText = contrastText
    )
    fun updateFrom (other : ColorSet){
        main.value = other.main.value
        light.value = other.light.value
        dark.value = other.dark.value
        contrastText.value = other.contrastText.value
    }
}