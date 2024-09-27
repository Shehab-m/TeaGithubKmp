package org.example.teagithubkmp.presentatioin.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import org.example.teagithubkmp.domain.usecase.GetAccessTokenLocalUseCase

class SplashViewModel(private val getAccessTokenLocalUseCase: GetAccessTokenLocalUseCase) :
    ViewModel() {

    private val _effect = MutableSharedFlow<SplashUiEffect>()
    val effect = _effect.asSharedFlow().mapNotNull { it }

    init {
        checkNavigationDestination()
    }

    private fun checkNavigationDestination() {
        viewModelScope.launch {
            val accessToken = getAccessTokenLocalUseCase()
            delay(2500)
            accessToken?.let { token ->
                _effect.emit(SplashUiEffect.NavigateToReposScreen(token))
            } ?: _effect.emit(SplashUiEffect.NavigateToAuthScreen)
        }
    }
}