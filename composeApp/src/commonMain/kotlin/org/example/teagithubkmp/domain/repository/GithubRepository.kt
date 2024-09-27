package org.example.teagithubkmp.domain.repository

import org.example.teagithubkmp.domain.model.Repo

interface GithubRepository {
    suspend fun getAccessToken(code: String): String
    suspend fun getRepos(token: String): List<Repo>
    suspend fun getAccessTokenLocal(): String?
    suspend fun saveAccessTokenLocal(token: String)
}