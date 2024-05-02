package com.weather.app.common.ui.theme.model.color.design

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.spares.propeller.commons.ui.theme.model.color.design.Others

data class CommonColors(
    val backdrop: MutableState<Color>,
    val bottomSheetBG: MutableState<Color>,
    val core: Core,
    val input : CommonInput,
    val background: Background,
    val nav:NavigationColors,
    val others:Others,
    val shadow: CommonShadow
) {
    fun clone(
        backdrop: MutableState<Color> = mutableStateOf(this.backdrop.value),
        bottomSheetBG: MutableState<Color> = mutableStateOf(this.bottomSheetBG.value),
        core: Core = this.core.clone(),
        input: CommonInput = this.input.clone(),
        background: Background = this.background.clone(),
        nav: NavigationColors = this.nav.clone(),
        others: Others = this.others.clone(),
        shadow: CommonShadow = this.shadow.clone()
    ) = CommonColors(
        backdrop = backdrop,
        bottomSheetBG = bottomSheetBG,
        core = core,
        input = input,
        background = background,
        nav= nav,
        others = others,
        shadow = shadow
    )

    fun updateFrom(other: CommonColors) {
        backdrop.value = other.backdrop.value
        bottomSheetBG.value = other.bottomSheetBG.value
        core.updateFrom(other.core)
        input.updateFrom(other.input)
        background.updateFrom(other.background)
        nav.updateFrom(other.nav)
        others.updateFrom(other.others)
        shadow.updateFrom(other.shadow)
    }
}

data class Core(
    val onLight:OnTheme,
    val onDark:OnTheme,
    val primary:ColorSet,
    val secondary:ColorSet,
    val error:ColorSet,
    val info : ColorSet,
    val warning:ColorSet,
    val success:ColorSet

) {
    fun clone(
        onLight: OnTheme = this.onLight.clone(),
        onDark: OnTheme = this.onDark.clone(),
        primary: ColorSet = this.primary.clone(),
        secondary: ColorSet = this.secondary.clone(),
        error: ColorSet = this.error.clone(),
        info:ColorSet = this.info.clone(),
        warning: ColorSet = this.warning.clone(),
        success: ColorSet = this.success.clone()
    ) = Core(
        onLight = onLight,
        onDark = onDark,
        primary = primary,
        secondary = secondary,
        error = error,
        info = info,
        warning = warning,
        success = success
    )

    fun updateFrom(other: Core) {
        onLight.updateFrom(other.onLight)
        onDark.updateFrom(other.onDark)
        primary.updateFrom(other.primary)
        secondary.updateFrom(other.secondary)
        error.updateFrom(other.error)
        info.updateFrom(other.info)
        warning.updateFrom(other.warning)
        success.updateFrom(other.success)
    }
}

data class OnTheme(
    val textPrimary:CommonText,
    val textSecondary:CommonText,
    val textDisabled:CommonDisabledText
){
    fun clone(
        textPrimary:CommonText = this.textPrimary.clone(),
        textSecondary: CommonText = this.textSecondary.clone(),
        textDisabled: CommonDisabledText = this.textDisabled.clone()
    ) = OnTheme(
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        textDisabled = textDisabled
    )

    fun updateFrom(other: OnTheme) {
        textPrimary.updateFrom(other.textPrimary)
        textSecondary.updateFrom(other.textSecondary)
        textDisabled.updateFrom(other.textDisabled)
    }
}

data class CommonText(
    val main : MutableState<Color>,
    val contrastText:MutableState<Color>
){
    fun clone(
        main: MutableState<Color> = mutableStateOf(this.main.value),
        contrastText: MutableState<Color> = mutableStateOf(this.contrastText.value)
    ) = CommonText(
        main = main,
        contrastText = contrastText
    )

    fun updateFrom(other: CommonText) {
        main.value = other.main.value
        contrastText.value = other.contrastText.value
    }
}

data class CommonDisabledText(
    val main : MutableState<Color>
){
    fun clone(
        main: MutableState<Color> = mutableStateOf(this.main.value),
    ) = CommonDisabledText(
        main = main
    )

    fun updateFrom(other: CommonDisabledText) {
        main.value = other.main.value
    }
}

data class CommonInput(
    val onLight:Input,
    val onDark:Input
){
    fun clone(
        onLight: Input= this.onLight.clone(),
        onDark: Input= this.onDark.clone(),
    ) = CommonInput(
        onLight=onLight,
        onDark= onDark
    )

    fun updateFrom(other: CommonInput) {
        this.onLight.updateFrom(other.onLight)
        this.onDark.updateFrom(other.onDark)
    }
}

data class CommonShadow(
    val medium: MutableState<Color>,
    val large: MutableState<Color>,
    val largeInnerShadow: MutableState<Color>
){
    fun clone(
        medium: MutableState<Color> = mutableStateOf(this.medium.value),
        large: MutableState<Color> = mutableStateOf(this.large.value),
        largeInnerShadow: MutableState<Color> = mutableStateOf(this.largeInnerShadow.value),
    )= CommonShadow(
        medium= medium,
        large = large,
        largeInnerShadow = largeInnerShadow
    )

    fun updateFrom(other:CommonShadow){
        medium.value = other.medium.value
        large.value = other.large.value
        largeInnerShadow.value = other.largeInnerShadow.value
    }
}