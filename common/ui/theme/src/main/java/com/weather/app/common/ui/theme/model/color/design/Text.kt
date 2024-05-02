package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class Text(
    val main: MutableState<Color>,
    val contrastText: MutableState<Color>,
){
    fun clone(
        main: MutableState<Color> = mutableStateOf(this.main.value),
        contrastText: MutableState<Color> = mutableStateOf(this.contrastText.value),
    )= Text(
        main= main,
        contrastText = contrastText,
    )

    fun updateFrom(other:Text){
        main.value = other.main.value
        contrastText.value = other.contrastText.value
    }
}

