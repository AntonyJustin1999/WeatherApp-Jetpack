package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class NavigationColors(
    val linkActive : MutableState<Color>,
    val linkStatic : MutableState<Color>,
    val logoActive : MutableState<Color>
){

    fun clone(
        linkActive: MutableState<Color> = mutableStateOf(this.linkActive.value),
        linkStatic: MutableState<Color> = mutableStateOf(this.linkStatic.value),
        logoActive: MutableState<Color> = mutableStateOf(this.logoActive.value)
    )= NavigationColors(
        linkActive  = linkActive,
        linkStatic = linkStatic,
        logoActive = logoActive
    )

    fun updateFrom(other:NavigationColors){
        linkActive.value = other.linkActive.value
        linkStatic.value = other.linkStatic.value
        logoActive.value = other.logoActive.value
    }
}