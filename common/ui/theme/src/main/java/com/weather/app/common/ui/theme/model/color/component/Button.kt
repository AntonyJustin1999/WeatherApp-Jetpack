package com.spares.propeller.commons.ui.theme.model.color.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class ButtonItem(
    var container: MutableState<Color>,
    var content: MutableState<Color>,
    var outline: MutableState<Color>,
    val disabledContainer: MutableState<Color>,
    val disabledContent: MutableState<Color>,
    val disabledOutline: MutableState<Color>
){

    fun clone(
        container: MutableState<Color> = mutableStateOf(this.container.value),
        content: MutableState<Color> = mutableStateOf(this.content.value),
        outline: MutableState<Color> = mutableStateOf(this.outline.value),
        disabledContainer: MutableState<Color> = mutableStateOf(this.disabledContainer.value),
        disabledContent: MutableState<Color> = mutableStateOf(this.disabledContent.value),
        disabledOutline: MutableState<Color> = mutableStateOf(this.disabledOutline.value),

        ) = ButtonItem(
        container = container,
        content = content,
        outline = outline,
        disabledContainer = disabledContainer,
        disabledContent = disabledContent,
        disabledOutline = disabledOutline
    )
    fun updateFrom(other:ButtonItem){
       container.value = other.container.value
       content.value = other.content.value
       outline.value = other.outline.value
       disabledContainer.value = other.disabledContainer.value
       disabledContent.value = other.disabledContent.value
       disabledOutline.value = other.disabledOutline.value
    }
}

data class ButtonColors(
    var highEmphasis: ButtonItem,
    var mediumEmphasis: ButtonItem,
    var lowEmphasis: ButtonItem
){
    fun clone(
        highEmphasis: ButtonItem = this.highEmphasis.clone(),
        mediumEmphasis: ButtonItem = this.mediumEmphasis.clone(),
        lowEmphasis: ButtonItem = this.lowEmphasis.clone()
    )= ButtonColors(
        highEmphasis = highEmphasis,
        mediumEmphasis = mediumEmphasis,
        lowEmphasis = lowEmphasis
    )
    fun updateFrom(other:ButtonColors){
       highEmphasis.updateFrom(other.highEmphasis)
       mediumEmphasis.updateFrom(other.mediumEmphasis)
       lowEmphasis.updateFrom(other.lowEmphasis)
    }
}