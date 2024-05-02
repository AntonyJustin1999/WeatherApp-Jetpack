package com.spares.propeller.commons.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class Shadow(
    val medium: MutableState<Color>,
    val large: MutableState<Color>,
    val largeInnerShadow: MutableState<Color>
){
    fun clone(
        medium: MutableState<Color> = mutableStateOf(this.medium.value),
        large: MutableState<Color> = mutableStateOf(this.large.value),
        largeInnerShadow: MutableState<Color> = mutableStateOf(this.largeInnerShadow.value),
    )= Shadow(
        medium= medium,
        large = large,
        largeInnerShadow = largeInnerShadow
    )

    fun updateFrom(other:Shadow){
        medium.value = other.medium.value
        large.value = other.large.value
        largeInnerShadow.value = other.largeInnerShadow.value
    }
}

