package org.example.teagithubkmp.presentatioin.splash

import org.example.teagithubkmp.presentatioin.base.BaseUiEffect

sealed interface SplashUiEffect : BaseUiEffect {
    data class NavigateToReposScreen(val accessToken: String): SplashUiEffect
    data object NavigateToAuthScreen: SplashUiEffect
}