package com.weather.app.common.ui.components.foundations

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spares.propeller.commons.ui.theme.helpers.TextFieldDefaultsMaterial
import com.weather.app.common.ui.components.R
import com.weather.app.common.ui.theme.appThemeColors
import com.weather.app.common.ui.theme.appTypography
import com.weather.app.common.ui.theme.baseDensityIndependentPixels

enum class LabelTextFieldType{
    MANDATORY,
    NORMAL
}
enum class TextFieldBaseType{
    OUTLINED,
    FILLED
}
enum class TextFieldType {
    TEXT,
    TEXTAREA,
    USERNAME,
    PASSWORD,
    SEARCH_LOCAL,
    SEARCH_GLOBAL,
    DROPDOWN
}

enum class PaletteType {
    NORMAL,
    COMMON,
}
private const val TAG = "TextComponents"
private const val ICON_SIZE = 1.3
private val ICON_DEFAULT_HORIZONTAL_PADDING = (0.275 * baseDensityIndependentPixels).dp
private val DEFAULT_ICON_SIZE = (ICON_SIZE * baseDensityIndependentPixels).dp
@Composable
fun PropellerText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.appTypography.textFields.text
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = style
    )
}

@Composable
fun SCNXHeadlineText(
    text: String,
    style: TextStyle = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onSurface,

    ) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = text,
            style = style,
            modifier = modifier,
            textAlign = textAlign,
            color = color
        )
    }


}
/**
 * [ScnxOutlineTextField] encapsulates the Filled Text field based on Jetpack Compose's [OutlinedTextField]
 * It provides mechanism to have [type] like [TextFieldType.TEXT], [TextFieldType.TEXTAREA],
 * [TextFieldType.PASSWORD], [TextFieldType.SEARCH_LOCAL] and [TextFieldType.SEARCH_GLOBAL]
 * It can taken in parameters like [labelText], [placeholderText] , [value] for getting different texts for display
 * Can be made [readOnly] as well as [enabled] or disabled.
 * Supports  [PaletteType.NORMAL] and [PaletteType.COMMON].
 * Error state is supported by flag [isError]
 */
@Composable
fun ScnxOutlineTextField(
    type: TextFieldType = TextFieldType.TEXT,
    value: String,
    maxLines: Int = 1,
    enabled: Boolean = true,
    isError: Boolean = false,
    focusRequester: FocusRequester? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    ),
    keyboardActions: KeyboardActions = KeyboardActions(),
    labelText: String = "",
    placeholderText: String = "",
    onValueChange: (String) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false,
    textFieldColors: TextFieldColors? = null,
    textStyle: TextStyle = MaterialTheme.appTypography.textFields.text,
    paletteType: PaletteType = PaletteType.NORMAL,
    isTextPresent: MutableState<Boolean> = remember {
        mutableStateOf(value.isNotEmpty())
    },
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Left,
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value, selection = TextRange(value.length,value.length))
    ScnxOutlineTextField(
        value = textFieldValue,
        type = type,
        maxLines = maxLines,
        isError = isError,
        enabled = enabled,
        focusRequester = focusRequester,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        labelText = labelText,
        placeholderText = placeholderText,
        onValueChange = {
            textFieldValueState = it
            if (value != it.text) {
                onValueChange(it.text)
            }
        },
        interactionSource = interactionSource,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardActions = keyboardActions,
        readOnly = readOnly,
        textStyle = textStyle,
        textFieldColors = textFieldColors,
        paletteType = paletteType,
        isTextPresent = isTextPresent,
        onClick = onClick,
        textAlign = textAlign
    )

}
/**
 * [ScnxOutlineTextField] encapsulates the Filled Text field based on Jetpack Compose's [OutlinedTextField]
 * It provides mechanism to have [type] like [TextFieldType.TEXT], [TextFieldType.TEXTAREA],
 * [TextFieldType.PASSWORD], [TextFieldType.SEARCH_LOCAL] and [TextFieldType.SEARCH_GLOBAL]
 * It can taken in parameters like [labelText], [placeholderText] , [value] for getting different texts for display
 * Can be made [readOnly] as well as [enabled] or disabled.
 * Supports  [PaletteType.NORMAL] and [PaletteType.COMMON].
 * Error state is supported by flag [isError]
 */
