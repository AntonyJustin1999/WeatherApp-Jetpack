package com.spares.propeller.commons.ui.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.mutableStateOf
import com.spares.propeller.commons.ui.theme.model.color.design.*
import com.weather.app.common.ui.theme.model.color.design.Background
import com.weather.app.common.ui.theme.model.color.design.ColorSet
import com.weather.app.common.ui.theme.model.color.design.DashboardSectionColors
import com.weather.app.common.ui.theme.model.color.design.Icon
import com.weather.app.common.ui.theme.model.color.design.Input
import com.weather.app.common.ui.theme.model.color.design.NavigationColors
import com.weather.app.common.ui.theme.model.color.design.Text

object DarkSkin : Skin() {


    override val textPrimary = Text(
        main = mutableStateOf(White),
        contrastText = mutableStateOf(Blue_999),
    )
    override val textSecondary = Text(
        main = mutableStateOf(White_DD),
        contrastText = mutableStateOf(Blue_900),
    )
    override val textDisabled = Text(
        main = mutableStateOf(White_50),
        contrastText = mutableStateOf(White_50),
    )

    override val icon = Icon(
        primary = mutableStateOf(White),
        secondary = mutableStateOf(White_DD),
        disabled = mutableStateOf(White_50)
    )
    override val background = Background(
        paper = mutableStateOf(Blue_900),
        paperInverted = mutableStateOf(White),
        divider = mutableStateOf(White_12),
        backgroundOne = mutableStateOf(Blue_950),
        backgroundTwo = mutableStateOf(Blue_999),
        backgroundThree = mutableStateOf(Blue_Gray_100),
        backgroundFour = mutableStateOf(Blue_Gray_200),
        backgroundFive = mutableStateOf(Blue_Gray_300),
    )


    override val primary = ColorSet(
        light = mutableStateOf(Blue_200),
        main = mutableStateOf(Blue_100),
        dark = mutableStateOf(DarkBlue_400),
        contrastText = mutableStateOf(White)
    )
    override val secondary = ColorSet(
        light = mutableStateOf(Pink_100),
        main = mutableStateOf(Pink_200),
        dark = mutableStateOf(Pink_900),
        contrastText = mutableStateOf(White)
    )
    override val error = ColorSet(
        light = mutableStateOf(Red_100),
        main = mutableStateOf(Red_200),
        dark = mutableStateOf(Red_900),
        contrastText = mutableStateOf(White)
    )

    override val info = ColorSet(
        light = mutableStateOf(SkyBlue_100),
        main = mutableStateOf(SkyBlue_200),
        dark = mutableStateOf(SkyBlue_900),
        contrastText = mutableStateOf(White)
    )

    override val warning = ColorSet(
        light = mutableStateOf(Orange_100),
        main = mutableStateOf(Orange_200),
        dark = mutableStateOf(Orange_900),
        contrastText = mutableStateOf(White)
    )

    override val success = ColorSet(
        light = mutableStateOf(Green_100),
        main = mutableStateOf(Green_200),
        dark = mutableStateOf(Green_900),
        contrastText = mutableStateOf(White)
    )

    override val nav: NavigationColors = NavigationColors(
        linkActive = mutableStateOf(White),
        linkStatic = mutableStateOf(Gray_380),
        logoActive = mutableStateOf(White)
    )

    override val others: Others = Others(
        quickLinkWhite = mutableStateOf(White),
        quickLinkBG = mutableStateOf(Blue_900),
        primaryOutlineButton = mutableStateOf(White),
        supplierOrderItem = mutableStateOf(White_23)
    )

    override val dashboardSection = DashboardSectionColors(
        workOrderMain = mutableStateOf(SkyBlue_50),
        workOrderContrastText = mutableStateOf(White),
        purchaseOrderMain = mutableStateOf(Purple_50),
        purchaseOrderContrastText = mutableStateOf(White),
        stockReconMain = mutableStateOf(Blue_50),
        stockReconContrastText = mutableStateOf(White),
        equipmentInventoryMain = mutableStateOf(Pink_200),
        equipmentInventoryContrastText = mutableStateOf(White),
        loginBackground = mutableStateOf(DarkBlue_300)
    )

    override val input = Input(
        disabledBackgroundColor = mutableStateOf(White_12),
        outlineDefault = mutableStateOf(White_23),
        outlineDisabled = mutableStateOf(White_30)
    )


    private val onColor = White
    internal val materialColorScheme = darkColorScheme(
        surface = background.surface.value,
        onSurface = White,

        primary = DarkBlue_200,
        onPrimary = onColor,
        primaryContainer = DarkBlue_300,
        onPrimaryContainer = onColor,
        secondary = DarkBlue_100,
        onSecondary = onColor,
        secondaryContainer = DarkBlue_200,
        onSecondaryContainer = onColor,
        background = DarkBlue_100,
        onBackground = White,

        surfaceVariant = Gray_100,
        onSurfaceVariant = onColor,
        error = Red,
        onError = onColor,
        errorContainer = Red,
        onErrorContainer = onColor
    )

    override val buttonColors = getButtonColors()
    override val textFieldColors = getTextFieldColors()
    override val chips = getChipsColors()
    override val radioButton = getRadioButtonColors()
    override val checkbox = getCheckboxColors()

    override val shadow: Shadow = Shadow(
        medium = mutableStateOf(DarkBlue_500),
        large = mutableStateOf(Black_40),
        largeInnerShadow = mutableStateOf(Gray_250)
    )

    init {
        buttonColors.mediumEmphasis.content = primary.contrastText
        buttonColors.mediumEmphasis.outline = primary.contrastText
        radioButton.selected = primary.main
        radioButton.unSelected = icon.secondary
    }
}