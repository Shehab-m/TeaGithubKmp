package org.example.teagithubkmp.util

import io.ktor.client.engine.okhttp.OkHttp

actual fun getClientEngine() = OkHttp.create()