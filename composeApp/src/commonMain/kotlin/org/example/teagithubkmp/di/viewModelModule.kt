package org.example.teagithubkmp.di

import androidx.lifecycle.SavedStateHandle
import org.example.teagithubkmp.presentatioin.auth.AuthViewModel
import org.example.teagithubkmp.presentatioin.repos.ReposViewModel
import org.example.teagithubkmp.presentatioin.splash.SplashViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::AuthViewModel)
    viewModelOf(::SplashViewModel)
    viewModel { (handle: SavedStateHandle) ->
        ReposViewModel(get(), handle)
    }
}