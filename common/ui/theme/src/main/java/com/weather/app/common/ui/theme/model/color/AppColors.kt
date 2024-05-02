package com.weather.app.common.ui.theme.model.color

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.spares.propeller.commons.ui.theme.color.DarkSkin
import com.spares.propeller.commons.ui.theme.color.LightSkin
import com.spares.propeller.commons.ui.theme.model.color.component.ButtonColors
import com.spares.propeller.commons.ui.theme.model.color.component.CheckboxColors
import com.spares.propeller.commons.ui.theme.model.color.component.ChipsColors
import com.spares.propeller.commons.ui.theme.model.color.component.RadioButtonColors
import com.spares.propeller.commons.ui.theme.model.color.component.TextFieldColors
import com.spares.propeller.commons.ui.theme.model.color.design.Others
import com.spares.propeller.commons.ui.theme.model.color.design.Shadow
import com.weather.app.common.ui.theme.model.color.design.Background
import com.weather.app.common.ui.theme.model.color.design.ColorSet
import com.weather.app.common.ui.theme.model.color.design.CommonColors
import com.weather.app.common.ui.theme.model.color.design.DashboardSectionColors
import com.weather.app.common.ui.theme.model.color.design.Icon
import com.weather.app.common.ui.theme.model.color.design.Input
import com.weather.app.common.ui.theme.model.color.design.NavigationColors
import com.weather.app.common.ui.theme.model.color.design.Text

data class APPColors(
    val textPrimary: Text,
    val textSecondary: Text,
    val textDisabled: Text,
    val icon: Icon,
    val background: Background,
    val primary: ColorSet,
    val secondary: ColorSet,
    val error: ColorSet,
    val info: ColorSet,
    val warning: ColorSet,
    val success: ColorSet,
    val dashboardSection: DashboardSectionColors,
    val input: Input,
    val nav: NavigationColors,
    val common: CommonColors,
    val materialColorScheme: ColorScheme,
    val textField: TextFieldColors,
    val button: ButtonColors,
    val chips: ChipsColors,
    val radioButton: RadioButtonColors,
    val checkbox: CheckboxColors,
    val shadow: Shadow,
    val others: Others
) {
    fun clone(
        textPrimary:Text= this.textPrimary.clone(),
        textSecondary:Text= this.textSecondary.clone(),
        textDisabled:Text= this.textDisabled.clone(),
        icon:Icon = this.icon.clone(),
        background: Background = this.background.clone(),
        primary: ColorSet = this.primary.clone(),
        secondary: ColorSet = this.secondary.clone(),
        error: ColorSet = this.error.clone(),
        info: ColorSet = this.info.clone(),
        warning: ColorSet = this.warning.clone(),
        success: ColorSet = this.success.clone(),
        dashboardSection: DashboardSectionColors = this.dashboardSection.clone(),
        input: Input = this.input.clone(),
        nav: NavigationColors = this.nav.clone(),
        common: CommonColors = this.common.clone(),
        materialColorScheme: ColorScheme = this.materialColorScheme.copy(),
        textField: TextFieldColors = this.textField.clone(),
        button: ButtonColors = this.button.clone(),
        chips: ChipsColors = this.chips.clone(),
        radioButton: RadioButtonColors = this.radioButton.clone(),
        checkbox: CheckboxColors = this.checkbox.clone(),
        shadow: Shadow = this.shadow.clone(),
        others: Others = this.others.clone()
    ) = APPColors(
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        textDisabled = textDisabled,
        icon = icon,
        background = background,
        primary = primary,
        secondary = secondary,
        error = error,
        info = info,
        warning = warning,
        success = success,
        dashboardSection = dashboardSection,
        input = input,
        nav = nav,
        common = common,
        materialColorScheme = materialColorScheme,
        textField = textField,
        button = button,
        chips = chips,
        radioButton = radioButton,
        checkbox = checkbox,
        shadow = shadow,
        others = others
    )

    fun updateFrom(other: APPColors){
        textPrimary.updateFrom(other.textPrimary)
        textSecondary.updateFrom(other.textSecondary)
        textDisabled.updateFrom(other.textDisabled)
        icon.updateFrom(other.icon)
        background.updateFrom(other.background)
        primary.updateFrom(other.primary)
        secondary.updateFrom(other.secondary)
        error.updateFrom(other.error)
        info.updateFrom(other.info)
        warning.updateFrom(other.warning)
        success.updateFrom(other.success)
        dashboardSection.updateFrom(other.dashboardSection)
        input.updateFrom(other.input)
        nav.updateFrom(other.nav)
        common.updateFrom(other.common)
        textField.updateFrom(other.textField)
        button.updateFrom(other.button)
        chips.updateFrom(other.chips)
        radioButton.updateFrom(other.radioButton)
        checkbox.updateFrom(other.checkbox)
        shadow.updateFrom(other.shadow)
        others.updateFrom(other.others)
    }
}

private val darkAPPColors = APPColors(
    textPrimary = DarkSkin.textPrimary,
    textSecondary = DarkSkin.textSecondary,
    textDisabled = DarkSkin.textDisabled,
    icon = DarkSkin.icon,
    background = DarkSkin.background,
    primary = DarkSkin.primary,
    secondary = DarkSkin.secondary,
    error = DarkSkin.error,
    info = DarkSkin.info,
    success = DarkSkin.success,
    warning = DarkSkin.warning,
    dashboardSection = DarkSkin.dashboardSection,
    button = DarkSkin.buttonColors,
    textField = DarkSkin.textFieldColors,
    materialColorScheme = DarkSkin.materialColorScheme,
    input = DarkSkin.input,
    nav = DarkSkin.nav,
    common = DarkSkin.common,
    chips = DarkSkin.chips,
    radioButton = DarkSkin.radioButton,
    checkbox = DarkSkin.checkbox,
    shadow = DarkSkin.shadow,
    others = DarkSkin.others
)

//light scheme
private val lightAPPColors = APPColors(
    textPrimary = LightSkin.textPrimary,
    textSecondary = LightSkin.textSecondary,
    textDisabled = LightSkin.textDisabled,
    icon = LightSkin.icon,
    background = LightSkin.background,
    primary = LightSkin.primary,
    secondary = LightSkin.secondary,
    error = LightSkin.error,
    info = LightSkin.info,
    success = LightSkin.success,
    warning = LightSkin.warning,
    dashboardSection = LightSkin.dashboardSection,
    button = LightSkin.buttonColors,
    textField = LightSkin.textFieldColors,
    materialColorScheme = LightSkin.materialColorScheme,
    input = LightSkin.input,
    nav = LightSkin.nav,
    common = LightSkin.common,
    chips = LightSkin.chips,
    radioButton = LightSkin.radioButton,
    checkbox = LightSkin.checkbox,
    shadow = LightSkin.shadow,
    others = LightSkin.others
)

fun defaultPropellerColors() = darkAPPColors

@Composable
fun appthemeColors(isDarkTheme: MutableState<Boolean>): APPColors =
    if (isDarkTheme.value) {
        darkAPPColors
    } else {
        lightAPPColors
    }