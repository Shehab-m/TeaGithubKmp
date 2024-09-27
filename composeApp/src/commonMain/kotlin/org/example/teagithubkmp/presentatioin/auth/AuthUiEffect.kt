package org.example.teagithubkmp.presentatioin.auth

import org.example.teagithubkmp.presentatioin.base.BaseUiEffect

sealed interface AuthUiEffect : BaseUiEffect {
//    data class HandleOauthIntent(val intent: Intent): AuthUiEffect
    data class SendToast(val message: String): AuthUiEffect
    data class NavigateToReposScreen(val accessToken: String): AuthUiEffect
}