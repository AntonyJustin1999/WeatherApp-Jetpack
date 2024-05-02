package com.weather.app.common.ui.components.foundations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.weather.app.common.ui.theme.appThemeColors

@Composable
fun LoadDialogState(
    text: String = "Loading...",
    dismissOnBackPress:Boolean = true,
    dismissOnClickOutside:Boolean = true,
    onDismissRequest :() -> Unit = {},
    loadingType:String = "default"
) {
    if(loadingType == "default"){
        Dialog(onDismissRequest = onDismissRequest,
            DialogProperties(dismissOnBackPress = dismissOnBackPress, dismissOnClickOutside = dismissOnClickOutside)
        ) {
            Box(
                contentAlignment= Alignment.Center,
                modifier = Modifier.padding(20.dp)
                    .size(100.dp)
                    .background(White, shape = RoundedCornerShape(12.dp))
            ) {
                CircularProgressIndicator(modifier = Modifier.padding(0.dp), color = MaterialTheme.appThemeColors.textSecondary.main.value)
                /*Text(text = text)*/

            }
        }
    }else{
        Dialog(onDismissRequest = onDismissRequest,
            DialogProperties(dismissOnBackPress = dismissOnBackPress, dismissOnClickOutside = dismissOnClickOutside)) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier,
                elevation = 8.dp
            ) {
                Column(
                    Modifier
                        .background(Color.White)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Downloading...",
                        Modifier
                            .padding(8.dp), textAlign = TextAlign.Center
                    )

                    CircularProgressIndicator(
                        strokeWidth = 4.dp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp),
                        color = MaterialTheme.appThemeColors.textSecondary.main.value
                    )
                }
            }
        }
    }
}