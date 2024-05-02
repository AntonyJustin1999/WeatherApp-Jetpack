package com.spares.propeller.commons.ui.theme.model.color.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class ChipsColors(
    val default : ChipsColorItem,
    val info: ChipsColorItem,
    val warning : ChipsColorItem,
    val success : ChipsColorItem,
    val error : ChipsColorItem,
    val primary: ChipsColorItem,
    val secondary: ChipsColorItem,
){
    fun clone(
        default: ChipsColorItem = this.default.clone(),
        info: ChipsColorItem = this.info.clone(),
        warning: ChipsColorItem = this.warning.clone(),
        success: ChipsColorItem = this.success.clone(),
        error: ChipsColorItem = this.error.clone(),
        primary: ChipsColorItem = this.primary.clone(),
        secondary: ChipsColorItem = this.secondary.clone()
    ) = ChipsColors(
        default = default,
        info = info,
        warning = warning,
        success = success,
        error = error,
        primary = primary,
        secondary = secondary
    )
    fun updateFrom(other:ChipsColors){
        default.updateFrom(other.default)
        info.updateFrom(other.info)
        warning.updateFrom(other.warning)
        success.updateFrom(other.success)
        error.updateFrom(other.error)
        primary.updateFrom(other.primary)
        secondary.updateFrom(other.secondary)
    }
}

data class ChipsColorItem(
    val background: MutableState<Color>,
    val text: MutableState<Color>
){
    fun clone(
        background: MutableState<Color> = mutableStateOf(this.background.value),
        text: MutableState<Color> = mutableStateOf(this.text.value)
    )= ChipsColorItem(
        background = background,
        text = text
    )
    fun updateFrom(other: ChipsColorItem){
       background.value = other.background.value
       text.value = other.text.value
    }
}