@Composable
fun ScnxOutlineTextField(
    type: TextFieldType = TextFieldType.TEXT,
    value: TextFieldValue,
    maxLines: Int = 1,
    isError: Boolean = false,
    focusRequester: FocusRequester? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    ),
    enabled: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions(),
    labelText: String = "",
    labelTextFieldType: LabelTextFieldType = LabelTextFieldType.NORMAL,
    placeholderText: String = "",
    onValueChange: (TextFieldValue) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    labelStyle: TextStyle = MaterialTheme.appTypography.textFields.label,
    textStyle: TextStyle = MaterialTheme.appTypography.textFields.text,
    placeholderStyle: TextStyle = MaterialTheme.appTypography.textFields.placeholder,
    readOnly: Boolean = false,
    textFieldColors: TextFieldColors? = null,
    paletteType: PaletteType = PaletteType.NORMAL,
    isTextPresent: MutableState<Boolean> = remember {
        mutableStateOf(value.text.isNotEmpty())
    },
    onClick: (() -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Left,
) {
    ScnxTextField(
        baseType=TextFieldBaseType.OUTLINED,
        type=type,
        value=value,
        maxLines=maxLines,
        isError=isError,
        focusRequester = focusRequester,
        modifier=modifier,
        keyboardOptions = keyboardOptions,
        enabled = enabled,
        keyboardActions=keyboardActions,
        labelText=labelText,
        labelTextFieldType=labelTextFieldType,
        placeholderText=placeholderText,
        onValueChange=onValueChange,
        interactionSource=interactionSource,
        leadingIcon=leadingIcon,
        trailingIcon=trailingIcon,
        labelStyle=labelStyle,
        textStyle=textStyle,
        placeholderStyle=placeholderStyle,
        readOnly=readOnly,
        textFieldColors=textFieldColors,
        paletteType=paletteType,
        isTextPresent=isTextPresent,
        onClick = onClick,
        textAlign = textAlign,
    )

}
/**
 * [ScnxFilledTextField] encapsulates the Filled Text field based on Jetpack Compose's [TextField]
 * It provides mechanism to have [type] like [TextFieldType.TEXT], [TextFieldType.TEXTAREA]
 * It can taken in parameters like [labelText], [placeholderText] , [value] for getting different texts for display
 * Can be made [readOnly] as well as [enabled] or disabled.
 * Supports only [PaletteType.NORMAL] for now.
 * Also has mechanism to have additional custom elements at the bottom from calling function with the
 * help of [bottomComposable]
 * Error state is supported by flag [isError]
 */
@Composable
fun ScnxFilledTextField(
    type: TextFieldType = TextFieldType.TEXT,
    value: String,
    maxLines: Int = 1,
    enabled: Boolean = true,
    isError: Boolean = false,
    focusRequester: FocusRequester? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    ),
    keyboardActions: KeyboardActions = KeyboardActions(),
    labelText: String = "",
    labelTextFieldType: LabelTextFieldType = LabelTextFieldType.NORMAL,
    placeholderText: String = "",
    onValueChange: (String) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false,
    textFieldColors: TextFieldColors? = null,
    labelStyle: TextStyle = MaterialTheme.appTypography.design.body1Regular,
    textStyle: TextStyle = MaterialTheme.appTypography.textFields.text,
    paletteType: PaletteType = PaletteType.NORMAL,
    bottomComposable: @Composable (() -> Unit)? = null,
    isTextPresent: MutableState<Boolean> = remember {
        mutableStateOf(value.isNotEmpty())
    },
    onClick: (() -> Unit)? = null,
    isSpareDetailPage: Boolean = false,
//    isDropdownField : Boolean = false
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value, TextRange(value.length))
    ScnxFilledTextField(
        value = if(type == TextFieldType.DROPDOWN) textFieldValue else textFieldValueState,
        type = type,
        maxLines = maxLines,
        isError = isError,
        enabled = enabled,
        focusRequester = focusRequester,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        labelText = labelText,
        labelTextFieldType = labelTextFieldType,
        placeholderText = placeholderText,
        onValueChange = {
            textFieldValueState = it
            if (value != it.text) {
                onValueChange(it.text)
            }
        },
        interactionSource = interactionSource,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardActions = keyboardActions,
        readOnly = readOnly,
        textStyle = textStyle,
        textFieldColors = textFieldColors,
        paletteType = paletteType,
        bottomComposable = bottomComposable,
        isTextPresent = isTextPresent,
        labelStyle = labelStyle,
        onClick = onClick,
        isSpareDetailPage = isSpareDetailPage
    )

}

