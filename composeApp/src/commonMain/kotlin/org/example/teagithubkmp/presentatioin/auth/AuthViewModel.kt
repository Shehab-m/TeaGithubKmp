package org.example.teagithubkmp.presentatioin.auth

import com.teacomputers.teagithub.presentation.auth.AuthUiState
import org.example.teagithubkmp.presentatioin.base.BaseViewModel
import org.example.teagithubkmp.domain.usecase.GetAccessTokenUseCase

class AuthViewModel(
//    private val oAuthManager: OAuthManager,
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
) : BaseViewModel<AuthUiState, AuthUiEffect>(AuthUiState()), AuthInteractionListener {

    override fun onClickLogin() {
//        val intent = oAuthManager.getOAuthIntent()
//        sendEffect(AuthUiEffect.HandleOauthIntent(intent))
    }

//    fun onOAuthCallback(intent: Intent) {
//        val code = oAuthManager.onOAuthCallback(intent)
//        getAccessToken(code)
//    }

    private fun getAccessToken(code: String?) {
        updateState { it.copy(isLoading = true) }
        tryToExecute(
            { getAccessTokenUseCase(code) },
            ::onSuccessGetAccessToken,
            ::onError
        )
    }

    private fun onSuccessGetAccessToken(accessToken: String) {
        sendEffect(AuthUiEffect.NavigateToReposScreen(accessToken))
    }

    private fun onError(error: Exception) {
        print("onError: ${error.message}")
        updateState { it.copy(isLoading = false) }
        sendEffect(AuthUiEffect.SendToast("Something went wrong. Please try again."))
    }

}