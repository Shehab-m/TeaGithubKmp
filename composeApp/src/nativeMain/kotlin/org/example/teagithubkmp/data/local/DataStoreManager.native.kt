package org.example.teagithubkmp.data.local

actual class DataStoreManagerImpl: DataStoreManager {
    private val userDefaults = NSUserDefaults.standardUserDefaults

    actual override suspend fun getAccessToken(): String? {
        return userDefaults.stringForKey(ACCESS_TOKEN_KEY)
    }

    actual override suspend fun saveAccessToken(token: String) {
        userDefaults.setObject(token, ACCESS_TOKEN_KEY)
    }

    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token"
    }
}