package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class DashboardSectionColors(
    val workOrderMain : MutableState<Color>,
    val workOrderContrastText: MutableState<Color>,
    val purchaseOrderMain : MutableState<Color>,
    val purchaseOrderContrastText: MutableState<Color>,
    val stockReconMain : MutableState<Color>,
    val stockReconContrastText: MutableState<Color>,
    val equipmentInventoryMain : MutableState<Color>,
    val equipmentInventoryContrastText : MutableState<Color>,
    val loginBackground : MutableState<Color>,
){
    fun clone(
        workOrder : MutableState<Color> = mutableStateOf(this.workOrderMain.value),
        workOrderContrastText: MutableState<Color> = mutableStateOf(this.workOrderContrastText.value),
        purchaseOrder : MutableState<Color> = mutableStateOf(this.purchaseOrderMain.value),
        purchaseOrderContrastText: MutableState<Color> = mutableStateOf(this.purchaseOrderContrastText.value),
        stockRecon : MutableState<Color> = mutableStateOf(this.stockReconMain.value),
        stockReconContrastText: MutableState<Color> = mutableStateOf(this.stockReconContrastText.value),
        equipmentInventory : MutableState<Color> = mutableStateOf(this.equipmentInventoryMain.value),
        equipmentInventoryContrastText : MutableState<Color> = mutableStateOf(this.equipmentInventoryContrastText.value),
        loginBackground : MutableState<Color> = mutableStateOf(this.loginBackground.value),
    )=DashboardSectionColors(
        workOrderMain = workOrder,
        workOrderContrastText = workOrderContrastText,
        purchaseOrderMain = purchaseOrder,
        purchaseOrderContrastText = purchaseOrderContrastText,
        stockReconMain = stockRecon,
        stockReconContrastText = stockReconContrastText,
        equipmentInventoryMain = equipmentInventory,
        equipmentInventoryContrastText = equipmentInventoryContrastText,
        loginBackground = loginBackground
    )
    fun updateFrom(other:DashboardSectionColors){
        workOrderMain.value = other.workOrderMain.value
        workOrderContrastText.value = other.workOrderContrastText.value
        purchaseOrderMain.value = other.purchaseOrderMain.value
        purchaseOrderContrastText.value = other.purchaseOrderContrastText.value
        stockReconMain.value = other.stockReconMain.value
        purchaseOrderContrastText.value = other.stockReconContrastText.value
        equipmentInventoryMain.value = other.equipmentInventoryMain.value
        equipmentInventoryContrastText.value = other.equipmentInventoryContrastText.value
        loginBackground.value = other.loginBackground.value
    }

}