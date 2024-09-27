package org.example.teagithubkmp.util

import io.ktor.client.engine.darwin.Darwin

actual fun getClientEngine() = Darwin.create()