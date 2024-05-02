package com.weather.app.common.ui.widgets

import android.graphics.drawable.ColorDrawable
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.window.Dialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.spares.propeller.commons.ui.theme.helpers.getSpanStyleBody1Bold
import com.spares.propeller.commons.ui.theme.helpers.getSpanStyleBody1Regular
import com.weather.app.common.ui.components.foundations.ButtonItems
import com.weather.app.common.ui.components.foundations.ScnxButton
import com.weather.app.common.ui.theme.appThemeColors
import com.weather.app.common.ui.theme.appTypography
import com.weather.app.common.ui.theme.baseDensityIndependentPixels
import com.weather.app.common.ui.theme.roundedCornerShapeSize

private val CONTENT_PADDING = (1.5 * baseDensityIndependentPixels).dp
private val TITLE_PADDING_BOTTOM = (0.75 * baseDensityIndependentPixels).dp
private val BOTTOM_HEIGHT = (5.5 * baseDensityIndependentPixels).dp
private val CORNER_RADIUS = (1 * baseDensityIndependentPixels).dp
private val ICON_SIZE = (1.25 * baseDensityIndependentPixels).dp
private val ICON_PADDING = (0.625 * baseDensityIndependentPixels).dp
private val ICON_PADDING_TOP = (0.125 * baseDensityIndependentPixels).dp
private val COLUMN_PADDING = (0.5 * baseDensityIndependentPixels).dp
private val COMPONENT_GROUP_HEIGHT = (36 * baseDensityIndependentPixels).dp
private const val MODAL_PADDING = (2.5 * baseDensityIndependentPixels)
private const val MODAL_ALERT_PADDING = (1.5 * baseDensityIndependentPixels)
private val CARD_ELEVATION = (0.5 * baseDensityIndependentPixels).dp
private val CARD_PADDING_VERTICAL = (2 * baseDensityIndependentPixels).dp
private val CARD_PADDING_HORIZONTAL = (2 * baseDensityIndependentPixels).dp
private val ROUNDED_CORNER_SHAPE_SIZE = roundedCornerShapeSize.dp
private val BOTTOM_HEIGHT_INVALID = (8 * baseDensityIndependentPixels).dp

