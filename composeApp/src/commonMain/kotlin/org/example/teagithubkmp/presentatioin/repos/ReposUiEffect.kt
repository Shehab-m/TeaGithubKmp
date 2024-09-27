package org.example.teagithubkmp.presentatioin.repos

import org.example.teagithubkmp.presentatioin.base.BaseUiEffect

sealed interface ReposUiEffect : BaseUiEffect {
    data class SendToast(val message: String): ReposUiEffect
}