/**
 * [ScnxFilledTextField] encapsulates the Filled Text field based on Jetpack Compose's [TextField]
 * It provides mechanism to have [type] like [TextFieldType.TEXT], [TextFieldType.TEXTAREA]
 * It can taken in parameters like [labelText], [placeholderText] , [value] for getting different texts for display
 * Can be made [readOnly] as well as [enabled] or disabled.
 * Supports only [PaletteType.NORMAL] for now.
 * Also has mechanism to have additional custom elements at the bottom from calling function with the
 * help of [bottomComposable].
 * Error state is supported by flag [isError]
 */
@Composable
fun ScnxFilledTextField(
    type: TextFieldType = TextFieldType.TEXT,
    value: TextFieldValue,
    maxLines: Int = 1,
    isError: Boolean = false,
    focusRequester: FocusRequester? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    ),
    enabled: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions(),
    labelText: String = "",
    labelTextFieldType: LabelTextFieldType = LabelTextFieldType.NORMAL,
    placeholderText: String = "",
    onValueChange: (TextFieldValue) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    labelStyle: TextStyle = MaterialTheme.appTypography.design.body1Regular,
    textStyle: TextStyle = MaterialTheme.appTypography.textFields.text,
    placeholderStyle: TextStyle = MaterialTheme.appTypography.textFields.placeholder,
    readOnly: Boolean = false,
    textFieldColors: TextFieldColors? = null,
    paletteType: PaletteType = PaletteType.NORMAL,
    bottomComposable: @Composable (() -> Unit)? = null,
    isTextPresent: MutableState<Boolean> = remember {
        mutableStateOf(value.text.isNotEmpty())
    },
    onClick: (() -> Unit)? = null,
    isSpareDetailPage: Boolean = false,
) {
    val isFocused = interactionSource.collectIsFocusedAsState()

    ScnxTextField(
        baseType=TextFieldBaseType.FILLED,
        type=type,
        value=value,
        maxLines=maxLines,
        isError=isError,
        focusRequester = focusRequester,
        modifier=modifier,
        keyboardOptions = keyboardOptions,
        enabled = enabled,
        keyboardActions=keyboardActions,
        labelText=labelText,
        labelTextFieldType=labelTextFieldType,
        placeholderText=placeholderText,
        onValueChange=onValueChange,
        interactionSource=interactionSource,
        leadingIcon=leadingIcon,
        trailingIcon=trailingIcon,
        labelStyle=if(isFocused.value || isTextPresent.value){
               MaterialTheme.appTypography.design.captionRegular
        }else{
            labelStyle
        },
        textStyle=textStyle,
        placeholderStyle=placeholderStyle,
        readOnly=readOnly,
        textFieldColors=textFieldColors,
        paletteType=paletteType,
        bottomComposable=bottomComposable,
        isTextPresent=isTextPresent,
        onClick = onClick,
        isSpareDetailPage = isSpareDetailPage

    )

}

