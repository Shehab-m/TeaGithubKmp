package org.example.teagithubkmp.di

import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module


val sharedModule = module {
//    singleOf(::TestRepositoryImpl).bind<TestRepository>()
//    viewModelOf(::TestViewModel)
}