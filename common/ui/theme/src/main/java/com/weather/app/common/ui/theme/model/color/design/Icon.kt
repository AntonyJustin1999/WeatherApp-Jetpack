package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class Icon(
    val primary: MutableState<Color>,
    val secondary: MutableState<Color>,
    val disabled: MutableState<Color>
){

    fun clone(
        primary: MutableState<Color> = mutableStateOf(this.primary.value),
        secondary: MutableState<Color> = mutableStateOf(this.secondary.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value),
    )= Icon(
        primary= primary,
        secondary = secondary,
        disabled = disabled
    )
    fun updateFrom(other:Icon){
        primary.value = other.primary.value
        secondary.value = other.secondary.value
        disabled.value = other.disabled.value
    }
}