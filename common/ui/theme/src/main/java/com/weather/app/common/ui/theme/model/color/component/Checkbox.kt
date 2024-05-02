package com.spares.propeller.commons.ui.theme.model.color.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class CheckboxColors(
    val text: MutableState<Color>,
    val disabledText: MutableState<Color>,
    val checkedBorder : MutableState<Color>,
    val checkedBox : MutableState<Color>,
    val checkedCheckmark : MutableState<Color>,
    val uncheckedCheckmark : MutableState<Color>,
    val uncheckedBox : MutableState<Color>,
    val disabledCheckedBox : MutableState<Color>,
    val disabledUncheckedBox : MutableState<Color>,
    val disabledIndeterminateBox : MutableState<Color>,
    val uncheckedBorder : MutableState<Color>,
    val disabledBorder : MutableState<Color>,
    val disabledIndeterminateBorder : MutableState<Color>
    ){

    fun clone(
         text: MutableState<Color> = mutableStateOf(this.text.value),
         disabledText: MutableState<Color> = mutableStateOf(this.disabledText.value),
         checkedBorder : MutableState<Color> = mutableStateOf(this.checkedBorder.value),
         checkedBox : MutableState<Color> = mutableStateOf(this.checkedBox.value),
         checkedCheckmark : MutableState<Color> = mutableStateOf(this.checkedCheckmark.value),
         uncheckedCheckmark : MutableState<Color> = mutableStateOf(this.uncheckedCheckmark.value),
         uncheckedBox : MutableState<Color> = mutableStateOf(this.uncheckedBox.value),
         disabledCheckedBox : MutableState<Color> = mutableStateOf(this.disabledCheckedBox.value),
         disabledUncheckedBox : MutableState<Color> = mutableStateOf(this.disabledUncheckedBox.value),
         disabledIndeterminateBox : MutableState<Color> = mutableStateOf(this.disabledIndeterminateBox.value),
         uncheckedBorder : MutableState<Color> = mutableStateOf(this.uncheckedBorder.value),
         disabledBorder : MutableState<Color> = mutableStateOf(this.disabledBorder.value),
         disabledIndeterminateBorder : MutableState<Color> = mutableStateOf(this.disabledIndeterminateBorder.value)
    ) = CheckboxColors(
        text = text,
        disabledText = disabledText,
        checkedBorder = checkedBorder,
        checkedBox = checkedBox,
        checkedCheckmark = checkedCheckmark,
        uncheckedCheckmark = uncheckedCheckmark,
        uncheckedBox =  uncheckedBox,
        disabledCheckedBox = disabledCheckedBox,
        disabledUncheckedBox = disabledUncheckedBox,
        disabledIndeterminateBox = disabledIndeterminateBox,
        uncheckedBorder = uncheckedBorder,
        disabledBorder = disabledBorder,
        disabledIndeterminateBorder = disabledIndeterminateBorder
    )
    fun updateFrom(other:CheckboxColors){
       text.value = other.text.value
        disabledText.value = other.disabledText.value
       checkedBorder.value = other.checkedBorder.value
       checkedBox.value = other.checkedBox.value
       checkedCheckmark.value = other.checkedCheckmark.value
       uncheckedCheckmark.value = other.uncheckedCheckmark.value
       uncheckedBox.value = other.uncheckedBox.value
       disabledCheckedBox.value = other.disabledCheckedBox.value
       disabledUncheckedBox.value = other.disabledUncheckedBox.value
       disabledIndeterminateBox.value = other.disabledIndeterminateBox.value
       uncheckedBorder.value = other.uncheckedBorder.value
       disabledBorder.value = other.disabledBorder.value
       disabledIndeterminateBorder.value = other.disabledIndeterminateBorder.value
    }
}