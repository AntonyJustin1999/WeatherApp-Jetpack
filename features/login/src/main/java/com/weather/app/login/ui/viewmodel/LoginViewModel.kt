package com.weather.app.login.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.common.model.domain.AuthAppData
import com.weather.app.common.model.domain.AuthInput
import com.weather.app.core.data.localsource.datastore.ScnxDatastore
import com.weather.app.core.repository.Auth.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthenticationRepository,
    private val authAppData: AuthAppData,
    private val scnxDatastore: ScnxDatastore,
):ViewModel() {
    var loading = mutableStateOf(false)
    var showErrorPopup = mutableStateOf(false)
    val signInState: MutableState<SignInState> = mutableStateOf(SignInState.NOT_SIGN_IN)

    fun login(userCredentials: AuthInput) {

        viewModelScope.launch(Dispatchers.IO) {
            signInState.value = SignInState.SIGN_IN_ONGOING

            authRepository
                .login(
                    userCredentials = userCredentials,
                    authAppData = authAppData
                )
                .catch { error ->
                    run {
                        signInState.value = SignInState.FAILED
                        loading.value = false
                        showErrorPopup.value = true
                    }
                }
                .collect {
                    authRepository
                        .decrypt()
                        .catch { error ->
                            run {
                                signInState.value = SignInState.FAILED
                                loading.value = false
                                showErrorPopup.value = true

                            }
                        }
                        .collect {
                            signInState.value = SignInState.SUCCESS
                            loading.value = false
                            showErrorPopup.value = false
                        }
                }

        }
    }

}

enum class SignInState {
    NOT_SIGN_IN,
    SIGN_IN_ONGOING,
    FAILED,
    SUCCESS
}