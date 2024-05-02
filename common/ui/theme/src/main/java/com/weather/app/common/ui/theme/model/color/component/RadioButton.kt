package com.spares.propeller.commons.ui.theme.model.color.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class RadioButtonColors(
    val text : MutableState<Color>,
    val disabledText : MutableState<Color>,
    var selected : MutableState<Color>,
    var unSelected : MutableState<Color>,
    val disabled : MutableState<Color>
){
    fun clone (
        text: MutableState<Color> = mutableStateOf(this.text.value),
        disabledText: MutableState<Color> = mutableStateOf(this.disabledText.value),
        selected: MutableState<Color> = mutableStateOf(this.selected.value),
        unSelected: MutableState<Color> = mutableStateOf(this.unSelected.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value),

        ) = RadioButtonColors(
        text = text,
        disabledText = disabledText,
        selected = selected,
        unSelected = unSelected,
        disabled = disabled

    )
    fun updateFrom(other: RadioButtonColors){
       text.value = other.text.value
       disabledText.value = other.disabledText.value
       selected.value = other.selected.value
       unSelected.value = other.unSelected.value
       disabled.value = other.disabled.value
    }
}