package org.example.teagithubkmp.di

import org.example.teagithubkmp.domain.usecase.GetAccessTokenLocalUseCase
import org.example.teagithubkmp.domain.usecase.GetAccessTokenUseCase
import org.example.teagithubkmp.domain.usecase.GetReposUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val usecaseModule = module {
    singleOf(::GetAccessTokenUseCase)
    singleOf(::GetReposUseCase)
    singleOf(::GetAccessTokenLocalUseCase)
}