enum class SCNXTitleType {
    NONE,
    ERROR,
    SUCCESS,
    INFO,
    WARNING
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WeatherModal(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean>,
    title: String,
    titleColor: Color = MaterialTheme.appThemeColors.textPrimary.main.value,
    titleStyle: TextStyle = MaterialTheme.appTypography.design.h2Bold,
    titleType: SCNXTitleType = SCNXTitleType.NONE,
    titleModifier: Modifier = Modifier,
    description: String? = null,
    description1: String = "",
    reportType : String = "",
    notes: String = "",
    descriptionPlaceHolderText: String? = null,
    isDesPlaceholderTextBold: Boolean = true,
    isEnableScrollComponentComposable: Boolean = true,
    componentComposableOne: (@Composable () -> Unit)? = null,
    componentComposableTwo: (@Composable () -> Unit)? = null,
    componentComposableThree: (@Composable () -> Unit)? = null,
    buttonList: List<ButtonItems>? = null,
    buttonListModifier: Modifier = Modifier,
    defaultPaddingModal: Dp = CONTENT_PADDING,
    dismissOnBackPress: Boolean = true,
    dismissOnClickOutside: Boolean = true,
    fontSize: TextUnit = TextUnit.Unspecified,
    type: String = "",
    screenType:String = ""
) {
    val titleIcon = when (titleType) {
        SCNXTitleType.SUCCESS -> com.weather.app.common.ui.propellericons.R.drawable.ic_success
        SCNXTitleType.NONE -> null
        else -> com.weather.app.common.ui.propellericons.R.drawable.ic_warning
    }
    val titleIconColor = when (titleType) {
        SCNXTitleType.ERROR -> MaterialTheme.appThemeColors.error.main.value
        SCNXTitleType.INFO -> MaterialTheme.appThemeColors.info.main.value
        SCNXTitleType.SUCCESS -> MaterialTheme.appThemeColors.success.main.value
        SCNXTitleType.WARNING -> MaterialTheme.appThemeColors.warning.main.value
        else -> MaterialTheme.appThemeColors.info.main.value
    }
    Dialog(
        onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = dismissOnClickOutside,
        ),
    ) {
        if(screenType !=""){
            Surface(
                modifier = modifier
                    .padding(horizontal = MODAL_ALERT_PADDING.dp)
                    .fillMaxWidth()
                    .heightIn(max = (LocalConfiguration.current.screenHeightDp - (2 * MODAL_PADDING)).dp)
                    .clip(RoundedCornerShape(CORNER_RADIUS))
                    .background(
                        color = Color.Transparent
                    )
            ) {
                Column(modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS))
                    .background(
                        color = MaterialTheme.appThemeColors.common.core.error.main.value.copy(alpha = 0.30f)
                    )) {
                    Column(modifier = Modifier.padding(
                        top = defaultPaddingModal,
                        start = defaultPaddingModal,
                        end = defaultPaddingModal
                    )) {
                        Row(
                            modifier = titleModifier
                                .padding(bottom = TITLE_PADDING_BOTTOM),
                            verticalAlignment = Alignment.Top,
                        ) {
                            titleIcon?.let {
                                Icon(
                                    modifier = Modifier
                                        .padding(end = ICON_PADDING, top = ICON_PADDING_TOP)
                                        .size(size = ICON_SIZE),
                                    painter = painterResource(id = titleIcon),
                                    contentDescription = "errorIcon",
                                    tint = titleIconColor
                                )
                            }
                            Text(
                                text = title,
                                style = titleStyle,
                                color = titleColor,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        ScnxDescriptionText(
                            modifier = Modifier.padding(bottom = TITLE_PADDING_BOTTOM),
                            description = description,
                            placeHolderText = descriptionPlaceHolderText,
                            isPlaceholderTextBold = isDesPlaceholderTextBold
                        )
                        if (description1.isNotEmpty()) {
                            ScnxDescriptionText(
                                modifier = Modifier,
                                description = reportType,
                                placeHolderText = descriptionPlaceHolderText,
                                isPlaceholderTextBold = isDesPlaceholderTextBold
                            )
                            Text(
                                text = description1,
                                color = Color.Gray,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                            Spacer(modifier = Modifier.padding(15.dp))
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                text = notes,
                                color = Color.Gray,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(max = COMPONENT_GROUP_HEIGHT).run {
                                    if (isEnableScrollComponentComposable)
                                        this.verticalScroll(
                                            rememberScrollState()
                                        )
                                    else this
                                },
                            verticalArrangement = Arrangement.spacedBy(space = COLUMN_PADDING)
                        ) {
                            componentComposableOne?.invoke()
                            componentComposableTwo?.invoke()
                            componentComposableThree?.invoke()
                        }
                        buttonList?.let {
                            Row(
                                modifier = buttonListModifier
                                    .fillMaxWidth()
                                    .requiredHeight(if (type != "CREATE") BOTTOM_HEIGHT else BOTTOM_HEIGHT_INVALID),
                                horizontalArrangement = if (it.size >= 3) Arrangement.SpaceBetween else Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (it.size >= 3) {
                                    ScnxButton(
                                        buttonText = it[0].buttonText,
                                        emphasis = it[0].emphasis,
                                        enabled = it[0].enabled,
                                        colorScheme = it[0].colorScheme,
                                        onClick = it[0].onClick,
                                    )
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    it.takeLast(2).forEach { item ->
                                        ScnxButton(
                                            modifier = Modifier.padding(start = TITLE_PADDING_BOTTOM),
                                            buttonText = item.buttonText,
                                            emphasis = item.emphasis,
                                            enabled = item.enabled,
                                            colorScheme = item.colorScheme,
                                            onClick = item.onClick,
                                            icon = item.icon,
                                            fontSize = fontSize
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }else {
            Surface(
                modifier = modifier
                    .padding(horizontal = MODAL_PADDING.dp)
                    .fillMaxWidth()
                    .heightIn(max = (LocalConfiguration.current.screenHeightDp - (2 * MODAL_PADDING)).dp)
                    .clip(RoundedCornerShape(CORNER_RADIUS))
                    .background(color = MaterialTheme.appThemeColors.background.paper.value)
                    .padding(
                        top = defaultPaddingModal,
                        start = defaultPaddingModal,
                        end = defaultPaddingModal
                    )
            ) {
                Column(modifier = Modifier.background(color = MaterialTheme.appThemeColors.background.paper.value)) {
                    Row(
                        modifier = titleModifier
                            .padding(bottom = TITLE_PADDING_BOTTOM),
                        verticalAlignment = Alignment.Top,
                    ) {
                        titleIcon?.let {
                            Icon(
                                modifier = Modifier
                                    .padding(end = ICON_PADDING, top = ICON_PADDING_TOP)
                                    .size(size = ICON_SIZE),
                                painter = painterResource(id = titleIcon),
                                contentDescription = "errorIcon",
                                tint = titleIconColor
                            )
                        }
                        Text(
                            text = title,
                            style = titleStyle,
                            color = titleColor,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    ScnxDescriptionText(
                        modifier = Modifier.padding(bottom = TITLE_PADDING_BOTTOM),
                        description = description,
                        placeHolderText = descriptionPlaceHolderText,
                        isPlaceholderTextBold = isDesPlaceholderTextBold
                    )
                    if (description1.isNotEmpty()) {
                        ScnxDescriptionText(
                            modifier = Modifier,
                            description = reportType,
                            placeHolderText = descriptionPlaceHolderText,
                            isPlaceholderTextBold = isDesPlaceholderTextBold
                        )
                        Text(
                            text = description1,
                            color = Color.Gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Spacer(modifier = Modifier.padding(15.dp))
                        Text(
                            modifier = Modifier.padding(bottom = 10.dp),
                            text = notes,
                            color = Color.Gray,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = COMPONENT_GROUP_HEIGHT).run {
                                if (isEnableScrollComponentComposable)
                                    this.verticalScroll(
                                        rememberScrollState()
                                    )
                                else this
                            },
                        verticalArrangement = Arrangement.spacedBy(space = COLUMN_PADDING)
                    ) {
                        componentComposableOne?.invoke()
                        componentComposableTwo?.invoke()
                        componentComposableThree?.invoke()
                    }
                    buttonList?.let {
                        Row(
                            modifier = buttonListModifier
                                .fillMaxWidth()
                                .requiredHeight(if (type != "CREATE") BOTTOM_HEIGHT else BOTTOM_HEIGHT_INVALID),
                            horizontalArrangement = if (it.size >= 3) Arrangement.SpaceBetween else Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (it.size >= 3) {
                                ScnxButton(
                                    buttonText = it[0].buttonText,
                                    emphasis = it[0].emphasis,
                                    enabled = it[0].enabled,
                                    colorScheme = it[0].colorScheme,
                                    onClick = it[0].onClick,
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                it.takeLast(2).forEach { item ->
                                    ScnxButton(
                                        modifier = Modifier.padding(start = TITLE_PADDING_BOTTOM),
                                        buttonText = item.buttonText,
                                        emphasis = item.emphasis,
                                        enabled = item.enabled,
                                        colorScheme = item.colorScheme,
                                        onClick = item.onClick,
                                        icon = item.icon,
                                        fontSize = fontSize
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Create a text with multiple styles
 *
 * @param description description text that can include place holder text format like "%s"
 * @param placeHolderText a part of description text, usually it has bold style
 * @param isPlaceholderTextBold this determine the place holder text style is bold or not
 * @param modifier optional [Modifier] for this component
 */
@Composable
fun ScnxDescriptionText(
    modifier: Modifier = Modifier,
    description: String?,
    placeHolderText: String? = null,
    isPlaceholderTextBold: Boolean = true,
    maxLines: Int = 5,
) {
    description?.let {
        // set text style for description
        val spanStyles = mutableListOf(
            AnnotatedString.Range(
                getSpanStyleBody1Regular(color = MaterialTheme.appThemeColors.textPrimary.main.value),
                start = 0,
                end = description.length
            )
        )

        // check and add place holder text style is bold or not
        placeHolderText?.let {
            if (isPlaceholderTextBold) {
                val placeHolderStartIndex = description.indexOf(placeHolderText)
                if (placeHolderStartIndex >= 0) {
                    spanStyles.add(
                        AnnotatedString.Range(
                            getSpanStyleBody1Bold(color = MaterialTheme.appThemeColors.textPrimary.main.value),
                            start = placeHolderStartIndex,
                            end = placeHolderStartIndex + placeHolderText.length
                        )
                    )
                }
            }
        }
        Text(
            modifier = modifier,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            text = AnnotatedString(text = description, spanStyles = spanStyles)
        )
    }
}
