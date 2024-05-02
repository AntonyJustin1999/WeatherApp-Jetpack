package com.spares.propeller.commons.ui.theme.helpers

import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.BackgroundOpacity
import androidx.compose.material.TextFieldDefaults.IconOpacity
import androidx.compose.material.TextFieldDefaults.UnfocusedIndicatorLineOpacity
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.weather.app.common.ui.theme.appThemeColors

object TextFieldDefaultsMaterial {

    @Composable
    fun textFieldColors(
        textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),
        disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),
        backgroundColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = BackgroundOpacity),
        cursorColor: Color = MaterialTheme.colorScheme.primary,
        errorCursorColor: Color = MaterialTheme.colorScheme.error,
        focusedIndicatorColor: Color =
            MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
        unfocusedIndicatorColor: Color =
            MaterialTheme.colorScheme.onSurface.copy(alpha = UnfocusedIndicatorLineOpacity),
        disabledIndicatorColor: Color = unfocusedIndicatorColor.copy(alpha = ContentAlpha.disabled),
        errorIndicatorColor: Color = MaterialTheme.colorScheme.error,
        leadingIconColor: Color =
            MaterialTheme.colorScheme.onSurface.copy(alpha = IconOpacity),
        disabledLeadingIconColor: Color = leadingIconColor.copy(alpha = ContentAlpha.disabled),
        errorLeadingIconColor: Color = leadingIconColor,
        trailingIconColor: Color =
            MaterialTheme.colorScheme.onSurface.copy(alpha = IconOpacity),
        disabledTrailingIconColor: Color = trailingIconColor.copy(alpha = ContentAlpha.disabled),
        errorTrailingIconColor: Color = MaterialTheme.colorScheme.error,
        focusedLabelColor: Color =
            MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
        unfocusedLabelColor: Color = MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.medium),
        disabledLabelColor: Color = unfocusedLabelColor.copy(ContentAlpha.disabled),
        errorLabelColor: Color = MaterialTheme.colorScheme.error,
        placeholderColor: Color = MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.medium),
        disabledPlaceholderColor: Color = placeholderColor.copy(ContentAlpha.disabled)
    ): TextFieldColors = TextFieldDefaults.textFieldColors(textColor, disabledTextColor, backgroundColor, cursorColor, errorCursorColor, focusedIndicatorColor, unfocusedIndicatorColor, disabledIndicatorColor, errorIndicatorColor, leadingIconColor, disabledLeadingIconColor, errorLeadingIconColor, trailingIconColor, disabledTrailingIconColor, errorTrailingIconColor, focusedLabelColor, unfocusedLabelColor, disabledLabelColor, errorLabelColor, placeholderColor, disabledPlaceholderColor)

    /**
     * Creates a [TextFieldColors] that represents the default input text, background and content
     * (including label, placeholder, leading and trailing icons) colors used in an
     * [OutlinedTextField].
     */
    @Composable
    fun ScnxTextFieldColors(
        textColor: Color = MaterialTheme.appThemeColors.textField.text.normal.value,
        disabledTextColor: Color = MaterialTheme.appThemeColors.textField.text.disabled.value,
        backgroundColor: Color = MaterialTheme.appThemeColors.textField.background.normal.value,
        cursorColor: Color = textColor,
        errorCursorColor: Color = textColor,
        focusedBorderColor: Color =MaterialTheme.appThemeColors.textField.border.focused.value,
        unfocusedBorderColor: Color = MaterialTheme.appThemeColors.textField.border.unfocused.value,
        disabledBorderColor: Color = MaterialTheme.appThemeColors.textField.border.disabled.value,
        errorBorderColor: Color = MaterialTheme.appThemeColors.textField.border.error.value,
        leadingIconColor: Color = MaterialTheme.appThemeColors.textField.icons.leading.value,
        disabledLeadingIconColor: Color = MaterialTheme.appThemeColors.textField.icons.disabledLeading.value,
        errorLeadingIconColor: Color = MaterialTheme.appThemeColors.textField.icons.errorLeading.value,
        trailingIconColor: Color = MaterialTheme.appThemeColors.textField.icons.trailing.value,
        disabledTrailingIconColor: Color = MaterialTheme.appThemeColors.textField.icons.disabledTrailing.value,
        errorTrailingIconColor: Color = MaterialTheme.appThemeColors.textField.icons.errorTrailing.value,
        focusedLabelColor: Color = MaterialTheme.appThemeColors.textField.label.focused.value,
        unfocusedLabelColor: Color = MaterialTheme.appThemeColors.textField.label.unfocused.value,
        disabledLabelColor: Color = MaterialTheme.appThemeColors.textField.label.disabled.value,
        errorLabelColor: Color = MaterialTheme.appThemeColors.textField.label.error.value,
        placeholderColor: Color = MaterialTheme.appThemeColors.textField.placeholder.normal.value,
        disabledPlaceholderColor: Color = MaterialTheme.appThemeColors.textField.placeholder.disabled.value
    ): TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(textColor, disabledTextColor, backgroundColor, cursorColor, errorCursorColor, focusedBorderColor, unfocusedBorderColor, disabledBorderColor, errorBorderColor, leadingIconColor, disabledLeadingIconColor, errorLeadingIconColor, trailingIconColor, disabledTrailingIconColor, errorTrailingIconColor, focusedLabelColor, unfocusedLabelColor, disabledLabelColor, errorLabelColor, placeholderColor, disabledPlaceholderColor)

    /**
     * Creates a [TextFieldColors] that represents the default input text, background and content
     * (including label, placeholder, leading and trailing icons) colors used in an
     * [OutlinedTextField] for credential type
     */
    @Composable
    fun outlinedTextFieldColorsCredentials(
        textColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.text.normal.value,
        disabledTextColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.text.disabled.value,
        backgroundColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.background.normal.value,
        placeholderColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.placeholder.normal.value,
        disabledPlaceholderColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.placeholder.disabled.value,
        focusedBorderColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.border.focused.value,
        unfocusedBorderColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.border.unfocused.value,
        disabledBorderColor: Color = MaterialTheme.appThemeColors.textField.credential.normal.border.disabled.value,
        ): TextFieldColors = ScnxTextFieldColors(
        textColor = textColor,
        disabledTextColor = disabledTextColor,
        backgroundColor = backgroundColor,
        placeholderColor = placeholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        disabledBorderColor = disabledBorderColor
    )

    /**
     * Creates a [TextFieldColors] that represents the default input text, background and content
     * (including label, placeholder, leading and trailing icons) colors used in an
     * [OutlinedTextField] for Local Search
     */
    @Composable
    fun outlinedTextFieldColorsLocalSearch(
        textColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.text.normal.value,
        disabledTextColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.text.disabled.value,
        backgroundColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.background.normal.value,
        placeholderColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.placeholder.normal.value,
        disabledPlaceholderColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.placeholder.disabled.value,
        focusedBorderColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.border.focused.value,
        unfocusedBorderColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.border.unfocused.value,
        disabledBorderColor: Color = MaterialTheme.appThemeColors.textField.localSearch.normal.border.disabled.value,
        ): TextFieldColors = ScnxTextFieldColors(

        textColor = textColor,
        disabledTextColor = disabledTextColor,
        backgroundColor = backgroundColor,
        placeholderColor = placeholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        disabledBorderColor = disabledBorderColor
    )

    /**
     * Creates a [TextFieldColors] that represents the default input text, background and content
     * (including label, placeholder, leading and trailing icons) colors used in an
     * [OutlinedTextField] for Local Search
     */
    @Composable
    fun outlinedTextFieldColorsGlobalSearch(
        textColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.text.normal.value,
        disabledTextColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.text.disabled.value,
        backgroundColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.background.normal.value,
        placeholderColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.placeholder.normal.value,
        disabledPlaceholderColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.placeholder.disabled.value,
        focusedBorderColor:Color = MaterialTheme.appThemeColors.textField.globalSearch.border.focused.value,
        unfocusedBorderColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.border.unfocused.value,
        disabledBorderColor: Color = MaterialTheme.appThemeColors.textField.globalSearch.border.disabled.value,

    ): TextFieldColors = ScnxTextFieldColors(
        textColor = textColor,
        disabledTextColor = disabledTextColor,
        backgroundColor = backgroundColor,
        placeholderColor = placeholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        disabledBorderColor = disabledBorderColor
    )



}