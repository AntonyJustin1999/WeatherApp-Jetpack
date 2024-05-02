package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class Input(
    val disabledBackgroundColor: MutableState<Color>,
    val outlineDefault : MutableState<Color>,
    val outlineDisabled : MutableState<Color>
){
    fun clone(
        disabledBackgroundColor: MutableState<Color> = mutableStateOf(this.disabledBackgroundColor.value),
        outlineDefault: MutableState<Color> = mutableStateOf(this.outlineDefault.value),
        outlineDisabled: MutableState<Color> = mutableStateOf(this.outlineDisabled.value)

    )= Input(
        disabledBackgroundColor = disabledBackgroundColor,
        outlineDefault = outlineDefault,
        outlineDisabled = outlineDisabled
    )
    fun updateFrom(other:Input){
        disabledBackgroundColor.value = other.disabledBackgroundColor.value
        outlineDefault.value = other.outlineDefault.value
        outlineDisabled.value = other.outlineDisabled.value
    }
}