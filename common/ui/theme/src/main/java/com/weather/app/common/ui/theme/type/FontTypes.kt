package com.weather.app.common.ui.theme.type

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.spares.propeller.commons.ui.theme.*
import com.spares.propeller.commons.ui.theme.type.AnchorTabTypography
import com.spares.propeller.commons.ui.theme.type.BadgesTypography
import com.spares.propeller.commons.ui.theme.type.ButtonTypography
import com.spares.propeller.commons.ui.theme.type.CheckboxTypography
import com.spares.propeller.commons.ui.theme.type.ChipsTypography
import com.spares.propeller.commons.ui.theme.type.DesignTypography
import com.spares.propeller.commons.ui.theme.type.FilterTypography
import com.spares.propeller.commons.ui.theme.type.QtyCounterTypography
import com.spares.propeller.commons.ui.theme.type.RadioButtonTypography
import com.spares.propeller.commons.ui.theme.type.SectionCounterTypography
import com.spares.propeller.commons.ui.theme.type.TextFieldTypography
import com.weather.app.common.ui.theme.*


@OptIn(ExperimentalTextApi::class)
object FontTypes{

    val design = DesignTypography(

        h1Bold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (h1FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h1LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h1Black = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
            fontSize = (h1FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h1LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h1SemiBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontSize = (h1FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h1LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h1Medium = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = (h1FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h1LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        h2Bold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (h2FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h2LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h2Black = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
            fontSize = (h2FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h2LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h2SemiBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontSize = (h2FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h2LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h2Medium = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = (h2FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h2LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        h3Bold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (h3FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h3LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h3Black = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
            fontSize = (h3FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h3LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h3SemiBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontSize = (h3FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h3LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h3Medium = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = (h3FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h3LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        h4Bold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (h4FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h4LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h4Black = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
            fontSize = (h4FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h4LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h4SemiBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontSize = (h4FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h4LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h4Medium = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = (h4FontSizeScale * baseScalablePixels).sp,
            lineHeight = (h4LineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        overLineBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (overLineFontSizeScale * baseScalablePixels).sp,
            lineHeight = (overLineLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        overLineBlack = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
            fontSize = (overLineFontSizeScale * baseScalablePixels).sp,
            lineHeight = (overLineLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        overLineSemiBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontSize = (overLineFontSizeScale * baseScalablePixels).sp,
            lineHeight = (overLineLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        overLineMedium =TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = (overLineFontSizeScale * baseScalablePixels).sp,
            lineHeight = (overLineLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        buttonBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (buttonScale * baseScalablePixels).sp,
            lineHeight = (buttonLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        buttonBlack = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
            fontSize = (buttonScale * baseScalablePixels).sp,
            lineHeight = (buttonLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        buttonSemiBold = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontSize = (buttonScale * baseScalablePixels).sp,
            lineHeight = (buttonLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        buttonMedium = TextStyle(
            fontFamily = Raleway,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = (buttonScale * baseScalablePixels).sp,
            lineHeight = (buttonLineHeightScale * baseScalablePixels).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        body1Regular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (bodyOneScale * baseScalablePixels).sp,
            lineHeight = (bodyOneLineHeightScale * baseScalablePixels).sp,
        ),
        body1Bold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (bodyOneScale * baseScalablePixels).sp,
            lineHeight = (bodyOneLineHeightScale * baseScalablePixels).sp
        ),
        body1Italic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = (bodyOneScale * baseScalablePixels).sp,
            lineHeight = (bodyOneLineHeightScale * baseScalablePixels).sp,
        ),

        body2Regular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (bodyTwoScale * baseScalablePixels).sp,
            lineHeight = (bodyTwoLineHeightScale * baseScalablePixels).sp
        ),
        body2Bold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (bodyTwoScale * baseScalablePixels).sp,
            lineHeight = (bodyTwoLineHeightScale * baseScalablePixels).sp
        ),
        body2Italic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = (bodyTwoScale * baseScalablePixels).sp,
            lineHeight = (bodyTwoLineHeightScale * baseScalablePixels).sp,
        ),

        captionRegular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (captionScale * baseScalablePixels).sp,
            lineHeight = (captionLineHeightScale * baseScalablePixels).sp
        ),

        captionBold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (captionScale * baseScalablePixels).sp,
            lineHeight = (captionLineHeightScale * baseScalablePixels).sp
        ),
        captionItalic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = (captionScale * baseScalablePixels).sp,
            lineHeight = (captionLineHeightScale * baseScalablePixels).sp
        ),

        selectBottomSheetOptionRegular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (selectOptionScale * baseScalablePixels).sp,
            lineHeight = (selectOptionLineHeightScale * baseScalablePixels).sp
        ),

        selectBottomSheetOptionBold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (selectOptionScale * baseScalablePixels).sp,
            lineHeight = (selectOptionLineHeightScale * baseScalablePixels).sp
        ),
        selectBottomSheetOptionItalic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = (selectOptionScale * baseScalablePixels).sp,
            lineHeight = (selectOptionLineHeightScale * baseScalablePixels).sp
        ),

        tabCounterRegular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (tabCounterScale * baseScalablePixels).sp,
            lineHeight = (tabCounterLineHeightScale * baseScalablePixels).sp
        ),
        tabCounterBold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (tabCounterScale * baseScalablePixels).sp,
            lineHeight = (tabCounterLineHeightScale * baseScalablePixels).sp
        ),
        tabCounterItalic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = (tabCounterScale * baseScalablePixels).sp,
            lineHeight = (tabCounterLineHeightScale * baseScalablePixels).sp
        ),
        valueStepperRegular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (valueStepperScale * baseScalablePixels).sp,
            lineHeight = (valueStepperLineHeightScale * baseScalablePixels).sp
        ),
        valueStepperBold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (valueStepperScale * baseScalablePixels).sp,
            lineHeight = (valueStepperLineHeightScale * baseScalablePixels).sp
        ),
        valueStepperItalic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = (valueStepperScale * baseScalablePixels).sp,
            lineHeight = (valueStepperLineHeightScale * baseScalablePixels).sp
        ),
        badgeRegular = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = (badgeFontSizeScale * baseScalablePixels).sp,
            lineHeight = (badgeLineHeightScale * baseScalablePixels).sp
        ),
        badgeBold = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = (badgeFontSizeScale * baseScalablePixels).sp,
            lineHeight = (badgeLineHeightScale * baseScalablePixels).sp,
        ),
        badgeItalic = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = (badgeFontSizeScale * baseScalablePixels).sp,
            lineHeight = (badgeLineHeightScale * baseScalablePixels).sp
        )
    )

    val button = ButtonTypography(
        text = design.button
    )

    val chips = ChipsTypography(
        text = design.overLineMedium
    )

    val anchorTab = AnchorTabTypography(
        number = design.tabCounter,
        text = design.body2Bold,
        name = design.overLineMedium
    )

    val textFields = TextFieldTypography(
        label = design.captionRegular,
        text = design.body1Regular,
        placeholder = design.body1Regular,
        dropdownText = design.body1Regular,
        multiSelectDropdownText=design.overLineMedium,
        multiSelectDropdownChip = design.overLineMedium
    )

    val filter = FilterTypography(
        text = design.h4SemiBold,
        badgeNumber = design.body2Bold,
    )


    val badges = BadgesTypography(
        text = design.badge,
    )

    val qtyCounter = QtyCounterTypography(
        text = design.body1Bold,
    )

    val sectionCounter = SectionCounterTypography(
        text = design.body2Bold,
    )

    val checkbox = CheckboxTypography(
        text = design.body2Regular
    )

    val radioButton = RadioButtonTypography(
        text = design.body2Regular
    )
    val dialogTitle = RadioButtonTypography(
        text = design.h2Bold
    )

    val dialogSubTitle = RadioButtonTypography(
        text = design.body1Regular
    )
}

