package com.spares.propeller.commons.ui.theme.color

import androidx.compose.runtime.mutableStateOf
import com.spares.propeller.commons.ui.theme.model.color.component.*
import com.spares.propeller.commons.ui.theme.model.color.design.*
import com.weather.app.common.ui.theme.model.color.ColorOpacities
import com.weather.app.common.ui.theme.model.color.design.Background
import com.weather.app.common.ui.theme.model.color.design.ColorSet
import com.weather.app.common.ui.theme.model.color.design.CommonColors
import com.weather.app.common.ui.theme.model.color.design.CommonDisabledText
import com.weather.app.common.ui.theme.model.color.design.CommonInput
import com.weather.app.common.ui.theme.model.color.design.CommonShadow
import com.weather.app.common.ui.theme.model.color.design.CommonText
import com.weather.app.common.ui.theme.model.color.design.Core
import com.weather.app.common.ui.theme.model.color.design.DashboardSectionColors
import com.weather.app.common.ui.theme.model.color.design.Icon
import com.weather.app.common.ui.theme.model.color.design.Input
import com.weather.app.common.ui.theme.model.color.design.NavigationColors
import com.weather.app.common.ui.theme.model.color.design.OnTheme
import com.weather.app.common.ui.theme.model.color.design.Text


abstract class Skin {


    internal abstract val textPrimary: Text
    internal abstract val textSecondary: Text
    internal abstract val textDisabled: Text

    internal abstract val icon: Icon
    internal abstract val input: Input
    internal abstract val background: Background
    internal abstract val primary: ColorSet
    internal abstract val secondary: ColorSet
    internal abstract val error: ColorSet
    internal abstract val info: ColorSet
    internal abstract val warning: ColorSet
    internal abstract val success: ColorSet
    internal abstract val nav: NavigationColors
    internal abstract val others: Others

    internal abstract val dashboardSection: DashboardSectionColors

    internal abstract val buttonColors: ButtonColors
    internal abstract val textFieldColors: TextFieldColors
    internal abstract val chips: ChipsColors
    internal abstract val radioButton: RadioButtonColors
    internal abstract val checkbox: CheckboxColors
    internal abstract val shadow: Shadow

    internal val common = CommonColors(
        backdrop = mutableStateOf(Black_199),
        bottomSheetBG = mutableStateOf(Gray_350),
        core = Core(
            onLight = OnTheme(
                textPrimary = CommonText(
                    main = mutableStateOf(Black_200),
                    contrastText = mutableStateOf(White),
                ),
                textSecondary = CommonText(
                    main = mutableStateOf(Gray_399),
                    contrastText = mutableStateOf(White),
                ),
                textDisabled = CommonDisabledText(
                    main = mutableStateOf(Black_32)
                )
            ),
            onDark = OnTheme(
                textPrimary = CommonText(
                    main = mutableStateOf(White),
                    contrastText = mutableStateOf(Blue_999),
                ),
                textSecondary = CommonText(
                    main = mutableStateOf(White_DD),
                    contrastText = mutableStateOf(Blue_999),
                ),
                textDisabled = CommonDisabledText(
                    main = mutableStateOf(White_50)
                )
            ),
            primary = ColorSet(
                main = mutableStateOf(Blue_100),
                light = mutableStateOf(Blue_200),
                dark= mutableStateOf(DarkBlue_400),
                contrastText = mutableStateOf(White)
            ),
            secondary = ColorSet(
                main = mutableStateOf(Pink_200),
                light = mutableStateOf(Pink_100),
                dark = mutableStateOf(Pink_900),
                contrastText = mutableStateOf(White)
            ),
            error = ColorSet(
                light = mutableStateOf(Red_100),
                main = mutableStateOf(Red_200),
                dark = mutableStateOf(Red_900),
                contrastText = mutableStateOf(White)
            ),
            info = ColorSet(
                light = mutableStateOf(SkyBlue_100),
                main = mutableStateOf(SkyBlue_200),
                dark = mutableStateOf(SkyBlue_900),
                contrastText = mutableStateOf(White)
            ),
            warning = ColorSet(
                light = mutableStateOf(Orange_100),
                main = mutableStateOf(Orange_200),
                dark = mutableStateOf(Orange_900),
                contrastText = mutableStateOf(White)
            ),
            success = ColorSet(
                light = mutableStateOf(Green_100),
                main = mutableStateOf(Green_200),
                dark = mutableStateOf(Green_900),
                contrastText = mutableStateOf(White)
            ),

            ),
        input = CommonInput(
            onDark = Input(
                outlineDefault = mutableStateOf(White_23),
                outlineDisabled = mutableStateOf(White_30),
                disabledBackgroundColor = mutableStateOf(White_12),
            ),
            onLight = Input(
                outlineDefault = mutableStateOf(Black_23),
                outlineDisabled = mutableStateOf(Black_26),
                disabledBackgroundColor = mutableStateOf(Black_12),
            )
        ),
        background = Background(
            paper = mutableStateOf(Blue_900),
            paperInverted = mutableStateOf(White),
            divider = mutableStateOf(White_12),
            backgroundOne = mutableStateOf(Blue_950),
            backgroundTwo = mutableStateOf(Blue_999),
            backgroundThree = mutableStateOf(Blue_Gray_100),
            backgroundFour = mutableStateOf(Blue_Gray_200),
            backgroundFive = mutableStateOf(Blue_Gray_300),
        ),
        others = Others(
            quickLinkWhite = mutableStateOf(White),
            quickLinkBG = mutableStateOf(Blue_Gray_50),
            primaryOutlineButton = mutableStateOf(White),
            supplierOrderItem = mutableStateOf(Gray_400)
        ),
        nav = NavigationColors(
            linkActive = mutableStateOf(White),
            linkStatic = mutableStateOf(Gray_380),
            logoActive = mutableStateOf(White)
        ),
        shadow = CommonShadow(
            medium = mutableStateOf(DarkBlue_500),
            large = mutableStateOf(Black_40),
            largeInnerShadow = mutableStateOf(Gray_250)
        )
    )

