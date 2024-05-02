package com.spares.propeller.commons.ui.theme.color

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.mutableStateOf
import com.spares.propeller.commons.ui.theme.model.color.design.*
import com.weather.app.common.ui.theme.model.color.design.Background
import com.weather.app.common.ui.theme.model.color.design.ColorSet
import com.weather.app.common.ui.theme.model.color.design.DashboardSectionColors
import com.weather.app.common.ui.theme.model.color.design.Icon
import com.weather.app.common.ui.theme.model.color.design.Input
import com.weather.app.common.ui.theme.model.color.design.NavigationColors
import com.weather.app.common.ui.theme.model.color.design.Text

object LightSkin : Skin() {

    override val textPrimary = Text(
        main = mutableStateOf(Black_200),
        contrastText = mutableStateOf(White),
    )
    override val textSecondary = Text(
        main = mutableStateOf(Gray_399),
        contrastText = mutableStateOf(White),
    )
    override val textDisabled = Text(
        main = mutableStateOf(Black_32),
        contrastText = mutableStateOf(Black_32),
    )

    override val icon = Icon(
        primary = mutableStateOf(Black_200),
        secondary = mutableStateOf(Gray_399),
        disabled = mutableStateOf(Black_32)
    )

    override val background = Background(
        paper = mutableStateOf(White),
        paperInverted = mutableStateOf(Blue_Gray_50),
        divider = mutableStateOf(Blue_Gray_40),
        backgroundOne = mutableStateOf(White),
        backgroundTwo = mutableStateOf(Gray_300),
        backgroundThree = mutableStateOf(Gray_600),
        backgroundFour = mutableStateOf(Gray_700),
        backgroundFive = mutableStateOf(Gray_800),
    )

    override val primary = ColorSet(
        light = mutableStateOf(Blue_100),
        main = mutableStateOf(Blue_200),
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

    override val dashboardSection = DashboardSectionColors(
        workOrderMain = mutableStateOf(DarkBlue_300),
        workOrderContrastText = mutableStateOf(White),
        purchaseOrderMain = mutableStateOf(Purple_100),
        purchaseOrderContrastText = mutableStateOf(White),
        stockReconMain = mutableStateOf(Blue_200),
        stockReconContrastText = mutableStateOf(White),
        equipmentInventoryMain = mutableStateOf(Pink_200),
        equipmentInventoryContrastText = mutableStateOf(White),
        loginBackground = mutableStateOf(Blue_Gray_30)
    )
    override val input = Input(
        disabledBackgroundColor = mutableStateOf(Black_12),
        outlineDefault = mutableStateOf(Black_23),
        outlineDisabled = mutableStateOf(Black_26)
    )
    override val others: Others = Others(
        quickLinkWhite = mutableStateOf(White),
        quickLinkBG = mutableStateOf(Gray_500),
        primaryOutlineButton = mutableStateOf(Blue_200),
        supplierOrderItem = mutableStateOf(Gray_400)
    )

    override val nav: NavigationColors = NavigationColors(
        linkActive = mutableStateOf(Black_100),
        linkStatic = mutableStateOf(Gray_380),
        logoActive = mutableStateOf(SkyBlue_70)
    )

    private val onColor = Black

    internal val materialColorScheme = lightColorScheme(
        surface = White,
        onSurface = Black_200,
        primary = White,
        onPrimary = onColor,
        primaryContainer = Gray_300,
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
        onError = White,
        errorContainer = Red,
        onErrorContainer = White,
    )

    override val buttonColors = getButtonColors()
    override val textFieldColors = getTextFieldColors()
    override val chips = getChipsColors()
    override val radioButton = getRadioButtonColors()
    override val checkbox = getCheckboxColors()

    override val shadow: Shadow = Shadow(
        medium = mutableStateOf(Gray_130),
        large = mutableStateOf(Gray_150),
        largeInnerShadow = mutableStateOf(Gray_200)
    )

    init {
        buttonColors.mediumEmphasis.content = primary.main
        buttonColors.mediumEmphasis.outline = primary.main
        radioButton.selected = info.main
        radioButton.unSelected = textPrimary.contrastText
    }

}