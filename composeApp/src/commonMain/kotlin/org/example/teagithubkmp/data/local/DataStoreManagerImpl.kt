package org.example.teagithubkmp.data.local

expect class DataStoreManagerImpl: DataStoreManager {
    override suspend fun getAccessToken(): String?
    override suspend fun saveAccessToken(token: String)
}
