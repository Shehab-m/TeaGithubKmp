package org.example.teagithubkmp.di

import org.example.teagithubkmp.data.local.DataStoreManager
import org.example.teagithubkmp.data.local.DataStoreManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DataStoreManagerImpl).bind<DataStoreManager>()
}