    fun getCheckboxColors() = CheckboxColors(
        text = textPrimary.main,
        disabledText = textDisabled.main,
        checkedBorder = primary.main,
        checkedBox = background.surface,
        checkedCheckmark = primary.main,
        uncheckedCheckmark = mutableStateOf(primary.main.value.copy(alpha = 0f)),
        uncheckedBox = background.surface,
        disabledCheckedBox = input.disabledBackgroundColor,
        disabledUncheckedBox = input.disabledBackgroundColor,
        disabledIndeterminateBox = input.disabledBackgroundColor,
        uncheckedBorder = icon.secondary,
        disabledBorder = icon.disabled,
        disabledIndeterminateBorder = icon.secondary,
    )

    fun getRadioButtonColors() = RadioButtonColors(
        text = textPrimary.main,
        selected = info.main, // This will be overriden
        unSelected = icon.secondary,//This will be overriden
        disabled = input.disabledBackgroundColor,
        disabledText = textDisabled.main
    )

    fun getTextFieldColors() = TextFieldColors(
        text = TextFieldText(
            normal = textPrimary.main,
            disabled = background.paper
        ),
        background = TextFieldBackground(
            normal = background.surface,
            disabled = input.disabledBackgroundColor
        ),
        cursor = TextFieldCursor(
            normal = textPrimary.main,
            error = error.main
        ),
        border = TextFieldBorder(
            focused = primary.main,
            unfocused = textDisabled.main,
            disabled = textDisabled.main,
            error = error.main
        ),
        icons = TextFieldIcons(
            leading = textDisabled.main,
            errorLeading = textDisabled.main,
            trailing = textDisabled.main,
            disabledTrailing = textDisabled.main,
            errorTrailing = textDisabled.main,
            disabledLeading = textDisabled.main
        ),
        label = TextFieldLabel(
            disabled = textDisabled.main,
            label = textDisabled.main,
            focused = primary.main,
            unfocused = textDisabled.main,
            error = error.main,
        ),
        placeholder = TextFieldPlaceholder(
            normal = textDisabled.main,
            disabled = textDisabled.main
        ),
        credential = Credentials(
            normal = CredentialsPalette(
                text = TextFieldText(
                    normal = textPrimary.main,
                    disabled = textDisabled.main,
                ),
                placeholder = TextFieldPlaceholder(
                    normal = textDisabled.main,
                    disabled = textDisabled.main,
                ),
                background = TextFieldBackground(
                    normal = background.paper,
                    disabled = input.disabledBackgroundColor
                ),
                border = TextFieldBorder(
                    focused = primary.main,
                    unfocused = input.outlineDefault,
                    disabled = mutableStateOf(Transparent),
                    error = error.main
                )
            ),
            common = CredentialsPalette(
                text = TextFieldText(
                    normal = common.core.onLight.textPrimary.main,
                    disabled = common.core.onLight.textDisabled.main,
                ),
                placeholder = TextFieldPlaceholder(
                    normal = common.core.onLight.textSecondary.main,
                    disabled = common.core.onLight.textDisabled.main,
                ),
                background = TextFieldBackground(
                    normal = common.background.paperInverted,
                    disabled = input.disabledBackgroundColor
                ),
                border = TextFieldBorder(
                    focused = common.core.primary.main,
                    unfocused = mutableStateOf(Transparent),
                    disabled = mutableStateOf(Transparent),
                    error = mutableStateOf(Transparent)
                )
            )
        ),
        localSearch = LocalSearch(
            normal = LocalSearchPalette(
                text = TextFieldText(
                    normal = textPrimary.main,
                    disabled = textDisabled.main
                ),
                placeholder = TextFieldPlaceholder(
                    normal = textDisabled.main,
                    disabled = textDisabled.main
                ),
                background = TextFieldBackground(
                    normal = background.paper,
                    disabled = input.disabledBackgroundColor
                ),
                icons = TextFieldIcons(
                    leading = textSecondary.main,
                    disabledLeading = textSecondary.main,
                    errorLeading = textSecondary.main,
                    trailing = textSecondary.main,
                    disabledTrailing = textSecondary.main,
                    errorTrailing = textSecondary.main
                ),
                border = TextFieldBorder(
                    focused = primary.main,
                    unfocused = input.outlineDefault,
                    disabled = mutableStateOf(Transparent),
                    error = error.main
                )
            ),
            common = LocalSearchPalette(
                text = TextFieldText(
                    normal = common.core.onLight.textPrimary.main,
                    disabled = common.core.onLight.textDisabled.main,
                ),
                placeholder = TextFieldPlaceholder(
                    normal = common.core.onLight.textSecondary.main,
                    disabled = common.core.onLight.textDisabled.main,
                ),
                background = TextFieldBackground(
                    normal = common.background.paperInverted,
                    disabled = input.disabledBackgroundColor
                ),
                icons = TextFieldIcons(
                    leading = common.core.onLight.textSecondary.main,
                    disabledLeading = common.core.onLight.textDisabled.main,
                    errorLeading = common.core.error.main,
                    trailing = common.core.onLight.textSecondary.main,
                    disabledTrailing = common.core.onLight.textDisabled.main,
                    errorTrailing = common.core.error.main
                ),
                border = TextFieldBorder(
                    focused = common.core.primary.main,
                    unfocused = mutableStateOf(Transparent),
                    disabled = mutableStateOf(Transparent),
                    error = mutableStateOf(Transparent)
                )
            )
        ),
        globalSearch = GlobalSearch(
            text = TextFieldText(
                normal = common.core.onDark.textSecondary.main,
                disabled = common.core.onDark.textDisabled.main,
            ),
            placeholder = TextFieldPlaceholder(
                normal = common.core.onDark.textDisabled.main,
                disabled = common.core.onDark.textDisabled.main
            ),

            background = TextFieldBackground(
                normal = mutableStateOf(
                    AppColorUtils.getColorWithOpacity(
                        inputColor = common.core.onDark.textPrimary.main.value,
                        inputOpacity = ColorOpacities.LOWEST
                    )
                ),
                disabled = mutableStateOf(
                    AppColorUtils.getColorWithOpacity(
                        inputColor = common.core.onDark.textPrimary.main.value,
                        inputOpacity = ColorOpacities.LOWEST
                    )
                )
            ),
            icons = TextFieldIcons(
                leading = common.core.onDark.textSecondary.main,
                trailing = common.core.onDark.textSecondary.main,
                errorLeading = common.core.error.main,
                disabledTrailing = common.core.onDark.textSecondary.main,
                errorTrailing = common.core.error.main,
                disabledLeading = common.core.onDark.textSecondary.main
            ),
            border = TextFieldBorder(
                focused = common.core.primary.main,
                unfocused = mutableStateOf(AppColorUtils.getColorWithOpacity(
                    inputColor = common.core.onDark.textPrimary.main.value,
                    inputOpacity = ColorOpacities.LOWEST
                )),
                disabled = mutableStateOf(Transparent),
                error = mutableStateOf(Transparent)
            )
        )

    )