@Composable
private fun ScnxTextField(
    baseType: TextFieldBaseType,
    type: TextFieldType = TextFieldType.TEXT,
    value: TextFieldValue,
    maxLines: Int = 1,
    isError: Boolean = false,
    focusRequester: FocusRequester? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    ),
    enabled: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions(),
    labelText: String = "",
    labelTextFieldType: LabelTextFieldType = LabelTextFieldType.NORMAL,
    placeholderText: String = "",
    onValueChange: (TextFieldValue) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    labelStyle: TextStyle = MaterialTheme.appTypography.textFields.label,
    textStyle: TextStyle = MaterialTheme.appTypography.textFields.text,
    textAlign: TextAlign = TextAlign.Left,
    placeholderStyle: TextStyle = MaterialTheme.appTypography.textFields.placeholder,
    readOnly: Boolean = false,
    textFieldColors: TextFieldColors? = null,
    paletteType: PaletteType = PaletteType.NORMAL,
    bottomComposable: @Composable (() -> Unit)?=null,
    isTextPresent: MutableState<Boolean> = remember {
        mutableStateOf(value.text.isNotEmpty())
    },
    onClick: (() -> Unit)? = null,
    isSpareDetailPage: Boolean = false,

) {
    val readOnlyInput = if (!enabled) {
        false
    } else {
        readOnly
    }
    val maxLinesInput = when (type) {
        TextFieldType.TEXT -> {
            maxLines
        }
        TextFieldType.TEXTAREA -> {
            10
        }
        TextFieldType.USERNAME -> {
            maxLines
        }
        TextFieldType.PASSWORD -> {
            maxLines
        }
        TextFieldType.SEARCH_LOCAL -> {
            maxLines
        }
        TextFieldType.SEARCH_GLOBAL -> {
            maxLines
        }
        TextFieldType.DROPDOWN -> {
            maxLines
        }
    }

    val modifierInput = when (type) {
        TextFieldType.TEXT -> {
            if (focusRequester != null) {
                modifier
                    .focusRequester(focusRequester = focusRequester)
            } else {
                modifier
            }
        }
        TextFieldType.TEXTAREA -> {
            modifier.height((5 * baseDensityIndependentPixels).dp)
        }
        TextFieldType.USERNAME -> {
            modifier
        }
        TextFieldType.PASSWORD -> {
            modifier
        }
        TextFieldType.SEARCH_LOCAL -> {
            modifier
        }
        TextFieldType.SEARCH_GLOBAL -> {
            if (focusRequester != null) {
                modifier
                    .focusRequester(focusRequester = focusRequester)
            } else {
                modifier
            }
        }
        TextFieldType.DROPDOWN -> {
            modifier
        }
    }

    val shapeInput = when (type) {
        TextFieldType.TEXT -> {
            if(TextFieldBaseType.FILLED== baseType){
                RoundedCornerShape(
                    topStartPercent = 20,
                    topEndPercent = 20
                )
            }else {
                RoundedCornerShape(20)
            }
        }
        TextFieldType.TEXTAREA -> {
            if(TextFieldBaseType.FILLED== baseType){
                RoundedCornerShape(
                    topStartPercent = 20,
                    topEndPercent = 20
                )
            }else {
                RoundedCornerShape(20)
            }
        }
        TextFieldType.USERNAME -> {
            RoundedCornerShape(50)
        }
        TextFieldType.PASSWORD -> {
            RoundedCornerShape(50)
        }
        TextFieldType.SEARCH_LOCAL -> {
            RoundedCornerShape(50)
        }
        TextFieldType.SEARCH_GLOBAL -> {
            RoundedCornerShape(20)
        }
        TextFieldType.DROPDOWN -> {
            if(TextFieldBaseType.FILLED== baseType){
                RoundedCornerShape(
                    topStartPercent = 20,
                    topEndPercent = 20
                )
            }else {
                RoundedCornerShape(20)
            }
        }
    }
    val colorsInput = textFieldColors
        ?: when (type) {
            TextFieldType.TEXT -> {
                textColorForBasicTypes(
                    enabled=enabled,
                    baseType=baseType
                )
            }
            TextFieldType.TEXTAREA -> {
                textColorForBasicTypes(
                    enabled=enabled,
                    baseType=baseType
                )
            }
            TextFieldType.USERNAME -> {
                if (enabled) {
                    TextFieldDefaultsMaterial.outlinedTextFieldColorsCredentials()
                } else {
                    TextFieldDefaultsMaterial.outlinedTextFieldColorsCredentials(
                        backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value
                    )
                }
            }
            TextFieldType.PASSWORD -> {
                if (paletteType == PaletteType.NORMAL) {
                    if (enabled) {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsCredentials()
                    } else {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsCredentials(
                            backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value
                        )
                    }
                } else {
                    if (enabled) {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsCredentials(
                            textColor = MaterialTheme.appThemeColors.textField.credential.common.text.normal.value,
                            disabledTextColor = MaterialTheme.appThemeColors.textField.credential.common.text.disabled.value,
                            backgroundColor = MaterialTheme.appThemeColors.textField.credential.common.background.normal.value,
                            placeholderColor = MaterialTheme.appThemeColors.textField.credential.common.placeholder.normal.value,
                            disabledPlaceholderColor = MaterialTheme.appThemeColors.textField.credential.common.placeholder.disabled.value,
                            focusedBorderColor = MaterialTheme.appThemeColors.textField.credential.common.border.focused.value,
                            unfocusedBorderColor = MaterialTheme.appThemeColors.textField.credential.common.border.unfocused.value,
                            disabledBorderColor = MaterialTheme.appThemeColors.textField.credential.common.border.disabled.value,
                        )
                    } else {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsCredentials(
                            textColor = MaterialTheme.appThemeColors.textField.credential.common.text.normal.value,
                            disabledTextColor = MaterialTheme.appThemeColors.textField.credential.common.text.disabled.value,
                            backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value,
                            placeholderColor = MaterialTheme.appThemeColors.textField.credential.common.placeholder.normal.value,
                            disabledPlaceholderColor = MaterialTheme.appThemeColors.textField.credential.common.placeholder.disabled.value,
                            focusedBorderColor = MaterialTheme.appThemeColors.textField.credential.common.border.focused.value,
                            unfocusedBorderColor = MaterialTheme.appThemeColors.textField.credential.common.border.unfocused.value,
                            disabledBorderColor = MaterialTheme.appThemeColors.textField.credential.common.border.disabled.value,
                        )
                    }
                }
            }
            TextFieldType.SEARCH_LOCAL -> {
                if (paletteType == PaletteType.NORMAL) {
                    if (enabled) {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsLocalSearch()
                    } else {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsLocalSearch(
                            backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value
                        )
                    }
                } else {
                    if (enabled) {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsLocalSearch(
                            textColor = MaterialTheme.appThemeColors.textField.localSearch.common.text.normal.value,
                            disabledTextColor = MaterialTheme.appThemeColors.textField.localSearch.common.text.disabled.value,
                            backgroundColor = MaterialTheme.appThemeColors.textField.localSearch.common.background.normal.value,
                            placeholderColor = MaterialTheme.appThemeColors.textField.localSearch.common.placeholder.normal.value,
                            disabledPlaceholderColor = MaterialTheme.appThemeColors.textField.localSearch.common.placeholder.disabled.value,
                            focusedBorderColor = MaterialTheme.appThemeColors.textField.localSearch.common.border.focused.value,
                            unfocusedBorderColor = MaterialTheme.appThemeColors.textField.localSearch.common.border.unfocused.value,
                            disabledBorderColor = MaterialTheme.appThemeColors.textField.localSearch.common.border.disabled.value,
                        )
                    } else {
                        TextFieldDefaultsMaterial.outlinedTextFieldColorsLocalSearch(
                            textColor = MaterialTheme.appThemeColors.textField.localSearch.common.text.normal.value,
                            disabledTextColor = MaterialTheme.appThemeColors.textField.localSearch.common.text.disabled.value,
                            backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value,
                            placeholderColor = MaterialTheme.appThemeColors.textField.localSearch.common.placeholder.normal.value,
                            disabledPlaceholderColor = MaterialTheme.appThemeColors.textField.localSearch.common.placeholder.disabled.value,
                            focusedBorderColor = MaterialTheme.appThemeColors.textField.localSearch.common.border.focused.value,
                            unfocusedBorderColor = MaterialTheme.appThemeColors.textField.localSearch.common.border.unfocused.value,
                            disabledBorderColor = MaterialTheme.appThemeColors.textField.localSearch.common.border.disabled.value,
                        )
                    }
                }
            }
            TextFieldType.SEARCH_GLOBAL -> {

                TextFieldDefaultsMaterial.outlinedTextFieldColorsGlobalSearch()

            }
            TextFieldType.DROPDOWN -> {
                textColorForBasicTypes(
                    enabled=enabled,
                    baseType=baseType
                )
            }
        }
    val labelMandatoryCheck: @Composable (AnnotatedString.Builder.() -> Unit) = {
        if (labelTextFieldType == LabelTextFieldType.MANDATORY) {
            append(" *")
            addStyle(style = SpanStyle(color = MaterialTheme.appThemeColors.error.main.value), labelText.length + 1, labelText.length + 2)
        }
    }
    val labelTextInput: AnnotatedString = buildAnnotatedString { when (type) {
        TextFieldType.TEXT -> {
            append(labelText)
            labelMandatoryCheck()
        }
        TextFieldType.TEXTAREA -> {
            append(labelText)
            labelMandatoryCheck()
        }
        TextFieldType.USERNAME -> {
            append("")
        }
        TextFieldType.PASSWORD -> {
            append("")
        }
        TextFieldType.SEARCH_LOCAL -> {
            append("")
        }
        TextFieldType.SEARCH_GLOBAL -> {
            append("")
        }
        TextFieldType.DROPDOWN -> {
            append(labelText)
            labelMandatoryCheck()
        }
    } }
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }
    val isFocused = interactionSource.collectIsFocusedAsState()

    val trailingIconInput: (@Composable () -> Unit)? = when (type) {
        TextFieldType.TEXT -> {
            trailingIcon
        }
        TextFieldType.TEXTAREA -> {
            trailingIcon
        }
        TextFieldType.USERNAME -> {
            trailingIcon
        }
        TextFieldType.DROPDOWN -> {
            trailingIcon
        }
        TextFieldType.PASSWORD -> {
            if (trailingIcon == null) {
                {
                    val image = if (passwordVisible.value)
                        Icons.Filled.AccountBox
                    else
                        Icons.Filled.AccountCircle

                    // Please provide localized description for accessibility services
                    val description =
                        if (passwordVisible.value) "Hide password" else "Show password"

                    IconButton(
                        onClick = { passwordVisible.value = !passwordVisible.value },
                        modifier = Modifier.padding(end = (.75 * baseDensityIndependentPixels).dp)

                    ) {
                        Icon(
                            imageVector = image,
                            contentDescription = description,
                            tint = getTintIcon(
                                isTextPresent = isTextPresent,
                                isFocused = isFocused,
                                paletteType = paletteType,
                                type = type
                            ),
                        )
                    }
                }
            } else {
                trailingIcon
            }

        }
        TextFieldType.SEARCH_LOCAL -> {
            trailingIcon
        }
        TextFieldType.SEARCH_GLOBAL -> {
            trailingIcon
        }
    }

    val visualTransformationInput = when (type) {
        TextFieldType.TEXT -> VisualTransformation.None
        TextFieldType.TEXTAREA -> VisualTransformation.None
        TextFieldType.USERNAME -> VisualTransformation.None
        TextFieldType.PASSWORD -> {
            if (passwordVisible.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        }
        TextFieldType.SEARCH_LOCAL -> VisualTransformation.None
        TextFieldType.SEARCH_GLOBAL -> VisualTransformation.None
        TextFieldType.DROPDOWN -> VisualTransformation.None

    }

    val isSingleLine = when (type) {
        TextFieldType.TEXT -> !isSpareDetailPage
        TextFieldType.TEXTAREA -> false
        TextFieldType.USERNAME -> true
        TextFieldType.PASSWORD -> true
        TextFieldType.SEARCH_LOCAL -> true
        TextFieldType.SEARCH_GLOBAL -> true
        TextFieldType.DROPDOWN -> true
    }

    val placeholderColor = when (type) {
        TextFieldType.TEXT -> MaterialTheme.appThemeColors.textField.placeholder.normal.value
        TextFieldType.TEXTAREA -> MaterialTheme.appThemeColors.textField.placeholder.normal.value
        TextFieldType.USERNAME -> MaterialTheme.appThemeColors.textField.placeholder.normal.value
        TextFieldType.PASSWORD -> if (paletteType == PaletteType.NORMAL) {
            MaterialTheme.appThemeColors.textField.credential.normal.placeholder.disabled.value
        } else {
            MaterialTheme.appThemeColors.textField.credential.common.placeholder.disabled.value
        }
        TextFieldType.SEARCH_LOCAL -> if (paletteType == PaletteType.NORMAL) {
            MaterialTheme.appThemeColors.textField.localSearch.normal.placeholder.disabled.value
        } else {
            MaterialTheme.appThemeColors.textField.localSearch.common.placeholder.disabled.value
        }
        TextFieldType.SEARCH_GLOBAL -> MaterialTheme.appThemeColors.textField.globalSearch.placeholder.normal.value
        TextFieldType.DROPDOWN -> MaterialTheme.appThemeColors.textField.placeholder.normal.value
    }

    val label: @Composable (() -> Unit)? =
        if (type == TextFieldType.TEXT || type == TextFieldType.TEXTAREA) {
            {
                Text(
                    text = labelTextInput,
                    color = if (isError) {
                        MaterialTheme.appThemeColors.textField.label.error.value
                    } else if (isFocused.value) {
                        MaterialTheme.appThemeColors.textField.label.focused.value
                    } else {
                        MaterialTheme.appThemeColors.textField.label.unfocused.value
                    },
                    style = labelStyle
                )
            }
        } else if(baseType == TextFieldBaseType.FILLED && type == TextFieldType.DROPDOWN)
        {
            {
                Text(
                    text = labelTextInput,
                    color = if (isError) {
                        MaterialTheme.appThemeColors.textField.label.error.value
                    } else if (isFocused.value) {
                        MaterialTheme.appThemeColors.textField.label.focused.value
                    } else {
                        MaterialTheme.appThemeColors.textField.label.unfocused.value
                    },
                    style = labelStyle
                )
            }

        }
            else null



    if (onClick != null) {
        if (interactionSource.collectIsPressedAsState().value) {
            onClick.invoke()
        }
    }

    if(baseType==TextFieldBaseType.OUTLINED){
        OutlinedTextField(
            value = value,
            maxLines = maxLinesInput,
            isError = isError,
            enabled = enabled,
            modifier = modifierInput,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            colors = colorsInput,
            label = label,
            placeholder = {
                Text(
                    text = placeholderText,
                    color = placeholderColor,
                    style = placeholderStyle
                )
            },
            onValueChange = {
                isTextPresent.value = it.text.isNotEmpty()
                onValueChange.invoke(it)
            },
            interactionSource = interactionSource,
            visualTransformation = visualTransformationInput,
            shape = shapeInput,
            trailingIcon = trailingIconInput,
            leadingIcon = leadingIcon,
            textStyle = textStyle.merge(LocalTextStyle.current.copy(textAlign = textAlign)),
            readOnly = readOnlyInput,
            singleLine = isSingleLine,
        )
    }else{

        Column {
            TextField(
                value = value,
                maxLines = maxLinesInput,
                isError = isError,
                enabled = enabled,
                modifier = modifierInput,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                colors = colorsInput,
                label = label,
                placeholder = {
                    Text(
                        text = placeholderText,
                        color = placeholderColor,
                        style = placeholderStyle
                    )
                },
                onValueChange = {
                    isTextPresent.value = it.text.isNotEmpty()
                    onValueChange.invoke(it)
                },
                interactionSource = interactionSource,
                visualTransformation = visualTransformationInput,
                shape = shapeInput,
                trailingIcon = trailingIconInput,
                leadingIcon = leadingIcon,
                textStyle = textStyle,
                readOnly = readOnlyInput,
                singleLine = isSingleLine
            )
            bottomComposable?.let{
                Row (modifier = Modifier){
                    it.invoke()
                }
            }
        }


    }

}

