package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class Background(
    val paper: MutableState<Color>,
    val surface: MutableState<Color> = paper,
    val paperInverted: MutableState<Color>,
    val divider: MutableState<Color>,
    val backgroundOne: MutableState<Color>,
    val backgroundTwo: MutableState<Color>,
    val backgroundThree: MutableState<Color>,
    val backgroundFour: MutableState<Color>,
    val backgroundFive: MutableState<Color>,
){
    fun clone(
        paper: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.paper.value),
        surface: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.surface.value),
        paperInverted:MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.paperInverted.value),
        divider: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.divider.value),
        backgroundOne: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.backgroundOne.value),
        backgroundTwo: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.backgroundTwo.value),
        backgroundThree: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.backgroundThree.value),
        backgroundFour: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.backgroundFour.value),
        backgroundFive: MutableState<androidx.compose.ui.graphics.Color> = mutableStateOf(this.backgroundFive.value),
    )= Background(
        paper= paper,
        surface = surface,
        paperInverted = paperInverted,
        divider = divider,
        backgroundOne = backgroundOne,
        backgroundTwo = backgroundTwo,
        backgroundThree = backgroundThree,
        backgroundFour = backgroundFour,
        backgroundFive = backgroundFive
    )
    fun updateFrom(other : Background){
        paper.value = other.paper.value
        surface.value = other.surface.value
        paperInverted.value = other.paperInverted.value
        divider.value = other.divider.value
        backgroundOne.value = other.backgroundOne.value
        backgroundTwo.value = other.backgroundTwo.value
        backgroundThree.value = other.backgroundThree.value
        backgroundFour.value = other.backgroundFour.value
        backgroundFive.value = other.backgroundFive.value
    }
}