    fun getButtonColors() = ButtonColors(

        highEmphasis = ButtonItem(
            container = primary.main,
            content = primary.contrastText,
            outline = mutableStateOf(Transparent),
            disabledContainer = input.disabledBackgroundColor,
            disabledContent = textDisabled.main,
            disabledOutline = mutableStateOf(Transparent)
        ),

        mediumEmphasis = ButtonItem(
            container = background.surface,
            content = primary.contrastText,//This will be overridden
            outline = primary.contrastText,//This will be overridden
            disabledContainer = background.surface,
            disabledContent = textDisabled.main,
            disabledOutline = textDisabled.main
        ),

        lowEmphasis = ButtonItem(
            container = mutableStateOf(Transparent),
            content = primary.main,
            outline = mutableStateOf(Transparent),
            disabledContainer = mutableStateOf(Transparent),
            disabledContent = textDisabled.main,
            disabledOutline = mutableStateOf(Transparent)
        )

    )

    fun getChipsColors() = ChipsColors(
        default = ChipsColorItem(
            background = textSecondary.main,
            text = textSecondary.contrastText
        ),
        info = ChipsColorItem(
            background = info.main,
            text = info.contrastText
        ),
        warning = ChipsColorItem(
            background = warning.main,
            text = warning.contrastText
        ),
        success = ChipsColorItem(
            background = success.main,
            text = success.contrastText
        ),
        error = ChipsColorItem(
            background = error.main,
            text = error.contrastText
        ),
        primary = ChipsColorItem(
            background = primary.main,
            text = primary.contrastText
        ),
        secondary = ChipsColorItem(
            background = secondary.main,
            text = secondary.contrastText
        )
    )
}