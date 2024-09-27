package org.example.teagithubkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform