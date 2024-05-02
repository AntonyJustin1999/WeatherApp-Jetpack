package com.weather.app.login.ui.view

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.weather.app.common.model.domain.AuthInput
import com.weather.app.common.ui.components.foundations.ButtonSize
import com.weather.app.common.ui.components.foundations.ScnxButton
import com.weather.app.common.ui.components.foundations.ScnxOutlineTextField
import com.weather.app.common.ui.components.foundations.TextFieldType
import com.weather.app.common.ui.theme.appThemeColors
import com.weather.app.common.ui.theme.baseDensityIndependentPixels
import com.weather.app.common.ui.theme.roundedCornerShapeSize
import com.weather.app.login.model.LoginCard
import com.weather.app.login.ui.R
import com.weather.app.login.ui.viewmodel.LoginViewModel


private val CARD_ELEVATION = (0.5 * baseDensityIndependentPixels).dp
private val CARD_PADDING_VERTICAL = (3 * baseDensityIndependentPixels).dp
private val CARD_PADDING_HORIZONTAL = (3 * baseDensityIndependentPixels).dp
private val ROUNDED_CORNER_SHAPE_SIZE = roundedCornerShapeSize.dp
private val LOGO_WIDTH = (baseDensityIndependentPixels * 19).dp
private val LOGO_HEIGHT = (baseDensityIndependentPixels * 4).dp
private val COLUMN_HORIZONTAL_PADDING = baseDensityIndependentPixels.dp
private val SPACER_HEIGHT = (1 * baseDensityIndependentPixels).dp
private val BOTTOM_SPACER_HEIGHT = (1.75 * baseDensityIndependentPixels).dp

@Composable
fun LoginCardView(
    navController: NavHostController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
   val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
//    val snackbarType = remember {
//        mutableStateOf(ScnxSnackbarType.ERROR)
//    }

//    LaunchedEffect(viewModel.signInState.value){
//        if(viewModel.signInState.value == SignInState.FAILED){
//            snackbarHostState.showSnackbar(
//                message = "Login Failed. Please try again.",
//                duration = SnackbarDuration.Long
//            )
//        }
//    }

//   if (viewModel.signInState.value == SignInState.SUCCESS) {
//        LaunchedEffect(Unit) {
//            Log.d("TAG", "Success")
//            navController.popBackStack()
//            //TODO need to be updated after login and sync features is completed
//            if (viewModel.isFirstEverSynced()) {
//                viewModel.triggerSyncProcess(context)
//                navController.navigate(Screens.SyncFirstTime.route)
//            } else {
//                navController.navigate(Screens.Dashboard.route)
//            }
//        }
//   }

}

@Composable
private fun LoginCardUI(navController: NavHostController,
                        viewModel: LoginViewModel) {
    val loginCardColors = LoginCard(
        background = MaterialTheme.appThemeColors.background.paper.value
    )
    //TextFields
    var email by remember { mutableStateOf(TextFieldValue("tulja.devi@sparescnx.com")) }
    var password by remember { mutableStateOf(TextFieldValue("Testqa123#")) }
    var hasError by remember { mutableStateOf(false) }
    val checkBox1 = remember {
        mutableStateOf(false)
    }

    val passwordInteractionState = remember { MutableInteractionSource() }
    val emailInteractionState = remember { MutableInteractionSource() }
    Card(
        elevation = CARD_ELEVATION,
        modifier = Modifier
            .padding(
                start = CARD_PADDING_VERTICAL,
                end = CARD_PADDING_HORIZONTAL
            ),
        shape = RoundedCornerShape(size = ROUNDED_CORNER_SHAPE_SIZE),
        backgroundColor = Color(0xFF212E60)

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = COLUMN_HORIZONTAL_PADDING)
        ) {
            item { Spacer(modifier = Modifier.height(10.dp)) }
            item {
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    text = "Login",
                    color = Color.White
                )
            }
            item { Spacer(modifier = Modifier.height(SPACER_HEIGHT)) }
            item {
                ScnxOutlineTextField(
                    type = TextFieldType.USERNAME,
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    isError = hasError,
                    placeholderText = stringResource(id = R.string.emailorusername),
                    onValueChange = {
                        email = it
                        isEnableLoginButton(email.text, password.text, checkBox1)
                    },
                    interactionSource = emailInteractionState,

                    )
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item {
                ScnxOutlineTextField(
                    type = TextFieldType.PASSWORD,
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    isError = hasError,
                    placeholderText = stringResource(id = R.string.password),
                    onValueChange = {
                        password = it
                        isEnableLoginButton(email.text, password.text, checkBox1)
                    },
                    interactionSource = passwordInteractionState,
                )
            }
            item { Spacer(modifier = Modifier.height(10.dp)) }
            item {
                val mAnnotatedLinkString = buildAnnotatedString {
                    val strAgree = "I agree to the Terms of Service"
                    val mStartIndex = strAgree.indexOf("Terms of Service")
                    val mEndIndex = mStartIndex + 16

                    append(strAgree)
                    addStyle(
                        style = SpanStyle(
                            color = Color.White,
                            textDecoration = TextDecoration.Underline
                        ), start = mStartIndex, end = mEndIndex
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkBox1.value, onCheckedChange = {
                            checkBox1.value = it
                            isEnableLoginButton(email.text, password.text, checkBox1)
                        }, colors = CheckboxDefaults.colors(
                            checkedColor = Color.Blue,
                            uncheckedColor = Color.Gray
                        )
                    )
                    ClickableText(
                        text = mAnnotatedLinkString,
                        style = TextStyle(
                            color = Color.White
                        ),
                        onClick = {
                            mAnnotatedLinkString
                                .getStringAnnotations("URL", it, it)
                                .firstOrNull()?.let { stringAnnotation ->
                                }
                        }
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(10.dp)) }
            item {
                ScnxButton(
                    buttonText = stringResource(id = R.string.login),
                    enabled = isEnableLoginButton(email.text, password.text, checkBox1),
                    onClick = {
                        viewModel.loading.value = true
                        if (invalidInput(email.text, password.text)) {
                            hasError = true
                        } else {
                            hasError = false
                            val authInput = AuthInput(email.text, password.text)
                            viewModel.login(authInput)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    size = ButtonSize.SMALL
                )
                Spacer(modifier = Modifier.height(BOTTOM_SPACER_HEIGHT))
            }
        }
    }
}
fun isValidateEmail(email:String):Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isEnableLoginButton(email: String, password: String, checkBox1: MutableState<Boolean>):Boolean{
    return isValidateEmail(email) && email.isNotEmpty() && password.isNotEmpty() && checkBox1.value
}
