package org.example.teagithubkmp.data.local

interface DataStoreManager {
    suspend fun getAccessToken(): String?
    suspend fun saveAccessToken(token: String)
}