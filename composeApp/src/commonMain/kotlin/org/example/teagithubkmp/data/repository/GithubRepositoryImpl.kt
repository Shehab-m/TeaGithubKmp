package org.example.teagithubkmp.data.repository

import org.example.teagithubkmp.data.local.DataStoreManager
import org.example.teagithubkmp.data.remote.GithubApiService
import org.example.teagithubkmp.data.repository.mapper.toEntity
import org.example.teagithubkmp.domain.model.Repo
import org.example.teagithubkmp.domain.repository.GithubRepository

class GithubRepositoryImpl(
    private val apiService: GithubApiService,
    private val dataStore: DataStoreManager,
) : GithubRepository {

    override suspend fun getAccessToken(code: String): String {
        return apiService.getAccessToken(code)
    }

    override suspend fun getAccessTokenLocal(): String? {
        return dataStore.getAccessToken()
    }

    override suspend fun saveAccessTokenLocal(token: String) {
        dataStore.saveAccessToken(token)
    }

    override suspend fun getRepos(token: String): List<Repo> {
        val bearerToken = "Bearer $token"
        return apiService.getRepos(bearerToken).map { it.toEntity() }

    }
}