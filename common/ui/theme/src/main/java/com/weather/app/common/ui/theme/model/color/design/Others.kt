package com.spares.propeller.commons.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color


data class Others(
    val quickLinkWhite: MutableState<Color>,
    val quickLinkBG : MutableState<Color>,
    val primaryOutlineButton : MutableState<Color>,
    val supplierOrderItem: MutableState<Color>
){
    fun clone(
        quickLinkWhite: MutableState<Color> = mutableStateOf(this.quickLinkWhite.value),
        quickLinkBG: MutableState<Color> = mutableStateOf(this.quickLinkBG.value),
        primaryOutlineButton: MutableState<Color> = mutableStateOf(this.primaryOutlineButton.value),
        supplierOrderItem: MutableState<Color> = mutableStateOf(this.supplierOrderItem.value)
    )= Others(
        quickLinkWhite = quickLinkWhite,
        quickLinkBG = quickLinkBG,
        primaryOutlineButton = primaryOutlineButton,
        supplierOrderItem = supplierOrderItem
    )
    fun updateFrom(other:Others){
        quickLinkWhite.value = other.quickLinkWhite.value
        quickLinkBG.value = other.quickLinkBG.value
        primaryOutlineButton.value = other.primaryOutlineButton.value
    }
}