@Composable
fun BottomTextsWithIcon(
    modifier: Modifier = Modifier,
    helperTextModifier: Modifier = Modifier,
    helperText: String? = null,
    helperTextStyle: TextStyle = MaterialTheme.appTypography.design.captionRegular,
    helperTextColor: MutableState<Color> = MaterialTheme.appThemeColors.textDisabled.main,
    iconResId: Int? = null,
    iconWidth: Dp = (0.75 * baseDensityIndependentPixels).dp,
    iconHeight: Dp = (0.75 * baseDensityIndependentPixels).dp,
    iconTint: Color = MaterialTheme.appThemeColors.error.main.value,
    counterText: String? = null,
    counterTextStyle: TextStyle = MaterialTheme.appTypography.design.captionRegular,
    counterTextColor: MutableState<Color> = MaterialTheme.appThemeColors.textDisabled.main,
    isErrorForHelper: Boolean = false,
    isErrorForCounter: Boolean = false,

    ){
    Row(
        modifier= modifier
            .padding(
                top = (0.4 * baseDensityIndependentPixels).dp,
                start = (0.9 * baseDensityIndependentPixels).dp,
                end = (0.9 * baseDensityIndependentPixels).dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        val helperTextColorStateful = if(!isErrorForHelper){
            helperTextColor
        }else{
            MaterialTheme.appThemeColors.error.main
        }

        val counterTextColorStateful = if(!isErrorForCounter){
            counterTextColor
        }else{
            MaterialTheme.appThemeColors.error.main
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            iconResId?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "Icon",
                    tint = iconTint,
                    modifier = Modifier
                        .width(iconWidth)
                        .height(iconHeight)
                )
                Spacer(
                    modifier = Modifier.width((0.25 * baseDensityIndependentPixels).dp)
                )
            }

            helperText?.let{
                Text(
                    modifier=helperTextModifier,
                    text=it,
                    style=helperTextStyle,
                    color=helperTextColorStateful.value
                )
            }

        }
        Row(
            horizontalArrangement = Arrangement.End
        ){
            counterText?.let{
                Text(
                    text=it,
                    style=counterTextStyle,
                    color=counterTextColorStateful.value
                )
            }

        }

    }

}

