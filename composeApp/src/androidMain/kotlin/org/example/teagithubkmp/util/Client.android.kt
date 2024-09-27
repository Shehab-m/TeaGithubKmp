package org.example.teagithubkmp.util

import org.example.teagithubkmp.BuildConfig


actual fun getClientSecret() = BuildConfig.CLIENT_SECRET

actual fun getClientId() = BuildConfig.CLIENT_ID