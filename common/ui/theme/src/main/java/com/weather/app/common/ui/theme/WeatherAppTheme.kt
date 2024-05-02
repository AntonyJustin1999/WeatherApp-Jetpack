package com.weather.app.common.ui.theme

//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.weather.app.common.ui.theme.model.color.APPColors
import com.weather.app.common.ui.theme.model.color.appthemeColors
import com.weather.app.common.ui.theme.model.color.defaultPropellerColors
import com.weather.app.common.ui.theme.type.FontTypes

//private val DarkColorScheme = darkColors(
//    primary = Purple80,
//    secondary = PurpleGrey80
//)

//private val LightColorScheme = lightColors(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)

//@Composable
//fun WeatherAppTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
////    val colorScheme = when {
////        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
////            val context = LocalContext.current
////            //if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
////        }
////
////        darkTheme -> DarkColorScheme
////        else -> LightColorScheme
////    }
////    val view = LocalView.current
////    if (!view.isInEditMode) {
////        SideEffect {
////            val window = (view.context as Activity).window
////            window.statusBarColor = colorScheme.primary.toArgb()
////            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
////        }
////    }
//
//    val colorScheme = LightColorScheme
//        MaterialTheme(
//        colors = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}

private val weatherColorsProvider = staticCompositionLocalOf {
    defaultPropellerColors()
}
private val weatherTypeProvider = staticCompositionLocalOf {
    FontTypes
}

@Composable
fun WeatherAppTheme(
    isDarkTheme: MutableState<Boolean>,
    content: @Composable () -> Unit,
) {
    val colorsAsPerTheme =  appthemeColors(isDarkTheme = isDarkTheme)
    val colors = remember {
        colorsAsPerTheme.clone()
    }.apply {
        updateFrom(colorsAsPerTheme)
    }

    val type = FontTypes
    CompositionLocalProvider(
        weatherColorsProvider provides colors ,
        weatherTypeProvider provides type,
    ) {
        MaterialTheme(
            content = content,
            colorScheme = colors.materialColorScheme
        )
    }
}

val MaterialTheme.appThemeColors: APPColors
    @Composable
    @ReadOnlyComposable
    get() = weatherColorsProvider.current

val MaterialTheme.appTypography: FontTypes
    @Composable
    @ReadOnlyComposable
    get() = weatherTypeProvider.current