@Composable
fun getFilledTintIconColor(
    isError: Boolean = false,
    isDisabled: Boolean = false
):Color {
    return if (isError) {
        MaterialTheme.appThemeColors.error.main.value
    } else if(isDisabled){
        MaterialTheme.appThemeColors.textDisabled.main.value
    } else{
        MaterialTheme.appThemeColors.textDisabled.main.value
    }
}


@Composable
fun getTintIcon(
    isTextPresent: State<Boolean>,
    isFocused: State<Boolean>,
    isError: Boolean = false,
    paletteType: PaletteType,
    type: TextFieldType
): Color {
    if (type == TextFieldType.SEARCH_LOCAL || type == TextFieldType.PASSWORD) {
        return if (paletteType == PaletteType.NORMAL) {
            if (isFocused.value || isTextPresent.value) {
                MaterialTheme.appThemeColors.textSecondary.main.value
            } else {
                MaterialTheme.appThemeColors.textDisabled.main.value
            }
        } else {
            if (isFocused.value || isTextPresent.value) {
               MaterialTheme.appThemeColors.common.core.onLight.textSecondary.main.value
            } else {
                MaterialTheme.appThemeColors.common.core.onLight.textDisabled.main.value
            }
        }
    } else {
        return if (isError) {
            MaterialTheme.appThemeColors.common.core.error.main.value
        } else if (isFocused.value || isTextPresent.value) {
            MaterialTheme.appThemeColors.common.core.onDark.textSecondary.main.value
        } else {
            MaterialTheme.appThemeColors.common.core.onDark.textDisabled.main.value
        }

    }
}

