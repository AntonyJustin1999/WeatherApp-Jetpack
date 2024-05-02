package com.spares.propeller.commons.ui.theme.type

import androidx.compose.ui.text.TextStyle

data class DesignTypography(
    val h1Bold:TextStyle,
    val h1Black:TextStyle,
    val h1SemiBold:TextStyle,
    val h1Medium:TextStyle,
    val h2Bold:TextStyle,
    val h2Black:TextStyle,
    val h2SemiBold:TextStyle,
    val h2Medium:TextStyle,
    val h3Bold:TextStyle,
    val h3Black:TextStyle,
    val h3SemiBold:TextStyle,
    val h3Medium:TextStyle,
    val h4Bold:TextStyle,
    val h4Black:TextStyle,
    val h4SemiBold:TextStyle,
    val h4Medium:TextStyle,
    val overLineBold:TextStyle,
    val overLineBlack:TextStyle,
    val overLineSemiBold:TextStyle,
    val overLineMedium:TextStyle,
    val overLine:TextStyle = overLineMedium,
    val buttonBold:TextStyle,
    val buttonBlack:TextStyle,
    val buttonSemiBold:TextStyle,
    val buttonMedium:TextStyle,
    val button:TextStyle = buttonSemiBold,
    val body1Regular:TextStyle,
    val body1Bold:TextStyle,
    val body1Italic:TextStyle,
    val body1:TextStyle = body1Regular,
    val body2Regular:TextStyle,
    val body2Bold:TextStyle,
    val body2Italic:TextStyle,
    val body2:TextStyle = body2Regular,
    val captionRegular:TextStyle,
    val captionBold:TextStyle,
    val captionItalic:TextStyle,
    val caption : TextStyle = captionRegular,
    val selectBottomSheetOptionRegular:TextStyle,
    val selectBottomSheetOptionBold:TextStyle,
    val selectBottomSheetOptionItalic:TextStyle,
    val selectBottomSheetOption:TextStyle = selectBottomSheetOptionRegular,
    val tabCounterRegular:TextStyle,
    val tabCounterBold:TextStyle,
    val tabCounterItalic:TextStyle,
    val tabCounter:TextStyle = tabCounterBold,
    val valueStepperRegular:TextStyle,
    val valueStepperBold:TextStyle,
    val valueStepperItalic:TextStyle,
    val valueStepper:TextStyle = valueStepperRegular,
    val badgeRegular:TextStyle,
    val badgeBold:TextStyle,
    val badgeItalic:TextStyle,
    val badge:TextStyle = badgeRegular
)

data class ButtonTypography(
    val text:TextStyle
)

data class ChipsTypography(
    val text:TextStyle
)

data class AnchorTabTypography(
    val number: TextStyle,
    val text: TextStyle,
    val name: TextStyle
)

data class FilterTypography(
    val text: TextStyle,
    val badgeNumber: TextStyle
)

data class BadgesTypography(
    val text: TextStyle,
)

data class NativeTabTypography(
    val text: TextStyle,
    val badge: TextStyle
)

data class SectionCounterTypography(
    val text: TextStyle,
)

data class QtyCounterTypography(
    val text: TextStyle,
)

data class TextFieldTypography(
    val label : TextStyle,
    val text : TextStyle,
    val placeholder: TextStyle,
    val dropdownText:TextStyle,
    val multiSelectDropdownText:TextStyle,
    val multiSelectDropdownChip:TextStyle
)

data class CheckboxTypography(
    val text : TextStyle
)

data class RadioButtonTypography(
    val text : TextStyle
)