@Composable
fun TextIconButton(
    modifier: Modifier= Modifier,
    onClick: () -> Unit = {  },
    iconSize :Dp= DEFAULT_ICON_SIZE,
    painter: Painter =painterResource(id = com.weather.app.common.ui.propellericons.R.drawable.ic_search),
    contentDescription :String= "",
    tint: Color = LocalContentColor.current
){
    IconButton(
            modifier = modifier.padding(
                start = ICON_DEFAULT_HORIZONTAL_PADDING
            ),
            onClick = onClick) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painter,
                contentDescription = contentDescription,
                tint = tint
            )
    }
}

@Composable
fun getLabelComposableText(text: @Composable () -> Unit) {
    text()
}

@Preview(showBackground = true)
@Composable
fun PreviewPropellerOutlineTextField() {

    val interactionState = remember { MutableInteractionSource() }
Column {
    ScnxOutlineTextField(
        value = TextFieldValue(""),
        isError = false,
        labelText = "email or username or phone",
        placeholderText = "abc@gmail.com",
        onValueChange = {},
        interactionSource = interactionState,
        focusRequester = remember {
            FocusRequester()
        }
    )

    ScnxFilledTextField(
        value = TextFieldValue(""),
        isError = false,
        labelText = "email or username or phone",
        placeholderText = "abc@gmail.com",
        onValueChange = {},
        interactionSource = interactionState,
        focusRequester = remember {
            FocusRequester()
        }
    )
}

}

@Composable
private fun textColorForBasicTypes(
    enabled: Boolean,
    baseType: TextFieldBaseType
): TextFieldColors {
    return if (enabled) {
        if(baseType == TextFieldBaseType.OUTLINED){
            TextFieldDefaultsMaterial.ScnxTextFieldColors()
        }else{
            TextFieldDefaultsMaterial.ScnxTextFieldColors(
                disabledTextColor = MaterialTheme.appThemeColors.textDisabled.main.value,
                unfocusedBorderColor = MaterialTheme.appThemeColors.input.outlineDefault.value
            )
        }
    } else {
        if(baseType == TextFieldBaseType.OUTLINED){
            TextFieldDefaultsMaterial.ScnxTextFieldColors(
                backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value
            )
        }else{
            TextFieldDefaultsMaterial.ScnxTextFieldColors(
                backgroundColor = MaterialTheme.appThemeColors.textField.background.disabled.value,
                disabledTextColor = MaterialTheme.appThemeColors.textDisabled.main.value,
                unfocusedBorderColor = MaterialTheme.appThemeColors.input.outlineDefault.value
            )
        }

    }
}

